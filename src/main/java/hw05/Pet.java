package hw05;

import java.util.Arrays;
import java.util.Objects;

public class Pet {
    private String species;
    private String nickname;
    private int age;
    private int trickLevel;
    private String[] habits;

    Pet(){
    }

    Pet(String species, String nickname){
        this.species = species;
        this.nickname = nickname;
    }

    Pet(String species, String nickname, int age, int trickLevel, String[] habits){
        this.species = species;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(int age) { this.age = age; }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) { this.nickname = nickname; }

    public int getAge() {
        return age;
    }

    public void setAge(int age) { this.age = age; }

    public int getTrickLevel() {
        return trickLevel;
    }

    public void setTrickLevel(int trickLevel) { this.trickLevel = trickLevel; }

    public String[] getHabits() { return habits; }

    public void setHabits(String[] habits) { this.habits = habits; }

    public void eat(){
        System.out.println("I`m eating");
    }

    public void respond(){
        System.out.printf("Hi, owner! I am - %s. I miss you", nickname);
    }

    public void foul(){
        System.out.println("I need to cover up");
    }

    @Override
    public String toString() {
        if (nickname == null) {
            return "no info";
        } else if (age == 0) {
            return String.format("Pet{species='%s', nickname='%s'}", species, nickname);
        } else {
            return String.format("Pet{species='%s', nickname='%s', age=%d, trickLevel=%d, habits=%s}", species, nickname, age, trickLevel, Arrays.toString(habits));
        }
    }

    @Override
    public boolean equals(Object that) {
        if (that == null || getClass() != that.getClass()) return false;
        if (this == that) return true;
        Pet pet = (Pet) that;
        return age == pet.age &&
                trickLevel == pet.trickLevel &&
                species.equals(pet.species) &&
                Objects.equals(nickname, pet.nickname);
    }

    @Override
    public int hashCode() {
        return species.hashCode() * age * nickname.hashCode() * trickLevel * -1;
    }
}