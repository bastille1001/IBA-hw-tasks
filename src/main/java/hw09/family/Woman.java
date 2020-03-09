package hw09.family;

import hw09.DayOfWeek;

import java.util.Map;

public class Woman extends Human {

    public Woman(String name, String surname, int year) {
        super(name, surname, year);
    }

    public Woman() {
    }

    public Woman(String name, String surname, int year, int iq, Map<DayOfWeek,String> schedule) {
        super(name, surname, year, iq, schedule);
    }

    public void makeup() {
        System.out.println("Makeup time!");
    }
}
