package com.example.organisation.service.services;

import com.example.organisation.service.dto.MembershipRequest;
import com.example.organisation.service.dto.MembershipSubscriptionsDto;
import com.example.organisation.service.model.Membership;
import com.example.organisation.service.model.Subscription;
import com.example.organisation.service.repository.MembershipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MembershipService {
    private final MembershipRepository membershipRepository;
    public void placeMembership(MembershipRequest membershipRequest){
        Membership membership =new Membership();
        membership.setMembership_number(UUID.randomUUID().toString());
        List<Subscription> subscriptions = membershipRequest.getMembershipSubscriptionsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();

        membershipRepository.save(membership);
    }

    private Subscription mapToDto(MembershipSubscriptionsDto membershipSubscriptionsDto) {
        Subscription subscription=new Subscription();
        subscription.setNumber(membershipSubscriptionsDto.getNumber());
        return subscription;
    }

}
