package hua.controllers;


import hua.objects.Authorities;
import hua.objects.UserProfile;
import hua.objects.Users;
import hua.objectsDao.AuthoritiesDao;
import hua.objectsDao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private UserDao userDao;
    @Autowired
    private AuthoritiesDao authoritiesDao;

    @GetMapping("/")
    public String index(){

        return "index";
    }

    @GetMapping("/users-manager")
    public String usermanager(Model model){
        List<Users> usersList = userDao.getUsers();
        model.addAttribute("users" , usersList);

        return "users-manager";
    }

    @GetMapping("/logout")
    public String logout(){

        return "login";
    }

    @GetMapping("/create-user")
    public String createUserPage(){

        return "create-user";
    }

    @PostMapping("/create-user/create")
    public String createUser(@ModelAttribute("userProfile") UserProfile userProfile ){
        Users user =  new Users(userProfile.getUsername() , userProfile.getPassword() , 1 );
        Authorities authorities =  new Authorities(userProfile.getUsername() , userProfile.getAuthority());
        userDao.saveUser(user);
        authoritiesDao.saveUserAuthority(authorities);
        return "index";

    }

}
