package com.example.supervisor.service.repository;

import com.example.supervisor.service.model.Supervisor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SupervisorRepository extends MongoRepository<Supervisor,String> {
}
