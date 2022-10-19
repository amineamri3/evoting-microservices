package com.evoting.voteservice.Services;

import com.evoting.voteservice.Entities.Vote;
import com.evoting.voteservice.Repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteService implements IVote{

    @Autowired
    private VoteRepository voteRepository;

    @Override
    public List<Vote> retrieveAllVotes() {
        return voteRepository.findAll();
    }

    @Override
    public Vote addVote(Vote vote) {
        return voteRepository.save(vote);
    }

    @Override
    public void deleteVote(String id) {
        voteRepository.deleteById(id);
    }

    @Override
    public Vote updateVote(Vote vote) {
        return voteRepository.save(vote);
    }

    @Override
    public Vote retrieveVote(String id) {
        return voteRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean checkIfExist(String id) {
        return voteRepository.existsById(id);
    }
}
