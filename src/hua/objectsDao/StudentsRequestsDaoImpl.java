package hua.objectsDao;

import hua.algorithms.HousingAlgorithm;
import hua.objects.HousingScore;
import hua.objects.Student;
import hua.objects.StudentsRequests;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class StudentsRequestsDaoImpl implements StudentsRequestsDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<StudentsRequests> getRequests() {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<StudentsRequests> query = currentSession.createQuery("from StudentsRequests " , StudentsRequests.class);
        List<StudentsRequests> requests =  query.getResultList();

        System.out.println("Get students requests done ! ");

        return requests;
    }

    @Override
    @Transactional
    public List<StudentsRequests> getRequestsByDepartment(String department) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<StudentsRequests> query = currentSession.createQuery("from StudentsRequests  E where E.department=:department" , StudentsRequests.class);
        query.setParameter("department" , department);
        List<StudentsRequests> requests =  query.getResultList();

        System.out.println("Get students requests done ! ");

        return requests;
    }

    @Override
    @Transactional
    public void acceptRequest(int id) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<StudentsRequests> query = currentSession.createQuery("from StudentsRequests E where E.id=:id" , StudentsRequests.class);
        query.setParameter("id" , id);
        List<StudentsRequests> studentsRequest = query.getResultList();
        StudentsRequests request = studentsRequest.get(0);

        int score = HousingAlgorithm.calcScore(request);
        HousingScore housingScore =  new HousingScore(request.getId() , score , request.getDepartment()) ;

        currentSession.save(housingScore);

    }

}
