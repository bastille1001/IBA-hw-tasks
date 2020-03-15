package hw10.family;

import hw10.DateConverter;
import hw10.DayOfWeek;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Map;
import java.util.Objects;

public class Human {
    private String name;
    private String surname;
    private long birthDate;
    private int iQ;
    private Family family;
    private Map<DayOfWeek, String> schedule;

    Human() {
    }

    Human(String name, String surname, String birthDate) throws ParseException {
        this.name = name;
        this.surname = surname;
        this.birthDate = DateConverter.stringToMills(birthDate);
    }

    Human(String name, String surname, String birthDate, int iQ) throws ParseException {
        this.name = name;
        this.surname = surname;
        this.birthDate = DateConverter.stringToMills(birthDate);
        this.iQ = iQ;
    }


    Human(String name, String surname, String birthDate, int iQ, Map<DayOfWeek, String> schedule) throws ParseException {
        this.name = name;
        this.surname = surname;
        this.birthDate = DateConverter.stringToMills(birthDate);
        this.iQ = iQ;
        this.schedule = schedule;
    }

    public int getAge(){
        Calendar calendar = Calendar.getInstance();
        long def = calendar.getTimeInMillis() - this.birthDate;
        calendar.setTimeInMillis(def);
        return calendar.get(Calendar.YEAR) - 1970;
    }

    public String describeAge() {
        Calendar calendar = Calendar.getInstance();
        long def = calendar.getTimeInMillis() - this.birthDate;
        calendar.setTimeInMillis(def);
        int year = calendar.get(Calendar.YEAR) - 1970;
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH) - 1;
        return year + " year " + month + " month " + day + " day";
    }

    public int getiQ() { return iQ; }

    public String getSurname() { return surname; }

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
        return birthDate == human.birthDate &&
                Objects.equals(name, human.name) &&
                Objects.equals(surname, human.surname);
    }

    @Override
    public int hashCode() {
        return (int)(name.hashCode()*surname.hashCode()*birthDate*-11);
    }


    @Override
    public String toString() {
        if (name == null) {
            return "no info\n";
        }else if (iQ == 0 || schedule == null) {
            return String.format("%s{name='%s', surname='%s', birthDate=%s}", this.getClass().getSimpleName(), name, surname, DateConverter.format(birthDate));
        }else {
            return String.format("%s{name='%s', surname='%s', birthDate=%s, iq=%d, schedule=%s}", this.getClass().getSimpleName(), name, surname, DateConverter.format(birthDate), iQ, schedule);
        }
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize" + this);
        super.finalize();
    }
}