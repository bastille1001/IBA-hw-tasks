package hw08;

import java.util.*;

public class Family {
    private Human mother;
    private Human father;
    private List<Human> children;
    private Pet pet;

    Family(Human father, Human mother, Pet pet) {
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
        this.pet = pet;
        father.setFamily(this);
        mother.setFamily(this);
    }

    public Human getMother() { return mother; }

    public Human getFather() { return father; }

    public List<Human> getChildren() { return children; }

    public void setChildren(List<Human> children) { this.children = children; }

    public Pet getPet() { return pet; }

    int countFamily() {
        return 2 + this.children.size();
    }

    void addChild(Human child) {
        children.add(child);
        child.setFamily(this);
    }

    void deleteChild(int index) {
        children.get(index).setFamily(null);
        children.remove(index);
    }

    void describePet() {
        if (pet.getTrickLevel() >= 50) {
            System.out.printf("I have a %s, he is %d years old, he is very sly\n", pet.getSpecies(), pet.getAge());
        } else {
            System.out.printf("I have a %s, he is %d years old, he is almost not sly\n", pet.getSpecies(), pet.getAge());
        }
    }

    void greetPet() {
        System.out.printf("Hello, %s\n", pet.getNickname());
    }

    boolean feedPet() {
        Random random = new Random();
        int trick = random.nextInt(101);
        int petTrick = pet.getTrickLevel();
        if (trick < petTrick) {
            System.out.printf("Hm... I will feed  %s\n", pet.getNickname());
            return true;
        } else {
            System.out.printf("I think %s is not hungry.", pet.getNickname());
            return false;
        }
    }

    @Override
    public String toString() {
        if (this.children.size() == 0 && pet.getSpecies() == null) {
            return String.format("Family{father=%s,\n mother=%s}", father, mother);
        } else if (this.children.size() == 0 && pet.getSpecies() != null) {
            return String.format("Family{father=%s,\n mother=%s,\n pet=%s}", father, mother, pet);
        } else if (this.children.size() != 0 && pet.getSpecies() == null) {
            return String.format("Family{father=%s,\n mother=%s,\n children=%s,\n people in family=%d}", father, mother, children, this.countFamily());
        } else {
            return String.format("Family{father=%s,\n mother=%s,\n pet=%s,\n children=%s}", father, mother, pet, children);
        }
    }

    @Override
    public boolean equals(Object that) {
        if (that == null || getClass() != that.getClass()) return false;
        if (this == that) return true;
        Family family = (Family) that;
        return Objects.equals(father, family.father) &&
                Objects.equals(mother, family.mother) &&
                Objects.equals(children, family.children);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(father, mother);
        result = 21 * result + children.size() * children.size() * -1;
        return result;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize" + this);
        super.finalize();
    }
}
