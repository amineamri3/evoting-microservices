package com.evoting.voteservice.Controllers;

import com.evoting.voteservice.Entities.Vote;
import com.evoting.voteservice.Models.Response;
import com.evoting.voteservice.Services.IVote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/vote")
public class VoteController {

    @Autowired
    private IVote iVote;

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<Response> addVote(@RequestBody Vote vote) {
        Map<String, Vote> data = new HashMap<String, Vote>() {
            {
                put("Vote",iVote.addVote(vote));
            }
        };
        return ResponseEntity.ok(
                Response.builder()
                        .data(data)
                        .message("Vote added")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/get-all")
    @ResponseBody
    public ResponseEntity<Response> getAllVotes(){
        Map<String, List<Vote>> data = new HashMap<String, List<Vote>>() {
            {
                put("Votes", iVote.retrieveAllVotes());
            }
        };
        return ResponseEntity.ok(
                Response.builder()
                        .data(data)
                        .message("All Votes are retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public ResponseEntity<Response> getVote(@PathVariable String id){
        Map<String, Vote> data = new HashMap<String, Vote>() {
            {
                put("Vote", iVote.retrieveVote(id));
            }
        };
        if (iVote.checkIfExist(id)){
            return ResponseEntity.ok(
                    Response.builder()
                            .data(data)
                            .message(data.get("Vote").getCodeVote() + " is retrieved")
                            .status(OK)
                            .statusCode(OK.value())
                            .build()
            );
        } else {
            return ResponseEntity.ok(
                    Response.builder()
                            .message("Vote with code "+ id + " not found")
                            .status(NOT_FOUND)
                            .statusCode(NOT_FOUND.value())
                            .build()
            );
        }
    }

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<Response> updateVote(@RequestBody Vote vote) {
        Map<String, Vote> data = new HashMap<String, Vote>() {
            {
                put("Vote",iVote.updateVote(vote));
            }
        };
        return ResponseEntity.ok(
                Response.builder()
                        .data(data)
                        .message("Vote updated")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<Response> deleteVoteById(@PathVariable String id) {
        Map<String, Vote> data = new HashMap<String, Vote>() {
            {
                put("Election",iVote.retrieveVote(id));
            }
        };
        iVote.deleteVote(id);
        return ResponseEntity.ok(
                Response.builder()
                        .data(data)
                        .message("Vote " + data.get("Vote").getCodeVote() + " deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
