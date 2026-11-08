package seproject.model.a13;

import java.util.ArrayList;
import java.util.List;

/** A1-3 学院：1 个学院由 1..* 个系构成（组合），并拥有 0..* 名学生（聚合）。 */
public class School {

    private String name;
    private String location;
    private final List<Department> departments = new ArrayList<>();
    private final List<Student> students = new ArrayList<>();

    public School(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public void addDepartment(Department department) {
        if (!departments.contains(department)) {
            departments.add(department);
            department.attachTo(this);
        }
    }

    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
            student.attachTo(this);
        }
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getDepartmentCount() {
        return departments.size();
    }

    public int getStudentCount() {
        return students.size();
    }
}
