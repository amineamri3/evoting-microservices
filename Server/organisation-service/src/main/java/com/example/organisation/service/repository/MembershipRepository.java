package com.example.organisation.service.repository;

import com.example.organisation.service.model.Membership;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembershipRepository extends JpaRepository<Membership,Long> {
}
