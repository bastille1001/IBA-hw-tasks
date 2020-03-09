package hw08;

import java.util.*;

public class Family {
    private Human mother;
    private Human father;
    private List<Human> children;
    private Set<Pet> pet = new HashSet<>();

    Family(Human father, Human mother, Set<Pet> pet) {
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

    public Set<Pet> getPet() { return pet; }

    public void setPet(Set<Pet> pet) {
        this.pet = pet;
    }

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

//    void describePet() {
//        if (pet.getTrickLevel() >= 50) {
//            System.out.printf("I have a %s, he is %d years old, he is very sly\n", pet.getSpecies(), pet.getAge());
//        } else {
//            System.out.printf("I have a %s, he is %d years old, he is almost not sly\n", pet.getSpecies(), pet.getAge());
//        }
//    }

    void greetPet() {
        System.out.printf("Hello, %s\n", pet);
    }

//    boolean feedPet() {
//        Random random = new Random();
//        int trick = random.nextInt(101);
//        int petTrick = pet.getTrickLevel();
//        if (trick < petTrick) {
//            System.out.printf("Hm... I will feed  %s\n", pet.getNickname());
//            return true;
//        } else {
//            System.out.printf("I think %s is not hungry.", pet.getNickname());
//            return false;
//        }
//    }


    @Override
    public String toString() {
        return String.format("Family{mother=%s, father=%s, children=%s, pet=%s}", mother, father, children, pet);
    }

    public Family(Human mother, Human father, List<Human> children, Set<Pet> pet) {
        this.mother = mother;
        this.father = father;
        this.children = children;
        this.pet = pet;
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
