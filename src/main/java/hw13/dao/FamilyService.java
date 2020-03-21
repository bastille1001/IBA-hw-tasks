package hw13.dao;

import hw13.DateConverter;
import hw13.family.*;
import hw13.pets.Pet;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;


public class FamilyService {

    FamilyDAO familyDAO = new CollectionFamily();

    public ArrayList<Family> getAllFamilies(){ return (ArrayList<Family>) familyDAO.getAllFamilies(); }

    public void displayAllFamilies(){
        familyDAO.getAllFamilies().stream().forEach(family ->
                System.out.printf("Index: %d %s \n",getAllFamilies().indexOf(family),family));
    }

    public List<Family> getFamiliesBiggerThan(int familySize){
        return familyDAO.getAllFamilies().stream()
                .filter(family -> family.countFamily() > familySize)
                .collect(Collectors.toList());
    }

    public List<Family> getFamiliesLessThan(int familySize){
        return familyDAO.getAllFamilies().stream()
                .filter(family -> family.countFamily() < familySize)
                .collect(Collectors.toList());
    }

    public int countFamiliesWithMemberNumber(int familySize){
        return (int)familyDAO.getAllFamilies().stream().filter(family ->
                family.countFamily() == familySize).count();
    }

    public void createNewFamily(Human human1, Human human2){
        Family newFamily = new Family(human1,human2);
        familyDAO.save(newFamily);
    }

    public void deleteFamilyByIndex(int index){ familyDAO.deleteFamilyByIndex(index); }

    public void bornChild(int index, String manName, String womanName) throws ParseException {
        int random = (int) (Math.random() * 100);
        Family family = familyDAO.getFamilyByIndex(index - 1);
        if (family.countFamily() >= 4) throw new FamilyOverflowException
                ("Family overflow, number of member must be no more than 4");
        int iq = (family.getFather().getiQ() + family.getMother().getiQ()) / 2;
        String year = DateConverter.millsToString((long) (Calendar.getInstance().
                getTimeInMillis() * ((Math.random() * 0.3) + 0.7)));
        if (random <= 50) {
            Man childMan = new Man(manName, family.getFather().getSurname(), year, iq);
            family.addChild(childMan);
        } else {
            Woman childWoman = new Woman(womanName, family.getFather().getSurname(), year, iq);
            family.addChild(childWoman);
        }
        familyDAO.save(family);
    }

    public void adoptChild(int index, Human child) {
        Family family = familyDAO.getFamilyByIndex(index - 1);
        if (family.countFamily() >= 4) throw new FamilyOverflowException
                ("Family overflow, number of member must be no more than 4");
        family.addChild(child);
        child.setSurname(family.getFather().getSurname());
        familyDAO.save(family);
    }

    public void deleteAllChildrenOlderThen(int age){
        for (Family family : familyDAO.getAllFamilies()) {
            family.getChildren().removeIf(human -> (2020 - human.getAge()) > age);
            familyDAO.save(family);
        }
    }

    public int count(){ return familyDAO.getAllFamilies().size(); }

    public Family getFamilyById(int familyId){ return familyDAO.getFamilyByIndex(familyId); }

    public ArrayList<Pet> getPets(int familyId){
        return familyDAO.getAllFamilies().get(familyId).getPet();
    }

    public void addFamily(Family family) { familyDAO.save(family); }

    public void createFamilies(int number) throws ParseException {
        FamilyBuilder familyBuilder = new FamilyBuilder();
        for (int i = 0; i < number; i++) {
            Family family = familyBuilder.build();
            int chance = (int) (Math.random() * 100);
            if (chance > 45) family.bornChild();
            if (chance > 75) family.bornChild();
            familyDAO.save(family);
        }
    }

    public void load(ArrayList<Family> families) {
        familyDAO.loadData(families);
    }
}
