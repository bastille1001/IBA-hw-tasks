package hw09;

import hw09.dao.FamilyController;
import hw09.family.Family;
import hw09.family.Man;
import hw09.family.Woman;
import hw09.pets.Dog;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class HW9 {
    public static void main(String[] args) {
        HashSet<String> habits = new HashSet<String>() {{
            add("eat");
            add("play");
        }};

        Dog dog = new Dog("Boss", 2, 23, habits);

        Map<DayOfWeek, String> schedule = new HashMap<DayOfWeek, String>() {{
            put(DayOfWeek.MONDAY, "repair the car");
        }};

        Man father = new Man("Frank", "Sinatra", 1980, 121, schedule);
        Woman mother = new Woman("Barbara", "Sinatra", 1980, 110);
        Man father1 = new Man("Victor", "Sinra", 1915, 121);
        Woman mother1 = new Woman("Samantha", "Sinra", 1919, 110);
        Man child = new Man("Vas", "Savas", 1943, 121);

        FamilyController familyController = new FamilyController();
        Family family = new Family(father,mother);

        familyController.addFamily(family);
        familyController.createNewFamily(father1, mother1);
        familyController.bornChild(family, "Simon", "Sara");
        familyController.adoptChild(family, child);
        familyController.count();
        familyController.createNewFamily(father1, mother1);
        familyController.displayAllFamilies();
        familyController.getPets(0);
        familyController.deleteAllChildrenOlderThen(18);
        familyController.deleteFamilyByIndex(1);
        familyController.getFamilyById(0);
        familyController.countFamiliesWithMemberNumber(2);
        familyController.getFamiliesBiggerThan(1);
        familyController.getFamiliesLessThan(3);
        familyController.getAllFamilies();
        familyController.displayAllFamilies();
    }
}
