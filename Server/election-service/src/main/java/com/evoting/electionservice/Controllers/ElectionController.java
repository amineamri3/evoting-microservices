package com.evoting.electionservice.Controllers;


import com.evoting.electionservice.Entities.Election;
import com.evoting.electionservice.Models.Response;
import com.evoting.electionservice.Services.IElection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/election")
public class ElectionController {
    @Autowired
    private IElection iElection;

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<Response> addElection(@RequestBody Election election) {
        Map<String, Election> data = new HashMap<String, Election>() {
            {
                put("Election",iElection.addElection(election));
            }
        };
        return ResponseEntity.ok(
                Response.builder()
                        .data(data)
                        .message("Election added")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/get-all")
    @ResponseBody
    public ResponseEntity<Response> getAllElections(){
        Map<String, List<Election>> data = new HashMap<String, List<Election>>() {
            {
                put("Elections", iElection.retrieveAllElections());
            }
        };
        return ResponseEntity.ok(
                Response.builder()
                        .data(data)
                        .message("All Elections are retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public ResponseEntity<Response> getElection(@PathVariable Long id){
        Map<String, Election> data = new HashMap<String, Election>() {
            {
                put("Election", iElection.retrieveElection(id));
            }
        };
        if (iElection.checkIfExist(id)){
            return ResponseEntity.ok(
                    Response.builder()
                            .data(data)
                            .message(data.get("Election").getNomElection() + " is retrieved")
                            .status(OK)
                            .statusCode(OK.value())
                            .build()
            );
        } else {
            return ResponseEntity.ok(
                    Response.builder()
                            .message("Election with code "+ id + " not found")
                            .status(NOT_FOUND)
                            .statusCode(NOT_FOUND.value())
                            .build()
            );
        }

    }

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<Response> updateElection(@RequestBody Election election) {
        Map<String, Election> data = new HashMap<String, Election>() {
            {
                put("Election",iElection.updateElection(election));
            }
        };
        return ResponseEntity.ok(
                Response.builder()
                        .data(data)
                        .message("Election updated")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<Response> deleteElectionById(@PathVariable Long id) {
        Map<String, Election> data = new HashMap<String, Election>() {
            {
                put("Election",iElection.retrieveElection(id));
            }
        };
        iElection.deleteElection(id);
        return ResponseEntity.ok(
                Response.builder()
                        .data(data)
                        .message("Election " + data.get("Election").getCodeElection() +" , "+ data.get("Election").getNomElection()+ " deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/get-paged-sorted")
    @ResponseBody
    public ResponseEntity<Response> getElectionsPagedAndSorted(
            @RequestParam(defaultValue = "0") int offset,
            @RequestParam(defaultValue = "5") int pageSize,
            @RequestParam(required = false) String field) {

//        try {
        Page<Election> electionPage;
        Pageable paging = PageRequest.of(offset,pageSize);
        List<Election> elections;

        if (field == null) {
            electionPage = iElection.getElectionsPaged(paging);
        } else {
            electionPage = iElection.getElectionsPagedAndSorted(offset, pageSize, field);
        }
        elections = electionPage.getContent();

        Map<String, List<Election>> data = new HashMap<String, List<Election>>() {
            {
                put("Elections",elections);
            }
        };

        return ResponseEntity.ok(
                Response.builder()
                        .data(data)
                        .message("List of elections paged and sorted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );

    }

}
