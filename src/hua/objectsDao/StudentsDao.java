package hua.objectsDao;

import hua.objects.Student;

import java.util.List;

public interface StudentsDao {
    public List<Student> getStudents();
    public List<Student> getStudentsByDepartment(String department);
    public void updateStudent(Student student);
    public  Student getStudentIdByMail(String mail);
}
