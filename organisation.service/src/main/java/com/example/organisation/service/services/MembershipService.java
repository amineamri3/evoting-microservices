package com.example.organisation.service.services;

import com.example.organisation.service.dto.MembershipRequest;
import com.example.organisation.service.dto.MembershipSubscriptionsDto;
import com.example.organisation.service.dto.SupervisorResponse;
import com.example.organisation.service.model.Membership;
import com.example.organisation.service.model.Subscription;
import com.example.organisation.service.repository.MembershipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MembershipService {
    private final MembershipRepository membershipRepository;
    private final WebClient webClient;
    public void placeMembership(MembershipRequest membershipRequest){
        Membership membership =new Membership();
        membership.setMembership_number(UUID.randomUUID().toString());

        List<Subscription> subscriptions = membershipRequest.getMembershipSubscriptionsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();
        membership.setMembershipsList(subscriptions);
       List<String>Organisation= membership.getMembershipsList().stream().map(Subscription::getOrganisation).toList();
        //call supervisor-service and place subscription if is not
        //member yet
        SupervisorResponse[] supervisorResponseArray= webClient.get()

                .uri("http://localhost:8082/api/supervisor",

                uriBuilder -> uriBuilder.queryParam("Organisation",Organisation).build())
                        .retrieve()
                                .bodyToMono(SupervisorResponse[].class)
                .block();
        boolean AllOrganisations=Arrays.stream(supervisorResponseArray).allMatch(SupervisorResponse::isSubscribe);
       if(AllOrganisations==false){

            membershipRepository.save(membership);
           // AllOrganisations=true;

        }else {
           throw new IllegalArgumentException("vous etes deja inscrit dans une organisation!");
       }


        //membershipRepository.save(membership);
    }

    private Subscription mapToDto(MembershipSubscriptionsDto membershipSubscriptionsDto) {
        Subscription subscription=new Subscription();
        subscription.setNumber(membershipSubscriptionsDto.getNumber());
        subscription.setOrganisation(membershipSubscriptionsDto.getOrganisation());
        return subscription;
    }

}
