package hua.objects;

import javax.persistence.*;

@Entity
@Table(name= "user" )
public class Users {
    //Auto-increment
    @Id
    @Column(name="username")
    private String name;

    //Bcrypt encoding
    @Column(name="password")
    private String password;

    //Enabled 0 or 1
    @Column(name="enabled")
    private int enabled;

    public Users() {
    }

    public Users(String name ,String password , int enabled) {
        super();
        this.name = name ;
        this.password = password;
        this.enabled =  enabled;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }
}
