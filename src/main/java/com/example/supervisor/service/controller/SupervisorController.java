package com.example.supervisor.service.controller;

import com.example.supervisor.service.dto.SupervisorRequest;
import com.example.supervisor.service.service.SupervisorService;
import com.example.supervisor.service.dto.SupervisorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/supervisor")
public class SupervisorController {
    private final SupervisorService supervisorService;

//http://localhost:8081/api/supervisor
    @PostMapping
@ResponseStatus(HttpStatus.CREATED)
    public void createSupervisor(@RequestBody SupervisorRequest supervisorRequest){
        supervisorService.createSupervisor(supervisorRequest);

    }
    //http://localhost:8081/api/supervisor
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SupervisorResponse> getAllSupervisors(){
        return supervisorService.getAllSupervisors();
    }


}

