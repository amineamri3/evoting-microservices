package com.evoting.voteservice.Services;

import com.evoting.voteservice.Entities.Vote;
import com.evoting.voteservice.Repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    @Override
    public  Map<String, Long>  retrieveAllVotesByCandidat(String nomElection) {

        List<Vote> allVotesByElection = this.retrieveAllVotes();
        List<String> candidats = new ArrayList<>();

        allVotesByElection.removeIf(v -> !v.getNomElection().equals(nomElection));

//        else if (nomCandidat != null) {
//            allVotes.removeIf(v -> !v.getNomCandidat().equals(nomCandidat));
//        } else if (nomParti != null){
//            allVotes.removeIf(v -> !v.getNomParti().equals(nomParti));
//        }
        for (Vote vote: allVotesByElection) {
            candidats.add(vote.getNomCandidat());
        }
        return candidats.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
    }

}
