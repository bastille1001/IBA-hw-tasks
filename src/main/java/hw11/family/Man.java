package hw11.family;

import hw11.DayOfWeek;

import java.text.ParseException;
import java.util.Map;

public class Man extends Human {

    public Man(String name, String surname, String birthDate) throws ParseException {
        super(name, surname, birthDate);
    }

    public Man() {
    }

    public Man(String name, String surname, String birthDate, int iq) throws ParseException {
        super(name, surname, birthDate,iq);
    }

    public Man(String name, String surname, String birthDate, int iq, Map<DayOfWeek,String> schedule) throws ParseException {
        super(name, surname, birthDate, iq, schedule);
    }

    void greetPet() {
        System.out.println("Hello, my boy\n");
    }

    public void repairCar() {
        System.out.println("I'll repair my summer car");
    }
}
