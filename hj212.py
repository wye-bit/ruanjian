# hj212_parser.py
class HJ212Parser:
    """HJ212-2017 环保协议报文解析类"""

    def is_valid_message(self, message: str) -> bool:
        """检查报文整体格式是否符合HJ212-2017规范"""
        # 报文结构：## + 4位长度 + 数据段 + 4位CRC + \r\n
        if not message.startswith("##"):
            return False
        if not message.endswith("\r\n"):
            return False
        if len(message) < 2 + 4 + 4 + 2:
            return False
        # 提取4位长度字段，判断是否为数字
        length_str = message[2:6]
        if not length_str.isdigit():
            return False
        data_len = int(length_str)
        # 数据段 + CRC的长度应该等于length_str声明长度
        data_crc_part = message[6:-2]
        if len(data_crc_part) != data_len:
            return False
        return True

    def validate_crc(self, message: str) -> bool:
        """ANSI CRC16校验，初始0xFFFF，多项式0xA001，校验报文CRC"""
        if not self.is_valid_message(message):
            return False
        # 取出【## + 长度 + 数据段】部分，用于计算CRC
        msg_body = message[:-6]
        # 报文末尾4个字符是收到的CRC
        received_crc_hex = message[-6:-2]
        received_crc = int(received_crc_hex, 16)

        # ANSI CRC16 算法
        crc = 0xFFFF
        poly = 0xA001
        for char in msg_body:
            byte = ord(char)
            crc ^= byte
            for _ in range(8):
                if crc & 0x0001:
                    crc = (crc >> 1) ^ poly
                else:
                    crc >>= 1
        crc &= 0xFFFF
        return crc == received_crc

    def parse_data_segment(self, message: str) -> dict:
        """解析数据段，返回所有键值对（QN、ST、CN、PW、MN、CP等）"""
        result = {}
        if not self.is_valid_message(message):
            return result
        # 取出数据段部分（去掉##，4位长度，末尾4位CRC和\r\n）
        data_segment = message[6:-6]
        # 用分号分隔各个字段
        fields = data_segment.split(";")
        for field in fields:
            if "=" in field:
                k, v = field.split("=", 1)
                result[k] = v
        return result

    def extract_monitoring_data(self, message: str) -> dict:
        """从CP字段内提取监测因子（a01等）键值对"""
        data_dict = self.parse_data_segment(message)
        if "CP" not in data_dict:
            return {}
        # CP格式：&&数据&&
        cp_content = data_dict["CP"]
        if not (cp_content.startswith("&&") and cp_content.endswith("&&")):
            return {}
        cp_inner = cp_content[2:-2]
        items = cp_inner.split(",")
        monitor_data = {}
        for item in items:
            if "=" in item:
                k, v = item.split("=", 1)
                monitor_data[k] = v
        return monitor_data


# ============ 测试代码 ============
if __name__ == "__main__":
    # HJ212测试报文
    test_msg = "##0136QN=20261010000500;ST=32;CN=2011;PW=123456;MN=010000A8900016F00035;CP=&&DataTime=20261010000500,a01=12.34,a02=56.78&&1C7B\r\n"
    parser = HJ212Parser()

    print("1. 报文格式是否合法：", parser.is_valid_message(test_msg))
    print("2. CRC校验是否通过：", parser.validate_crc(test_msg))
    print("3. 全部数据段解析结果：")
    all_data = parser.parse_data_segment(test_msg)
    print(all_data)
    print("4. 监测因子数据：")
    monitor = parser.extract_monitoring_data(test_msg)
    print(monitor)
