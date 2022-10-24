package com.evoting.inscriptionservice.Services;

import com.evoting.inscriptionservice.Models.ElectionSignup;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface SignupService {

    List<ElectionSignup> getAllSignups();

    Optional<ElectionSignup> getSignupById(UUID id);

    ElectionSignup createSignup(ElectionSignup su);

    ElectionSignup updateSignupr(ElectionSignup su, UUID id);

    void deleteById(UUID id);

    List<ElectionSignup> getSignupByUserId(String id);

    List<ElectionSignup> getSignupsByElection(String electionid);
}
