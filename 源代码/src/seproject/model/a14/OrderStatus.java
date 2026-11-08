package seproject.model.a14;

/** A1-4 订单状态枚举，对应类图中 Order 的 status 属性取值。 */
public enum OrderStatus {
    CREATE,
    PAID,
    SHIPPING,
    DELIVERED,
    CANCEL
}
