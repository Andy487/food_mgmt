package com.foodapp.food_app_mgmt.controller;


import com.foodapp.food_app_mgmt.model.User;
import com.foodapp.food_app_mgmt.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private DataService dataService;
    private User user;
    @CrossOrigin(origins = "http://localhost:4200")
//    @RequestMapping(value = "/registerUser", headers = "Accept=application/json", method = RequestMethod.POST)
    @PostMapping(value = "/registerUser")
    public User registerUser(@RequestBody User user) {
        System.out.println("regis user");
        System.out.println("Saving user " + user);
        dataService.registerUser(user);
        return user;
    }

    @GetMapping("/getUser/{id}")
    public User  getUser(@PathVariable("id") Long id){
        System.out.println("get user");
        dataService.getUserById(id);
        return user;
    }

    @PostMapping("/test")
    public String  test(@RequestBody String name){
        System.out.println("name");
        return name;
    }





}
