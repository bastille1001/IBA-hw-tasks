package hw10.family;


import hw10.pets.Pet;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Family {
    private Human mother;
    private Human father;
    private List<Human> children;
    private ArrayList<Pet> pet;

    public Family(Human father, Human mother) {
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

    public ArrayList<Pet> getPet() { return pet; }

    public void setPet(ArrayList<Pet> pet) {
        this.pet = pet;
    }

    public int countFamily() {
        return 2 + this.children.size();
    }

    public void addChild(Human child) {
        children.add(child);
        child.setFamily(this);
    }

    void deleteChild(int index) {
        children.get(index).setFamily(null);
        children.remove(index);
    }


    @Override
    public String toString() {
        if (this.children.size() == 0 && pet == null) {
            return String.format("Family{father=%s,\n mother=%s}", father, mother);
        } else if (this.children.size() == 0 && pet != null) {
            return String.format("Family{father=%s,\n mother=%s,\n pet=%s}", father, mother, pet);
        } else if (this.children.size() != 0 && pet == null) {
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
