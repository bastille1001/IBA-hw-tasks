package hw12.family;


import hw12.DateConverter;
import hw12.pets.Pet;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

public class Family implements Printable {
    private Human mother;
    private Human father;
    private ArrayList<Human> children;
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

    public void setChildren(ArrayList<Human> children) { this.children = children; }

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

    public void bornChild() throws ParseException {
        int random = (int) (Math.random() * 100);
        int iq = (father.getiQ() + mother.getiQ()) / 2;
        String year = DateConverter.millsToString((long) (Calendar.getInstance().
                getTimeInMillis() * ((Math.random() * 0.3) + 0.7)));
        if (random <= 50) {
            ManNames name = new ManNames();
            Man childMan = new Man(name.getManName(), father.getSurname(), year, iq);
            this.addChild(childMan);
        } else {
            WomanNames name = new WomanNames();
            Woman childWoman = new Woman(name.getWomanName(), father.getSurname(), year, iq);
            this.addChild(childWoman);
        }
    }

    private StringBuilder childPrettyFormat(ArrayList<Human> children) {
        StringBuilder result = new StringBuilder();
        for (Human child : children) {
            if (child instanceof Man) {
                result.append("\n      boy: ").append(child.prettyFormat());
            } else if (child instanceof Woman) {
                result.append("\n      girl: ").append(child.prettyFormat());
            } else {
                result.append("\n      child: ").append(child.prettyFormat());
            }
        }
        return result;
    }

    private String decorator() {
        return "-------------------------";
    }

    @Override
    public String prettyFormat() {
        if (this.children.size() == 0 && pet.size() == 0) {
            return String.format("Family\nFather: %s\nMother: %s\nPeople in family: %d\n%s"
                    , father, mother, this.countFamily(), decorator());
        } else if (this.children.size() == 0 && pet.size() != 0) {
            return String.format("Family\n Father: %s\nMother: %s\nPet: %s\nPeople in family: %d\n%s"
                    , father, mother, pet, this.countFamily(), decorator());
        } else if (this.children.size() != 0 && pet.size() == 0) {
            return String.format("Family\nFather: %s\nMother: %s\nChildren: %s\nPeople in family: %d\n%s"
                    , father, mother, childPrettyFormat(children), this.countFamily(), decorator());
        } else {
            return String.format("Family\nFather: %s\nMother: %s\nPet: %s\nChildren: %s\nPeople in family: %d\n%s"
                    , father, mother, pet, childPrettyFormat(children), this.countFamily(), decorator());
        }
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
