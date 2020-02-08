package hua.objects;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="student_login")
public class StudentLogin implements Serializable {
    @Column(name = "mail")
    @Id
    String mail;
    @Column(name = "password")
    String password;

    public StudentLogin() {
    }

    public StudentLogin(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
