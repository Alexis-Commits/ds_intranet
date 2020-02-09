package hua.controllers;


import hua.objects.Authorities;
import hua.objects.UserProfile;
import hua.objects.Users;
import hua.objectsDao.AuthoritiesDao;
import hua.objectsDao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@RequestMapping("/admin")
public class IndexController {

    @Autowired
    private UserDao userDao;
    @Autowired
    private AuthoritiesDao authoritiesDao;

    @GetMapping("")
    public String index(){

        return "index";
    }

    @GetMapping("/users-manager")
    public String usermanager(Model model){
        List<Users> usersList = userDao.getUsers();
        model.addAttribute("users" , usersList);

        return "users-manager";
    }
    @PostMapping("/users-manager/edit")
    public String editUser(@ModelAttribute("userProfile") UserProfile userProfile){
        if(userProfile.getPassword().isEmpty()){
            userDao.updateUser(new Users(userProfile.getUsername() ,userProfile.getPassword() , userProfile.getEnabled()));
            authoritiesDao.updateAuthorities(new Authorities(userProfile.getUsername() , userProfile.getAuthority()));
        }else {
            userDao.updateUserPC(new Users(userProfile.getUsername() ,userProfile.getPassword() , userProfile.getEnabled()));
            authoritiesDao.updateAuthorities(new Authorities(userProfile.getUsername() , userProfile.getAuthority()));
        }

        return "redirect:/users-manager";
    }

    @PostMapping("/users-manager/delete")
    public String deleteUser(@ModelAttribute("userProfile") UserProfile userProfile){
        authoritiesDao.deleteUserAuthority(userProfile.getUsername());
        userDao.deleteUser(userProfile.getUsername());

        return "redirect:/users-manager";
    }

    @GetMapping("/users-manager/{username}")
    public String userEdit(@PathVariable String username , Model model){
        Users user ;
        user = userDao.getUserByUsername(username).get(0);
        user.setPassword("");

        Authorities authority ;
        authority = authoritiesDao.getAuthoritiesByUsername(username).get(0);

        UserProfile userProfile = new UserProfile(user.getName() , user.getPassword() , user.getEnabled() , authority.getAuthority());
        model.addAttribute("userProfile" , userProfile);

        return "edit-user";
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
