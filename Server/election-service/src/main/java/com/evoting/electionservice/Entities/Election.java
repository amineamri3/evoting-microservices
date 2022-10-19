package com.evoting.electionservice.Entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Election {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeElection;

    private String nomElection;

    private Date dateElection;

    private String typeElection;
}
