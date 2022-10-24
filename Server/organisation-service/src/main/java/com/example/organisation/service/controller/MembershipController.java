package com.example.organisation.service.controller;

import com.example.organisation.service.dto.MembershipRequest;
import com.example.organisation.service.services.MembershipService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/organisation")
public class MembershipController {

    public final MembershipService membershipService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeSubscription(@RequestBody MembershipRequest membershipRequest){
        membershipService.placeMembership(membershipRequest);
        return "subscription placed Succefully";
    }
}
