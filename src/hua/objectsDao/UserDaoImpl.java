package hua.objectsDao;

import hua.objects.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Users> getUsers() {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<Users> query = currentSession.createQuery("from Users" , Users.class);
        List<Users> users = query.getResultList();

        return users;
    }

    @Override
    @Transactional
    public List<Users> getUserByUsername(String username) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<Users> query = currentSession.createQuery("from Users E WHERE E.name = :username" , Users.class);
        query.setParameter("username" , username);

        return query.getResultList();
    }

    @Override
    @Transactional
    public void saveUser(Users user) {
        PasswordEncoder encoder =  new BCryptPasswordEncoder();
        Session currentSession = sessionFactory.getCurrentSession();

        String pass = user.getPassword();
        pass = encoder.encode(pass);
        user.setPassword(pass);

        currentSession.save(user);

        System.out.println("Save user finished !");

    }

    @Override
    @Transactional
    public void updateUser(Users user) {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.createQuery("update Users set enabled=:enabled where name=:username").setParameter("enabled" ,user.getEnabled()).setParameter("username" , user.getName()).executeUpdate();

        System.out.println("update user finished !");
    }

    @Override
    @Transactional
    public void updateUserPC(Users user) {
        PasswordEncoder encoder =  new BCryptPasswordEncoder();
        Session currentSession = sessionFactory.getCurrentSession();

        user.setPassword(encoder.encode(user.getPassword()));
        currentSession.update(user);

        System.out.println("update user finished (Password changed )!");
    }

    @Override
    @Transactional
    public void deleteUser(String username) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<Users> query = currentSession.createQuery("from Users E WHERE E.name = :username" , Users.class);
        query.setParameter("username" , username);
        currentSession.delete(query.getResultList().get(0));

        System.out.println("Delete user :" +username+ "finished");
    }
}
