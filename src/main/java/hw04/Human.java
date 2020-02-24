package hw04;

import java.util.Arrays;
import java.util.Random;

public class Human {
    String name;
    String surname;
    int year;
    int iQ;
    Pet pet;
    Human mother;
    Human father;

    String[][] schedule = {{"monday","read book"},
            {"tuesday","play football"},
            {"wednesday","walking"},
            {"thursday","swimming"},
            {"friday","go out with friends"},
            {"saturday","go to gym"},
            {"sunday","do your diploma"}};


    Human() {
    }

    Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    Human(String name, String surname, int year, Human father, Human mother) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.mother = mother;
        this.father = father;
    }

    Human(String name, String surname, int year, int iQ, Pet pet, Human father, Human mother, String[][] schedule) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iQ = iQ;
        this.pet = pet;
        this.mother = mother;
        this.father = father;
        this.schedule = schedule;
    }

    boolean feedPet() {
        Random random = new Random();
        int trick = random.nextInt(101);
        int petTrick = pet.trickLevel;
        if (trick < petTrick) {
            System.out.printf("Hm... I will feed  %s\n", pet.nickname);
            return true;
        } else {
            System.out.printf("I think %s is not hungry.", pet.nickname);
            return false;
        }
    }

    public void greetPet(){
        System.out.printf("Hello, %s\n", pet.getNickname());
    }

    public void describePet(){
        System.out.printf("I have a %s, he is %s years old, he is very %s", pet.getSpecies(),pet.getAge(),pet.getTrickLevel());
    }

    @Override
    public String toString() {
        return String.format("Human{name='%s', surname='%s', year=%d, iQ=%d, pet=%s, mother=%s, father=%s, schedule=%s}", name, surname, year, iQ, pet, mother, father, Arrays.toString(schedule));
    }
}
