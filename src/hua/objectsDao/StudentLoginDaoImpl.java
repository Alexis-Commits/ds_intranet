package hua.objectsDao;

import hua.objects.StudentLogin;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.hibernate.query.Query;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class StudentLoginDaoImpl implements StudentLoginDao {

    @Autowired
    SessionFactory sessionFactory  ;

    @Transactional
    @Override
    public boolean login(StudentLogin studentLogin) {
        Session session = sessionFactory.getCurrentSession();

        Query<StudentLogin> query = session.createQuery("from StudentLogin E WHERE E.mail=:mail" , StudentLogin.class);
        query.setParameter("mail" , studentLogin.getMail());
        List<StudentLogin> login = query.getResultList();

        if(!login.isEmpty()){
            //Checks if plain text is matched with hashed password
            return BCrypt.checkpw(studentLogin.getPassword() , login.get(0).getPassword());
       }

        return false;
    }

    @Transactional
    @Override
    public void insertSomeUsers() {
        //Insert dump data
        Session session = sessionFactory.getCurrentSession();
        PasswordEncoder encoder =  new BCryptPasswordEncoder();

        //A mail from students table
        StudentLogin studentLogin =  new StudentLogin("middon7f@histats.com" , encoder.encode("1234"));
        session.update(studentLogin);

    }
}
