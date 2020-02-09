package hua.objectsDao;

import hua.objects.HousingScore;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class HousingScoreDaoImpl implements HousingScoreDao{

    @Autowired
    SessionFactory sessionFactory ;
    @Override

    @Transactional
    public List<HousingScore> getStudentsScore() {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<HousingScore> query = currentSession.createQuery("from HousingScore " , HousingScore.class);
        List<HousingScore> scores = query.getResultList();

        return scores;
    }

    @Override
    @Transactional
    public int getStudentPosById(int id) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<HousingScore> query = currentSession.createQuery("from HousingScore order by score DESC" ,HousingScore.class);
        List<HousingScore> scores = query.getResultList();

        int i=0;
        for(HousingScore s : scores){
            System.out.println(s.getId());
            i++;
            if(s.getId() == id ){

                return i;
            }
        }

        return -1;
    }


}
