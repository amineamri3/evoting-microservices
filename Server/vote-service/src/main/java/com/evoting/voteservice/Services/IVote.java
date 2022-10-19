package com.evoting.voteservice.Services;

import com.evoting.voteservice.Entities.Vote;

import java.util.List;

public interface IVote {

    List<Vote> retrieveAllVotes();

    Vote addVote(Vote vote);

    void deleteVote(String id);

    Vote updateVote(Vote vote);

    Vote retrieveVote(String id);

    Boolean checkIfExist(String id);
}
