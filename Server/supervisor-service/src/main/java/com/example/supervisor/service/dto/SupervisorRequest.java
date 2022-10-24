package com.example.supervisor.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SupervisorRequest {
    private  String FirstName;
    private String LastName;
    private  String Organisation;
    private Integer Nbre;
}

