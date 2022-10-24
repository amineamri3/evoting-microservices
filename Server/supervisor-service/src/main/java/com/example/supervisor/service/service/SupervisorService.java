package com.example.supervisor.service.service;

import com.example.supervisor.service.dto.SupervisorRequest;
import com.example.supervisor.service.model.Supervisor;
import com.example.supervisor.service.dto.SupervisorResponse;
import com.example.supervisor.service.repository.SupervisorRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class SupervisorService {
    private final SupervisorRepository supervisorRepository;



    public void createSupervisor(SupervisorRequest supervisorRequest){
        Supervisor supervisor=Supervisor.builder()
                .FirstName(supervisorRequest.getFirstName())
                .Organisation(supervisorRequest.getOrganisation())
                .LastName(supervisorRequest.getLastName())
                .Nbre(supervisorRequest.getNbre())

                .build();

        supervisorRepository.save(supervisor);

        log.info("supervisor{}is saved",supervisor.getId());
    }

    public List<SupervisorResponse> getAllSupervisors() {
      List<Supervisor>supervisors=  supervisorRepository.findAll();
     return supervisors.stream().map(this::mapToSupervisorRepsonse).collect(Collectors.toList());
    }

    private SupervisorResponse mapToSupervisorRepsonse(Supervisor supervisor) {
        return SupervisorResponse.builder()
                .id(supervisor.getId())
                .FirstName(supervisor.getFirstName())
                .LastName(supervisor.getLastName())
                .Organisation(supervisor.getOrganisation())
                        .Nbre(supervisor.getNbre())
                        .build();
    }
    @Transactional (readOnly = true)
    @SneakyThrows
    public List<SupervisorResponse> isSubscribe(List<String>Organisation){
        log.info("Cheking subscriptions");
         supervisorRepository.findByOrganisationIn(Organisation).stream().
                map(supervisor -> {
                    return SupervisorResponse.builder()
                            .Organisation(supervisor.getOrganisation())
                            .isSubscribe(supervisor.getNbre()<0)

                            .build();
                });
//                .toList();
        return null;
    }

    public void delete(int id) {
        supervisorRepository.deleteById(id);
    }
}
