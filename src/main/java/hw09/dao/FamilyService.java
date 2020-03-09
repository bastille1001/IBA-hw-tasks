package hw09.dao;
import hw09.family.Family;

import java.util.ArrayList;

public class FamilyService {

    private FamilyDAO familyDAO = new CollectionFamilyDAO();

    public ArrayList<Family> getAllFamilies(){
        return (ArrayList<Family>) familyDAO.getAllFamilies();
    }

    public void displayAllFamilies(){
        familyDAO.getAllFamilies().forEach(family ->
                System.out.printf("Index: %d %s \n", getAllFamilies().indexOf(family), family));
    }

//    public ArrayList<Family> getFamiliesBiggerThan(int familySize){
//        ArrayList<Family> families = new ArrayList<>();
//        familyDAO.getAllFamilies().forEach(fam ->
//        {if (fam.countFamily)});
//    }
}
