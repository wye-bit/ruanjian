package seproject;

import java.time.LocalDate;

import seproject.model.a11.Thoroughbred;
import seproject.model.a12.Building;
import seproject.model.a12.College;
import seproject.model.a12.Course;
import seproject.model.a13.Department;
import seproject.model.a13.Instructor;
import seproject.model.a13.School;
import seproject.model.a13.Student;
import seproject.model.a13.Subject;
import seproject.model.a14.Cash;
import seproject.model.a14.Customer;
import seproject.model.a14.Order;
import seproject.model.a14.OrderDetail;
import seproject.model.a14.OrderStatus;
import seproject.model.a14.Product;

/** 四个模型的运行示例，用于验证代码与类图一致。 */
public class Main {

    public static void main(String[] args) {
        demoA11();
        demoA12();
        demoA13();
        demoA14();
    }

    private static void demoA11() {
        Thoroughbred sire = new Thoroughbred(2016);
        Thoroughbred dam = new Thoroughbred(2017);
        Thoroughbred colt = new Thoroughbred(2022, sire, dam);
        System.out.println("A1-1 马驹 " + colt + "，年龄 " + colt.getCurrentAge() + " 岁");
        System.out.println("      父亲 " + colt.getFather() + "，母亲 " + colt.getMother());
    }

    private static void demoA12() {
        College college = new College("计算机与信息学院", "宜昌");
        Building building = new Building("实验楼", 5);
        building.addRoom("B201");
        college.addBuilding(building);
        Course course = new Course("SE301", "软件工程", 3, building);
        college.addCourse(course);
        System.out.println("A1-2 学院 " + college.getName() + " 有建筑 " + college.getBuildings().size()
                + " 幢、课程 " + college.getCourses().size() + " 门");
        System.out.println("      课程安排：" + course.getSchedule());
    }

    private static void demoA13() {
        School school = new School("计算机与信息学院", "宜昌");
        Department department = new Department("软件工程系", "SE");
        school.addDepartment(department);
        Instructor instructor = new Instructor("张老师", "副教授");
        department.addInstructor(instructor);
        Subject subject = new Subject("软件工程", 3);
        department.addSubject(subject);
        instructor.addSubject(subject);
        Student student = new Student("王同学", "2024107601");
        school.addStudent(student);
        student.enroll(subject);
        System.out.println("A1-3 学院有 " + school.getDepartmentCount() + " 个系、"
                + school.getStudentCount() + " 名学生");
        System.out.println("      " + instructor.getName() + " 在 " + department.getName()
                + " 授课，课程 " + subject.getName() + " 的选课人数 " + subject.getStudents().size());
    }

    private static void demoA14() {
        Customer customer = new Customer("李同学", "13800000000", "宜昌市大学路 8 号", true);
        Product book = new Product("软件工程教材", 0.6, "教材", 59.0);
        Product pen = new Product("签字笔", 0.02, "文具", 3.5);

        Order order = new Order(LocalDate.now());
        customer.placeOrder(order);
        order.addDetail(new OrderDetail(book, 1));
        order.addDetail(new OrderDetail(pen, 4));

        System.out.printf("A1-4 订单金额 %.2f 元，总重 %.2f 千克，状态 %s%n",
                order.calcTotal(), order.calcWeight(), order.getStatus());

        Cash cash = new Cash();
        boolean ok = order.pay(cash);
        System.out.printf("      现金支付 %s，状态 %s，实付 %.2f 元%n",
                ok ? "成功" : "失败", order.getStatus(), cash.getCashTendered());
        order.ship();
        order.deliver();
        System.out.println("      发货后状态 " + order.getStatus() + "，上限状态 " + OrderStatus.CANCEL);
    }
}
