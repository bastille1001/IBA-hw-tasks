package hw08;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class HW8 {
    public static void main(String[] args) {
        HashSet<String> habits = new HashSet<String>() {{
            add("sleep");
            add("eat");
        }};
        Dog dog = new Dog("Boss", 2, 23, habits);
        Map<DayOfWeek, String> schedule = new HashMap<DayOfWeek, String>() {{
            put(DayOfWeek.MONDAY, "repair the car");
        }};

        Man father = new Man("David", "Beckham", 1980, 120, schedule);
        Woman mother = new Woman("Viktoria","Beckham",1985,120,schedule);

        Family fam = new Family(father,mother,dog);
        System.out.println(fam);
        System.out.println(schedule.get(DayOfWeek.MONDAY));
    }
}
