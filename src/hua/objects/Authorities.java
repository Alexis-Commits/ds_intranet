package hua.objects;


import javax.persistence.*;

@Entity
@Table(name="authorities")
public class Authorities {
    //Username
    @Id
    @Column(name="username")
    public String username;
    //Role
    @Column(name="authority")
    public String authority;

    public Authorities(String username , String authority) {
        this.username = username ;
        this.authority =authority;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
