package seproject.model.a13;

import java.util.ArrayList;
import java.util.List;

/** A1-3 指导教师：属于 1 个系，教授 1..3 门课程。 */
public class Instructor {

    private String name;
    private String title;
    private Department department;
    private final List<Subject> subjects = new ArrayList<>();

    public Instructor(String name, String title) {
        this.name = name;
        this.title = title;
    }

    void attachTo(Department department) {
        this.department = department;
    }

    /** 多重性上限 1..3：超过 3 门时拒绝继续添加。 */
    public void addSubject(Subject subject) {
        if (subjects.size() >= 3) {
            throw new IllegalStateException(name + " 已教授 3 门课程，不能再增加");
        }
        if (!subjects.contains(subject)) {
            subjects.add(subject);
            subject.addInstructor(this);
        }
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public Department getDepartment() {
        return department;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }
}
