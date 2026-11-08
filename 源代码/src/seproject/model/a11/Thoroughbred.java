package seproject.model.a11;

import java.time.LocalDate;

/**
 * A1-1 优良品质的马。
 * 属性 mother、father、birthyear 均为私有，三个操作对外公有，
 * 与类图中的可见性标注一一对应。
 */
public class Thoroughbred {

    private Thoroughbred mother;
    private Thoroughbred father;
    private int birthyear;

    public Thoroughbred(int birthyear) {
        this(birthyear, null, null);
    }

    public Thoroughbred(int birthyear, Thoroughbred father, Thoroughbred mother) {
        this.birthyear = birthyear;
        this.father = father;
        this.mother = mother;
    }

    /** 由出生年份与当前年份推算年龄，对应类图中的派生操作。 */
    public int getCurrentAge() {
        return LocalDate.now().getYear() - birthyear;
    }

    public Thoroughbred getFather() {
        return father;
    }

    public Thoroughbred getMother() {
        return mother;
    }

    public int getBirthyear() {
        return birthyear;
    }

    @Override
    public String toString() {
        return "Thoroughbred{born " + birthyear + "}";
    }
}
