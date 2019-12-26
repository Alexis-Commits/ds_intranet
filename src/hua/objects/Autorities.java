package hua.objects;


import javax.persistence.*;

@Entity
@Table(name="authorites")
public class Autorities {

    //Username
    @Id
    @Column(name="username")
    public String username;

    //Role
    @Column(name="authority")
    public String authority;
}
