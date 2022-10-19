package com.evoting.userservice.Controllers;


import com.evoting.userservice.Exceptions.UserNotFoundException;
import com.evoting.userservice.Models.User;
import com.evoting.userservice.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    public String sayHello() {
        return "Hello World";
    }

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = this.userService.getAllUsers();
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(users, HttpStatus.OK);
        }
    }
    @GetMapping(value ="{id}")
    public ResponseEntity<User> getEmployeeById(@PathVariable("id") UUID id) {
        Optional<User> user = this.userService.getUserById(id);
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User userDto) {
        System.out.println("user m" + userDto);
        System.out.println("test: " + userService);
        User user = this.userService.createUser(userDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);

    }

    @PutMapping(value ="updateUser/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") UUID id, @RequestBody User userDto) throws UserNotFoundException {
        return new ResponseEntity<>(this.userService.updateUser(userDto, id), HttpStatus.OK);
    }

    @DeleteMapping(value ="deleteUser/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") UUID id) {
        try {
            this.userService.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
