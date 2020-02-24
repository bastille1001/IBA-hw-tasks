package hw05;

public class HW5 {
    public static void main(String[] args) {
        Pet dog = new Pet("Dog", "Jarly", 5, 50, new String[]{"eat", "sleep"});
        Human grandfather = new Human();
        Human father = new Human("Frank", "Sinatra", 1915);
        Human mother = new Human("Barbara", "Sinatra", 1919);
        Human child1 = new Human("Nancy", "Sinatra", 1940, 100, new String[1][1]);
        Human child2 = new Human("Toni", "Sinatra", 1943, 101, new String[][]{{"Day_1", "Task_1"}, {"Day_2", "Task_2"}});

        Family myFamily = new Family(father,mother);
        System.out.println(myFamily);

        myFamily.addChild(child1);
        System.out.println(myFamily);

        System.out.println(myFamily);
        System.out.println(father.getFamily());
        myFamily.addChild(child2);
        System.out.println(child2.getFamily());
        myFamily.deleteChild(0);
        System.out.println(child1.getFamily());
        System.out.println(mother.getFamily());
        System.out.println(father.hashCode());
        System.out.println(myFamily.hashCode());
        myFamily.addChild(child2);
        System.out.println(myFamily.hashCode());
    }
}
