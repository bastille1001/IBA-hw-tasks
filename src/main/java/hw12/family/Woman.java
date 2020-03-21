package hw12.family;

import hw12.DayOfWeek;

import java.text.ParseException;
import java.util.Map;

public class Woman extends Human {

    public Woman(String name, String surname, String birthDate) throws ParseException {
        super(name, surname, birthDate);
    }

    public Woman() {
    }

    public Woman(String name, String surname, String birthDate, int iq) throws ParseException {
        super(name, surname, birthDate, iq);
    }

    public Woman(String name, String surname, String birthDate, int iq, Map<DayOfWeek,String> schedule) throws ParseException {
        super(name, surname, birthDate, iq, schedule);
    }

    public void makeup() {
        System.out.println("Makeup time!");
    }
}
