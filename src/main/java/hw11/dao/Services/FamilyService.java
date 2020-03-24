package hw11.dao.Services;

import hw11.DateConverter;
import hw11.dao.Collection.CollectionFamily;
import hw11.dao.İnterfaces.FamilyDAO;
import hw11.family.Family;
import hw11.family.Human;
import hw11.family.Man;
import hw11.family.Woman;
import hw11.pets.Pet;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;


public class FamilyService {

    private FamilyDAO<Family> familyDAO = new CollectionFamily();

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
        Family family = new Family();
        familyDAO.getAllFamilies()
                .forEach(family1 -> family.getChildren()
                        .removeIf(human -> (2020 - human.getAge()) > age));
    }

    public int count(){ return familyDAO.getAllFamilies().size(); }

    public Family getFamilyById(int familyId){ return familyDAO.getFamilyByIndex(familyId); }

    public ArrayList<Pet> getPets(int familyId){
        return familyDAO.getAllFamilies().get(familyId).getPet();
    }

    public void addFamily(Family family) { familyDAO.save(family); }
}
