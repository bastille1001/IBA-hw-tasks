package hw07;

public class HW7 {
    public static void main(String[] args) {
        Dog dog = new Dog("Boss", 2, 23, new String[]{"eat", "sleep"});
        Man father = new Man("Frank", "Sinatra", 1915);
        Woman mother = new Woman("Barbara", "Sinatra", 1919);

        Family sen = new Family(father, mother, dog);
        System.out.println(sen);
    }
}
