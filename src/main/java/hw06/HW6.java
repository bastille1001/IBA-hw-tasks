package hw06;

import java.util.Arrays;

public class HW6 {
    public static void main(String[] args) {
        Pet cat = new Pet(Species.CAT,"kitty",3,90,new String[]{"eat","sleep"});
        Human grandfather = new Human();

        Human father = new Human("Frank", "Sinatra", 1915);
        Human mother = new Human("Barbara", "Sinatra", 1919);
        Human child1 = new Human("Nancy", "Sinatra", 1940, 100, new String[][]{{DayOfWeek.MONDAY.name(),"Do your diploma"},{DayOfWeek.TUESDAY.name(),"Play football"}});
        Human child2 = new Human("Tony", "Sinatra", 1945, 100, new String[][]{{DayOfWeek.WEDNESDAY.name(),"Go to walk"},{DayOfWeek.THURSDAY.name(),"Sleep"}});

        System.out.println(child1);
        System.out.println(father);

        Family family = new Family(father,mother);
        family.addChild(child1);
        family.addChild(child2);
        family.deleteChild(1);
        System.out.println(Arrays.toString(family.getChildren()));
    }
}
