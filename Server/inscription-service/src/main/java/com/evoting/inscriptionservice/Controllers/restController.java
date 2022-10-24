package com.evoting.inscriptionservice.Controllers;


import com.evoting.inscriptionservice.Models.ElectionSignup;
import com.evoting.inscriptionservice.Repositories.SignupRepo;
import com.evoting.inscriptionservice.Services.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/inscription")
public class restController {


    @Autowired
    SignupService signupService;

    public restController(SignupService signupService) {
        this.signupService = signupService;
    }
    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    public String sayHello() {
        return "Hello World";
    }


    @PostMapping("/create")
    public ResponseEntity<ElectionSignup> createUser(@RequestBody ElectionSignup x) {
        if(!signupService.getSignupByUserId(x.getCandidateId()).isEmpty()){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        else{
            ElectionSignup sign = this.signupService.createSignup(x);
            return new ResponseEntity<>(sign, HttpStatus.CREATED);
        }

    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ElectionSignup>> getAllSignups() {
        List<ElectionSignup> x = this.signupService.getAllSignups();
        if (x.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(x, HttpStatus.OK);
        }
    }
    @GetMapping(value ="{id}")
    public ResponseEntity<ElectionSignup> getEmployeeById(@PathVariable("id") UUID id) {
        Optional<ElectionSignup> x = this.signupService.getSignupById(id);
        if (x.isPresent()) {
            return new ResponseEntity<>(x.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value ="getByElection/{id}")
    public ResponseEntity<List<ElectionSignup>> getByElection(@PathVariable("id") String id) {
        List<ElectionSignup> x = this.signupService.getSignupsByElection(id);
        if (! x.isEmpty()) {
            return new ResponseEntity<>(x, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping(value ="getByUser/{id}")
    public ResponseEntity<List<ElectionSignup>> getUsersByCin(@PathVariable("id") String id) {
        List<ElectionSignup> x = this.signupService.getSignupByUserId(id);
        if (x.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(x, HttpStatus.OK);
        }
    }



    @DeleteMapping(value ="delete/{id}")
    public ResponseEntity<HttpStatus> deleteSignup(@PathVariable("id") UUID id) {
        try {
            this.signupService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
