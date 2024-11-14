package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service//Tells application this is a service class
public class UserService {

    private List<User> users = new ArrayList<>(List.of(
            new User(123L, "John Doe", "john.doe@example.com"),
            new User(184L, "John Smith", "john.smith@example.com"),
            new User(145L, "Jane Doe", "jane.doe@example.com")
    ));

    public String deleteUserById(Long userId) {
        for (User user : users) {
            if (user.getId().equals(userId)) { //To use equals long needs to be non-primitive, so Long
                users.remove(user);
                return ("User with ID " + userId + " has been deleted. " + "Users still in the list: " + users); //Makes users into String ()
            }
        }
        return ("User with ID " + userId + " not found. " + "Users in the list: " + users);
    }

    public void printUsers() {
        System.out.println(users);
    }

    public List<User> printUsersTwo() {
        return (users);
    }

    public String[] multipleUsers() {
        User userOne = new User(2L, "John Doe", "john.doe@example.com");
        User userTwo = new User(184L, "John Smith", "john.smith@example.com");
        User userThree = new User(145L, "Jane Doe", "jane.doe@example.com");
        String[] users = {String.valueOf(userOne), String.valueOf(userTwo), String.valueOf(userThree)};
        return users;

          /* The instructors solution:
        Class User []
        User [] users = new User [3];
        users [0] = new User(123L, "John Doe", "john.doe@example.com");
        User[1] = new User(184L, "John Smith", "john.smith@example.com");
        User [2] = new User(145L, "Jane Doe", "jane.doe@example.com");
        return users;
         */
    }

    public Map<Integer, String> fruits() {
        Map<Integer, String> fruits = new HashMap();
        fruits.put(3, "Apple");
        fruits.put(5, "Banana");
        fruits.put(1, "Cherry");
        return fruits;
    }

    public String hello() {
        /*String hello = "\"Hello, World!\"";
        return hello; //To return a String, method needs to be String*/
        return "Hello, World!";
    }

    public User getUser() {
        /*User user = new User(123L, "John Doe", "john.doe@example.com"); //Returns new object
        return user;*/
        return new User(123L, "John Doe", "john.doe@example.com");
    }

    //PathVariable
//Endpoint to get user by their ID
    public String getUserById(int userId) {
        return "User ID: " + userId; //concatenate userId to a String
    }

    public String greetUser(String userName) { //concat to String
        return "Hello, " + userName + "!";
    }

    public String squareNumber(long number) { //concat to String
        long result = number * number;
        return "The square of " + number + " is " + result + ".";
    }

    public User retrieveId(int id) { //Type User to return all user info
        User userOne = new User(123L, "John Doe", "john.doe@example.com");
        User userTwo = new User(184L, "John Smith", "john.smith@example.com");
        User userThree = new User(145L, "Jane Doe", "jane.doe@example.com");

        List<User> users = new ArrayList<>(); /* User class defines the type of objects that can be stored in the list
        This allows you to use User-specific methods and properties, such as user.getId() and user.getName(),
        without additional casting or checks.
        Without generics, you would end up with a raw List, which can hold any type of object and requires casting
        and additional checks to ensure the stored objects are User instances.*/
        users.add(userOne);
        users.add(userTwo);
        users.add(userThree);

        //Short version:
        /*List<User>users=List.of(
        new User(123L, "John Doe", "john.doe@example.com");
        new User(184L, "John Smith", "john.smith@example.com");
        new User(145L, "Jane Doe", "jane.doe@example.com");
         */

        for (User user : users) { //the User class is specified so that each element in the users list is treated as
            // a User object
            if (user.getId() == id) {
                return user; //returning all user info
            }
        }
        return null;
    }

    public String idAndOrderId(long id, int number) {

        return "User ID is: " + id + ", order number is: " + number;
    }

    //http://localhost:8080/api/users/fullname?firstName=Jo&lastName=Smi
    public String fullname(String firstName, String lastName) {

        return "Full name is " + firstName + " " + lastName;
    }

    public String greetingLanguage(String name, String language) {
        String greeting = " ";
        switch (language) {
            case "en":
                greeting = "Hello";
                break;
            case "es":
                greeting = "Hola";
                break;
            case "fr":
                greeting = "Bonjour";
                break;
            default:
                greeting = "Hello";
                break;
        }
        return greeting + ", " + name + "!";
    }
}


/*@GetMapping("/multiple-users-two")
public String multipleUsersTwo() {
    User userOne = new User(123L, "John", "john.doe@example.com");
    User userTwo = new User(184L, "John Smith", "john.smith@example.com");
    User userThree = new User(145L, "Jane Doe", "jane.doe@example.com");
        *//*ArrayList<String> users = new ArrayList<>();
        users.add(String.valueOf(userOne));
        users.add(String.valueOf(userTwo));
        users.add(String.valueOf(userThree)); //If ArrayList is needed *//*
    List<User> users = new ArrayList<>();
    users.add(userOne);
    users.add(userTwo);
    users.add(userThree);
    //Or return users; in method "List"

    // Adding <br> (HTML line break) tags for line breaks, so it is correctly interpreted in a web response
    String usersSentence = "First user: " + userOne + "<br>" +
            "Second user: " + userTwo + "<br>" +
            "Third user: " + userThree;
    return usersSentence;
}*/
