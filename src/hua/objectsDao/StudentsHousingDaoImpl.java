package hua.objectsDao;

import hua.objects.StudentHousing;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class StudentsHousingDaoImpl implements StudentsHousingDao {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public void enableStudent(StudentHousing studentHousing) {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.save(studentHousing);

        System.out.println("Enable student done ! ");
    }

    @Override
    @Transactional
    public List<StudentHousing> getEnabledStudents() {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<StudentHousing> query = currentSession.createQuery("from StudentHousing " , StudentHousing.class);
        List<StudentHousing> enabledStudents =  query.getResultList();

        System.out.println("Get enabled students done ! ");

        return enabledStudents;
    }
}
