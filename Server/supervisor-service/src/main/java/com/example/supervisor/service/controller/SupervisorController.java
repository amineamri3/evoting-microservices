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
   // @RequestMapping("/api/supervisor/create")
    public void createSupervisor(@RequestBody SupervisorRequest supervisorRequest){
        supervisorService.createSupervisor(supervisorRequest);

    }
    //http://localhost:8081/api/supervisor
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    //@RequestMapping("")
    //@RequestMapping("/api/supervisor/getAll")
   public List<SupervisorResponse> getAllSupervisors(){
        return supervisorService.getAllSupervisors();
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("/SSS")

    public List<SupervisorResponse>isSbuscribe (@RequestParam List<String> Organisation){
        return supervisorService.isSubscribe(Organisation);
    }
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    private void deleteBook(@PathVariable("id") int id)
    {
       supervisorService .delete(id);
    }


}

