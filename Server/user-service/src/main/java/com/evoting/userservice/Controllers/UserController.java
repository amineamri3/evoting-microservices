package com.evoting.userservice.Controllers;


import com.evoting.userservice.Exceptions.UserNotFoundException;
import com.evoting.userservice.Models.Role;
import com.evoting.userservice.Models.User;
import com.evoting.userservice.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    public String sayHello() {
        return "Hello World";
    }


    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User userDto) {
        System.out.println(userService.getUserByCin(userDto.getCin()));

        if(userService.getUserByCin(userDto.getCin()).isPresent()){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        else{
            User user = this.userService.createUser(userDto);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }

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

    @GetMapping(value ="/authentication/{cin}/{psw}")
    public ResponseEntity<User> getUserByCin(@PathVariable("cin") Integer cin,@PathVariable("psw") String psw) {
        Optional<User> user = this.userService.getUserByCin(cin);
        if (user.isPresent()) {
            if (passwordEncoder.matches(psw , user.get().getPsw())) {
                System.out.println(user.get());
                return new ResponseEntity<>(user.get(), HttpStatus.OK);
            }else{
                System.out.println("conflict");
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @GetMapping(value ="getByCin/{cin}")
    public ResponseEntity<User> getUserByCin(@PathVariable("cin") Integer cin) {
        Optional<User> user = this.userService.getUserByCin(cin);
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping(value ="getByRole/{role}")
    public ResponseEntity<List<User>> getUsersByCin(@PathVariable("role") Role role) {
        List<User> users = this.userService.getUsersByRole(role);
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(users, HttpStatus.OK);
        }
    }


    @PutMapping(value ="update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") UUID id, @RequestBody User userDto) throws UserNotFoundException {
        return new ResponseEntity<>(this.userService.updateUser(userDto, id), HttpStatus.OK);
    }

    @DeleteMapping(value ="delete/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") UUID id) {
        try {
            this.userService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
