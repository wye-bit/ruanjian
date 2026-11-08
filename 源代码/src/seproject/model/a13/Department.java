package seproject.model.a13;

import java.util.ArrayList;
import java.util.List;

/** A1-3 系：属于 1 个学院，拥有 1..* 位教师、提供 1..* 门课程。 */
public class Department {

    private String name;
    private String code;
    private School school;
    private final List<Instructor> instructors = new ArrayList<>();
    private final List<Subject> subjects = new ArrayList<>();

    public Department(String name, String code) {
        this.name = name;
        this.code = code;
    }

    void attachTo(School school) {
        this.school = school;
    }

    public void addInstructor(Instructor instructor) {
        if (!instructors.contains(instructor)) {
            instructors.add(instructor);
            instructor.attachTo(this);
        }
    }

    public void addSubject(Subject subject) {
        if (!subjects.contains(subject)) {
            subjects.add(subject);
            subject.addDepartment(this);
        }
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public School getSchool() {
        return school;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }
}
