package hw12.dao;

import hw12.family.Family;

import java.util.List;

public interface FamilyDAO {

    List<Family> getAllFamilies();

    Family getFamilyByIndex(int index);

    boolean deleteFamilyByIndex(int index);

    boolean deleteFamily(Family family);

    Family save(Family family);
}
