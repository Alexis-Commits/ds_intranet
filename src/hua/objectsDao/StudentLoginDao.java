package hua.objectsDao;

import hua.objects.StudentLogin;

public interface StudentLoginDao {
    public boolean login(StudentLogin studentLogin);
    public void insertSomeUsers();
}
