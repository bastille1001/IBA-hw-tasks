package hw09.family;

import hw09.DayOfWeek;

import java.util.Map;

public class Man extends Human {

    public Man(String name, String surname, int year) {
        super(name, surname, year);
    }

    public Man() {
    }

    public Man(String name, String surname, int year,int iq){ super(name, surname, year,iq); }

    public Man(String name, String surname, int year, int iq, Map<DayOfWeek,String> schedule) {
        super(name, surname, year, iq, schedule);
    }

    void greetPet() {
        System.out.println("Hello, my boy\n");
    }

    public void repairCar() {
        System.out.println("I'll repair my summer car");
    }
}
