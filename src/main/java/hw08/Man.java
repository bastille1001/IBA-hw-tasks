package hw08;

import java.util.Map;

public class Man extends Human {

    public Man(String name, String surname, int year) {
        super(name, surname, year);
    }

    public Man() {
    }

    public Man(String name, String surname, int year, int iq, Map<DayOfWeek,String> schedule) {
        super(name, surname, year, iq, schedule);
    }

    void greetPet() {
        System.out.printf("Hello, %s\n", getFamily().getPet().getNickname());
    }

    public void repairCar() {
        System.out.println("I'll repair my summer car");
    }
}
