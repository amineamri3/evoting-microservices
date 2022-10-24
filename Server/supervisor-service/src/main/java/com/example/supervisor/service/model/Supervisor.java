package com.example.supervisor.service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Document(value="supervisor")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Supervisor {
    @Id
    private String id;
    private  String FirstName;
    private String LastName;
    private  String Organisation;
    private Integer Nbre;



}
