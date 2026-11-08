package seproject.model.a13;

import java.util.ArrayList;
import java.util.List;

/** A1-3 课程：由 1..* 个系开设，被 1..* 位教师教授，被 0..* 名学生选修。 */
public class Subject {

    private String name;
    private int credits;
    private final List<Department> departments = new ArrayList<>();
    private final List<Instructor> instructors = new ArrayList<>();
    private final List<Student> students = new ArrayList<>();

    public Subject(String name, int credits) {
        this.name = name;
        this.credits = credits;
    }

    void addDepartment(Department department) {
        if (!departments.contains(department)) {
            departments.add(department);
        }
    }

    void addInstructor(Instructor instructor) {
        if (!instructors.contains(instructor)) {
            instructors.add(instructor);
        }
    }

    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public List<Student> getStudents() {
        return students;
    }
}
