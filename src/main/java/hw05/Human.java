package hw05;

import hw04.Pet;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Human {
    private String name;
    private String surname;
    private int year;
    private int iQ;

    private Family family;

    String[][] schedule = {{"monday","read book"},
            {"tuesday","play football"},
            {"wednesday","walking"},
            {"thursday","swimming"},
            {"friday","go out with friends"},
            {"saturday","go to gym"},
            {"sunday","do your diploma"}};

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

    Family getFamily() {
        return family;
    }

    void setFamily(Family family) {
        this.family = family;
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
        } else if (iQ == 0 || schedule[0][0] == null) {
            return String.format("Human{name='%s', surname='%s', year=%d}", name, surname, year);
        } else {
            return String.format("Human{name='%s', surname='%s', year=%d, iq=%d, schedule=%s}", name, surname, year, iQ, Arrays.deepToString(schedule));
        }
    }
}