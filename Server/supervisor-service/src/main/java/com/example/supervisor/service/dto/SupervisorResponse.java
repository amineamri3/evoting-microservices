package com.example.supervisor.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SupervisorResponse {
    private String id;
    private  String FirstName;
    private String LastName;
    private  String Organisation;
    private Integer Nbre;
    private boolean isSubscribe;
}
