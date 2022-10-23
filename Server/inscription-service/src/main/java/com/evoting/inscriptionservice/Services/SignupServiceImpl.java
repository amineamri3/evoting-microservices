package com.evoting.inscriptionservice.Services;

import com.evoting.inscriptionservice.Models.ElectionSignup;
import com.evoting.inscriptionservice.Repositories.SignupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SignupServiceImpl implements SignupService {

    @Autowired
    SignupRepo signupRepo;

    public SignupServiceImpl(SignupRepo repo) {
        this.signupRepo = repo;
    }


    @Override
    public List<ElectionSignup> getAllSignups() {
        return signupRepo.findAll();
    }

    @Override
    public Optional<ElectionSignup> getSignupById(UUID id) {
        return signupRepo.findById(id);
    }

    @Override
    public ElectionSignup createSignup(ElectionSignup su) {
        return signupRepo.save(su);
    }

    @Override
    public ElectionSignup updateSignupr(ElectionSignup su, UUID id) {
        Optional<ElectionSignup> x = this.signupRepo.findById(id);
        if (x.isPresent()) {
            su.setId(id);
            return this.signupRepo.save(su);
        }
        return null;
    }

    @Override
    public void deleteById(UUID id) {
        signupRepo.deleteById(id);
    }

    @Override
    public List<ElectionSignup> getSignupByUserId(String id) {
        return signupRepo.findByCandidateId(id);
    }

    @Override
    public List<ElectionSignup> getSignupsByElection(String electionid) {
        return signupRepo.findByElectionId(electionid);
    }

}
