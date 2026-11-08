package seproject.model.a13;

import java.util.ArrayList;
import java.util.List;

/** A1-3 学生：属于 1 个学院，参加 1..5 门课程的学习。 */
public class Student {

    private String name;
    private String studentNo;
    private School school;
    private final List<Subject> subjects = new ArrayList<>();

    public Student(String name, String studentNo) {
        this.name = name;
        this.studentNo = studentNo;
    }

    void attachTo(School school) {
        this.school = school;
    }

    /** 多重性上限 1..5：超过 5 门时拒绝继续选课。 */
    public void enroll(Subject subject) {
        if (subjects.size() >= 5) {
            throw new IllegalStateException(studentNo + " 已选修 5 门课程，不能再增加");
        }
        if (!subjects.contains(subject)) {
            subjects.add(subject);
            subject.addStudent(this);
        }
    }

    public String getName() {
        return name;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public School getSchool() {
        return school;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }
}
