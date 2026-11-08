package seproject.model.a12;

import java.util.ArrayList;
import java.util.List;

/** A1-2 学院：组合持有课程，聚合持有建筑。 */
public class College {

    private String name;
    private String address;
    private final List<Building> buildings = new ArrayList<>();
    private final List<Course> courses = new ArrayList<>();

    public College(String name, String address) {
        this.name = name;
        this.address = address;
    }

    /** 聚合：学院引用建筑，建筑自身仍有独立生命周期。 */
    public void addBuilding(Building building) {
        if (building != null && !buildings.contains(building)) {
            buildings.add(building);
        }
    }

    /** 组合：课程属于学院，课程所在的建筑也必须由本学院持有。 */
    public void addCourse(Course course) {
        if (course == null) {
            return;
        }
        Building building = course.getBuilding();
        if (!buildings.contains(building)) {
            throw new IllegalArgumentException("课程所在建筑不属于本学院：" + building.getName());
        }
        courses.add(course);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public List<Course> getCourses() {
        return courses;
    }
}
