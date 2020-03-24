package hw12.dao.Controller;

import hw12.dao.Exceptions.FamilyOverflowException;
import hw12.dao.Services.FamilyService;
import hw12.family.Family;
import hw12.family.Human;
import hw12.pets.Pet;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class FamilyController {

    private FamilyService familyService = new FamilyService();

    public ArrayList<Family> getAllFamilies(){ return (ArrayList<Family>) familyService.getAllFamilies(); }

    public void displayAllFamilies(){ familyService.displayAllFamilies(); }

    public List<Family> getFamiliesBiggerThan(int familySize){ return familyService.getFamiliesBiggerThan(familySize); }

    public List<Family> getFamiliesLessThan(int familySize){ return familyService.getFamiliesLessThan(familySize); }

    public int countFamiliesWithMemberNumber(int familySize){
        return familyService.countFamiliesWithMemberNumber(familySize);
    }

    public void createNewFamily(Human father, Human mother) {
        familyService.createNewFamily(father, mother);
    }

    public void deleteFamilyByIndex(int index) {
        familyService.deleteFamilyByIndex(index);
    }

    public void bornChild(int index, String manName, String womanName) throws ParseException {
        try {
            familyService.bornChild(index, manName, womanName);
        } catch (FamilyOverflowException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void adoptChild(int index, Human child) {
        try {
            familyService.adoptChild(index, child);
        } catch (FamilyOverflowException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void deleteAllChildrenOlderThen(int age) {
        familyService.deleteAllChildrenOlderThen(age);
    }

    public int count() {
        return familyService.count();
    }

    public Family getFamilyById(int index) {
        return familyService.getFamilyById(index);
    }

    public ArrayList<Pet> getPets(int index) {
        return familyService.getPets(index);
    }

    public void addFamily(Family family) {
        familyService.addFamily(family);
    }

    public void createFamilies(int number) throws ParseException {
        familyService.createFamilies(number);
    }
}
