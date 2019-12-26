package hua.controllers;


import hua.objects.Users;
import hua.objectsDao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private UserDao userDao;

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

}
