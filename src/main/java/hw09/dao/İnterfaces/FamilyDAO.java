package hw09.dao.İnterfaces;

import java.util.List;

public interface FamilyDAO<Family> {

    List<Family> getAllFamilies();

    Family getFamilyByIndex(int index);

    boolean deleteFamilyByIndex(int index);

    boolean deleteFamily(Family family);

    Family save(Family family);
}
