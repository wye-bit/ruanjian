# 软件工程实验三：UML 类图建模对应的 Java 实现

目录说明：

- src/seproject/model/a11/Thoroughbred.java          对应图 1（A1-1 优良品质的马）
- src/seproject/model/a12/Building.java, Course.java, College.java
　　　　　　　　　　　　　　　　　　　　　　　　　对应图 2（A1-2 聚合与组合、约束注释）
- src/seproject/model/a13/School.java, Department.java, Instructor.java, Subject.java, Student.java
　　　　　　　　　　　　　　　　　　　　　　　　　对应图 3（A1-3 学院组织结构与多重性）
- src/seproject/model/a14/                        对应图 4（A1-4 网上购物系统）
- src/seproject/Main.java                          四个模型的运行示例

编译与运行（JDK 8 及以上）：

    javac -encoding UTF-8 -d out (Get-ChildItem -Recurse src -Filter *.java).FullName
    java -cp out seproject.Main

类图与代码的对应关系：属性对应私有字段，操作对应公有方法，可见性对应访问修饰符，
多重性对应集合或单个引用，聚合与组合在代码中体现在对象引用的持有方式与生命周期管理上，
泛化对应父类与子类的继承关系，状态枚举对应 OrderStatus。
