package hw11;

import hw11.dao.Controller.FamilyController;
import hw11.family.Family;
import hw11.family.Man;
import hw11.family.Woman;
import hw11.pets.Dog;

import java.text.ParseException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class HW11 {
    public static void main(String[] args) throws ParseException {
        HashSet<String> habits = new HashSet<String>() {{
            add("eat");
            add("play");
        }};
        Dog dog = new Dog("Boss", 2, 23, habits);
        Map<DayOfWeek, String> schedule = new HashMap<DayOfWeek, String>() {{
            put(DayOfWeek.MONDAY, "repair the car");
        }};

        Man father = new Man("Frank", "Sinatra", "12/02/1980", 121, schedule);
        Woman mother = new Woman("Barbara", "Sinatra", "12/02/1987", 110);
        Man father1 = new Man("Victor", "Sinra", "04/06/1988", 121);
        Woman mother1 = new Woman("Samantha", "Sinra", "22/03/1990", 110);
        Man child = new Man("Vas", "Savas", "13/11/2008", 121);

        FamilyController controller = new FamilyController();
        Family family = new Family(father, mother);
        controller.addFamily(family);
        controller.bornChild(family, "John", "Samante");
        System.out.println(controller.getAllFamilies());
        controller.adoptChild(family, child);
        System.out.println(controller.getAllFamilies());
    }
}
