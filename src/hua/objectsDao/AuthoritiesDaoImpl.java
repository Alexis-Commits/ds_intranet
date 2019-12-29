package hua.objectsDao;

import hua.objects.Authorities;
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

    @Override
    @Transactional
    public void updateAuthorities(Authorities authorities) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.update(authorities);
        System.out.println("In update Authority method ");

    }

    @Override
    @Transactional
    public void deleteUserAuthority(String username) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<Authorities> query = currentSession.createQuery("from Authorities E WHERE E.username = :username" , Authorities.class);
        query.setParameter("username" , username);
        currentSession.delete(query.getResultList().get(0));

        System.out.println("Delete user :" + username + "finished");


    }


}
