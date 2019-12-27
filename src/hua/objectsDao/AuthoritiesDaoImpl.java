package hua.objectsDao;

import hua.objects.Authorities;
import hua.objects.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class AuthoritiesDaoImpl  implements  AuthoritiesDao{

    @Autowired
    SessionFactory sessionFactory;


    @Override
    @Transactional
    public List<Authorities> getAuthoritiesByUsername(String username) {
        Session currentSession = sessionFactory.getCurrentSession();

        //Create the query
        Query<Authorities> query = currentSession.createQuery("from Authorities E WHERE E.username = :username" , Authorities.class);
        query.setParameter("username" , username);

        return query.getResultList();

    }

    @Override
    @Transactional
    public void saveUserAuthority(Authorities authorities) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(authorities);
        System.out.println("In save Authority method ");

    }
}
