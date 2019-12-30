package hua.objectsDao;

import hua.objects.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class StudentsDaoImpl implements StudentsDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Student> getStudents() {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<Student> query = currentSession.createQuery("from Student " , Student.class);
        List<Student> students = query.getResultList();

        return students;
    }

    @Override
    @Transactional
    public List<Student> getStudentsByDepartment(String department) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<Student> query = currentSession.createQuery("from Student E where E.department=:department" , Student.class);
        query.setParameter("department" , department);
        List<Student> students = query.getResultList();

        return students;
    }
}
