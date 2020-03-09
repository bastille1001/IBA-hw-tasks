package hw08;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HW8 {
    public static void main(String[] args) {
        HashSet<String> habits = new HashSet<String>() {{
            add("sleep");
            add("eat");
        }};

        Dog dog = new Dog("Boss", 2, 23, habits);
        DomesticCat cat = new DomesticCat("Little", 2, 50, habits);

        Set<Pet> pets = new HashSet<>();
        pets.add(dog);
        pets.add(cat);

        Map<DayOfWeek, String> schedule = new HashMap<DayOfWeek, String>() {{
            put(DayOfWeek.MONDAY, "repair the car");
        }};

        Man father = new Man("David", "Beckham", 1980, 120, schedule);
        Woman mother = new Woman("Viktoria","Beckham",1985,120,schedule);

        Man son = new Man("Tima","Huseynov",1997);
        Woman daughter = new Woman("Aysu","Huseynova",2004);

        Family fam = new Family(father,mother, pets);
//        fam.getFather().greetPet();
//        fam.greetPet();
        fam.addChild(son);
        fam.addChild(daughter);

        fam.deleteChild(son);

        System.out.println(fam);
//        System.out.println(schedule.get(DayOfWeek.MONDAY));
    }
}
