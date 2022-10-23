package com.evoting.inscriptionservice.Models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="_USER")
public class ElectionSignup implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String electionId;
    private String candidateId;
    private Date date;
    private boolean recieveNotfications;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getElectionId() {
        return electionId;
    }

    public void setElectionId(String electionId) {
        this.electionId = electionId;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isRecieveNotfications() {
        return recieveNotfications;
    }

    public void setRecieveNotfications(boolean recieveNotfications) {
        this.recieveNotfications = recieveNotfications;
    }

    @Override
    public String toString() {
        return "ElectionSignup{" +
                "id=" + id +
                ", electionId='" + electionId + '\'' +
                ", candidateId='" + candidateId + '\'' +
                ", recieveNotfications='" + recieveNotfications + '\'' +
                ", date=" + date +
                '}';
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, electionId, candidateId, date, recieveNotfications);
    }
}
