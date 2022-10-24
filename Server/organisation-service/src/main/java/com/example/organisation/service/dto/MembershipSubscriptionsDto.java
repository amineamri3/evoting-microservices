package com.example.organisation.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MembershipSubscriptionsDto {
    private Long id;
    private String number;
    private String organisation;

}
