package hua.objectsDao;

import hua.objects.StudentHousing;

import java.util.List;

public interface StudentsHousingDao {
    public void enableStudent(StudentHousing studentHousing);
    public List<StudentHousing> getEnabledStudents();
    public boolean isEnabled(int id);
}
