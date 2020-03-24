package hw10.dao.Services;

import hw10.DateConverter;
import hw10.dao.Collection.CollectionFamily;
import hw10.dao.İnterfaces.FamilyDAO;
import hw10.family.Family;
import hw10.family.Human;
import hw10.family.Man;
import hw10.family.Woman;
import hw10.pets.Pet;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;


public class FamilyService {

    private FamilyDAO<Family> familyDAO = new CollectionFamily();

    public ArrayList<Family> getAllFamilies(){ return (ArrayList<Family>) familyDAO.getAllFamilies(); }

    public void displayAllFamilies(){
        familyDAO.getAllFamilies().forEach(family ->
                System.out.printf("Index: %d %s \n", getAllFamilies().indexOf(family), family));
    }

    public ArrayList<Family> getFamiliesBiggerThan(int familySize){
        ArrayList<Family> familiesBiggerThan = new ArrayList<>();
        familyDAO.getAllFamilies().forEach(family -> {
            if (family.countFamily() > familySize) familiesBiggerThan.add(family);
        });
        System.out.println(familiesBiggerThan);
        return familiesBiggerThan;
    }

    public ArrayList<Family> getFamiliesLessThan(int familySize){
        ArrayList<Family> familiesLessThan = new ArrayList<>();
        familyDAO.getAllFamilies().forEach(family -> {
            if (family.countFamily() < familySize) familiesLessThan.add(family);
        });
        System.out.println(familiesLessThan);
        return familiesLessThan;
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

    public Family bornChild(Family family, String male, String female) throws ParseException {
        int rnd = (int)(Math.random()*100);
        int iq = (family.getFather().getiQ() + family.getMother().getiQ())/2;
        String year = DateConverter.millsToString((long)(Calendar.getInstance()
            .getTimeInMillis()*(Math.random()*0.3)+0.7));
        if (rnd <= 50){
            Man childMan = new Man(male,family.getFather().getSurname(),year,iq);
            family.addChild(childMan);
        }else {
            Woman childWoman = new Woman(female,family.getMother().getSurname(),year,iq);
            family.addChild(childWoman);
        }
        return familyDAO.save(family);
    }

    public Family adoptChild(Family family, Human human){
        family.addChild(human);
        familyDAO.save(family);
        return family;
    }

    public void deleteAllChildrenOlderThen(int age){
        for (Family family: familyDAO.getAllFamilies()) {
            family.getChildren().removeIf(human -> (2020 - human.getAge()) > age );
            familyDAO.save(family);
        }
    }

    public int count(){ return familyDAO.getAllFamilies().size(); }

    public Family getFamilyById(int familyId){ return familyDAO.getFamilyByIndex(familyId); }

    public ArrayList<Pet> getPets(int familyId){
        return familyDAO.getAllFamilies().get(familyId).getPet();
    }

    public void addFamily(Family family) { familyDAO.save(family); }
}
