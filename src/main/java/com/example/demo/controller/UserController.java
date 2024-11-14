package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService; /*defines a field in the UserController class that will hold a reference to the UserService instance
    The userService field allows any method in UserController to access the UserService instance without needing to pass it as a parameter every time.
    Lets UserController store and consistently access the UserService instance
    private - cannot be accessed from outside of the class, final - cannot be changed later.
    */

    //Constructor injection
    public UserController(UserService userService) {
        this.userService = userService;
    }

@GetMapping("/delete-user/{id}")
    public String deleteUserById(@PathVariable("id") long userId) {
        return userService.deleteUserById(userId);

    }

    @GetMapping("/allusers")
    public void getAllUsers() {
        userService.printUsers(); //With void method, it will do the action when you go to endpoint, but it will appear in terminal
        //return userService.printUsersTwo(); //List<User>
    }

    @GetMapping("/user")
    public User getUser() {
        return userService.getUser();
    }


    @GetMapping("/hello")
    public String hello() {
        return userService.hello();
    }

    @GetMapping("/multiple-users")
    public String[] multipleUsers() {
        return userService.multipleUsers();
    }

    @GetMapping("/fruits")
    public Map<Integer, String> fruits() {
        return userService.fruits();
    }

    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable("id") int userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/user/name/{name}")
    public String greetUser(@PathVariable("name") String userName) {
        return userService.greetUser(userName);
    }

    @GetMapping("/{number}")
    public String squareNumber(@PathVariable("number") long number) {
        return userService.squareNumber(number);
    }

    @GetMapping("/userid/{id}")
    public User retrieveId(@PathVariable("id") int id) {
        return userService.retrieveId(id);
    }

    @GetMapping("/user/{userId}/order/{number}")
    public String idAndOrderId(@PathVariable("userId") long id, @PathVariable("number") int number) {
        return userService.idAndOrderId(id, number);
    }

    @GetMapping("/fullname")
    public String fullname(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return userService.fullname(firstName, lastName);
    }

    @GetMapping("/greet-by-language")
    public String greetingLanguage(@RequestParam(value = "name", defaultValue = "World") String name, @RequestParam("language") String language) {
        return userService.greetingLanguage(name, language);
    }
}
