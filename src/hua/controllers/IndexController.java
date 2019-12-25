package hua.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/users-manager")
    public String usermanager(){
        return "users-manager";
    }

}
