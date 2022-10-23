package com.evoting.voteservice.Repositories;

import com.evoting.voteservice.Entities.Vote;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends MongoRepository<Vote, String> {


}
