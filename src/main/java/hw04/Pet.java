package hw04;

import java.util.Arrays;

public class Pet {
    String species;
    public String nickname;
    int age;
    public int trickLevel;
    String[] habits;

    Pet(){
    }

    Pet(String species,String nickname){
        this.species = species;
        this.nickname = nickname;
    }

    Pet(String species, String nickname,int age, int trickLevel,String[] habits){
        this.species = species;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public String getSpecies() {
        return species;
    }

    public String getNickname() {
        return nickname;
    }

    public int getAge() {
        return age;
    }

    public String getTrickLevel() {
        return trickLevel > 50 ? "very sly":"almost not sly";
    }


    public void Eat(){
        System.out.println("I`m eating");
    }

    public void Respond(){
        System.out.printf("Hi, owner! I am - %s. I miss you", nickname);
    }

    public void Foul(){
        System.out.println("I need to cover up");
    }

    @Override
    public String toString() {
        return String.format("Pet{species='%s', nickname='%s', age=%d, trickLevel=%d, habits=%s}", species, nickname, age, trickLevel, Arrays.toString(habits));
    }

}