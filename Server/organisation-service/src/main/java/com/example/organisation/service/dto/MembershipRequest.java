package com.example.organisation.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MembershipRequest {
    private List<MembershipSubscriptionsDto> membershipSubscriptionsDtoList;
}
