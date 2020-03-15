package hw09.pets;

import java.util.Objects;
import java.util.Set;

public abstract class Pet {

    private Species species;
    private String nickname;
    private int age;
    private int trickLevel;
    private Set<String> habits;

    Pet(){ this.species = Species.UNKNOWN;}

    Pet(String nickname){
        this.nickname = nickname;
        this.species = Species.UNKNOWN;
    }

    Pet(String nickname, int age, int trickLevel, Set<String> habits){
        this.species = Species.UNKNOWN;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) { this.species = species; }

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

    public Set getHabits() { return habits; }

    public void setHabits(Set<String> habits) { this.habits = habits; }

    public static void eat(){
        System.out.println("I`m eating");
    }

    abstract void respond();


    @Override
    public String toString() {
        if (nickname == null) {
            return "no info";
        } else if (age == 0) {
            return String.format("Pet{species='%s', nickname='%s'}", species, nickname);
        } else {
            return String.format("Pet{species='%s', nickname='%s', age=%d, trickLevel=%d, habits=%s}", species, nickname, age, trickLevel, habits);
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

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize" + this);
        super.finalize();
    }
}