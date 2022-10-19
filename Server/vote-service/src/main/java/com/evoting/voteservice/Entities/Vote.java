package com.evoting.voteservice.Entities;

import lombok.*;
import lombok.extern.jackson.Jacksonized;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;
import java.util.Date;

@Document(collection = "votes")
@Data
@Builder
@Jacksonized
public class Vote {

    @Id
    private String codeVote;

    private Date dateVote;

    private Long codeElection;

    private Long codeCandidat;

    private Long codeParti;
}
