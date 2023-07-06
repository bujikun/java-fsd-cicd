package tz.co.vodacom.bujikun.cicd.cicddemo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tz.co.vodacom.bujikun.cicd.cicddemo.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("http://localhost:3000")
public class UserController {
    private static final List<User> users = Arrays.asList(
            new User[]{new User("John", "Doe", 45),
                    new User("Jane", "Doe", 30),
                    new User("Peter", "Parker", 34),
                    new User("Clark", "Kent", 23),
                    new User("Bruce", "Wayne", 56),
            });
    
    @GetMapping
    public List<User> getAllUsers(){
        return UserController.users;
    }

}
