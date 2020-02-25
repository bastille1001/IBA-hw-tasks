package hw06;

import java.util.Arrays;
import java.util.Objects;

public class Human {
    private String name;
    private String surname;
    private int year;
    private int iQ;

    private Family family;

    private String[][] schedule;

    Family getFamily() {
        return family;
    }

    void setFamily(Family family) {
        this.family = family;
    }

    Human() {
    }

    Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }


    Human(String name, String surname, int year, int iQ, String[][] schedule) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iQ = iQ;
        this.schedule = schedule;
    }

    @Override
    public boolean equals(Object that) {
        if (that == null || getClass() != that.getClass()) return false;
        if (this == that) return true;
        Human human = (Human) that;
        return year == human.year &&
                Objects.equals(name, human.name) &&
                Objects.equals(surname, human.surname);
    }

    @Override
    public int hashCode() {
        return name.hashCode() * surname.hashCode() * year * -1 + year;
    }


    @Override
    public String toString() {
        if (name == null) {
            return "no info\n";
        } else if (iQ == 0) {
            return String.format("Human{name='%s', surname='%s', year=%d}", name, surname, year);
        } else if (schedule[0][0] == null) {
            return String.format("Human{name='%s', surname='%s', year=%d}", name, surname, year);
        } else {
            return String.format("Human{name='%s', surname='%s', year=%d, iq=%d, schedule=%s}", name, surname, year, iQ, Arrays.deepToString(schedule));
        }
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize" + this);
        super.finalize();
    }
}