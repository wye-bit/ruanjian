package seproject.model.a12;

/**
 * A1-2 学院开设的课程，随学院设立与撤销，与 College 是组合关系。
 * 图上的约束“Course 一定在某个 Building 中进行”在这里落实为：
 * building 字段不允许为空，构造和赋值时都做检查。
 */
public class Course {

    private String code;
    private String title;
    private int credits;
    private Building building;

    public Course(String code, String title, int credits, Building building) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        setBuilding(building);
    }

    public void setBuilding(Building building) {
        if (building == null) {
            throw new IllegalArgumentException("课程必须安排在某个建筑中进行");
        }
        this.building = building;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public int getCredits() {
        return credits;
    }

    public Building getBuilding() {
        return building;
    }

    public String getSchedule() {
        return code + " " + title + " @ " + building.getName();
    }

    @Override
    public String toString() {
        return "Course{" + code + "}";
    }
}
