package hw11.dao;

import hw11.family.Family;

import java.util.List;

public interface FamilyDAO {

    List<Family> getAllFamilies();

    Family getFamilyByIndex(int index);

    boolean deleteFamilyByIndex(int index);

    boolean deleteFamily(Family family);

    Family save(Family family);
}
