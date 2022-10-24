package com.example.supervisor.service.repository;

import com.example.supervisor.service.model.Supervisor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SupervisorRepository extends MongoRepository<Supervisor,String> {
    List <Supervisor> findByOrganisationIn(List<String>Organisation);

    void deleteById(int id);
}
