package hw09.dao;

import hw09.family.Family;

import java.util.List;

public interface FamilyDAO<I> {
    List<Family> getAllFamilies();
    Family getFamilyByIndex(int index);
    boolean deleteFamily(int index);
    boolean deleteFamily(Family family);
    Family save(Family family);
}
