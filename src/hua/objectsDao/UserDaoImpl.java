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
        //Get the current session via hibernate
        Session currentSession = sessionFactory.getCurrentSession();

        //Create the query
        Query<Users> query = currentSession.createQuery("from Users" , Users.class);

        List<Users> users = query.getResultList();

        return users;
    }

    @Override
    public Users getUserByUsername(String username) {
        return null;
    }

    @Override
    @Transactional
    public void saveUser(Users user) {
        PasswordEncoder encoder =  new BCryptPasswordEncoder();
        Session currentSession = sessionFactory.getCurrentSession();

        String pass = user.getPassword();
        pass = encoder.encode(pass);
        user.setPassword(pass);
        System.out.println(pass);
        currentSession.save(user);
        System.out.println("Save user finished !");

    }
}
