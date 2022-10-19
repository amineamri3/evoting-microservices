package com.evoting.userservice.Respository;

import com.evoting.userservice.Models.Role;
import com.evoting.userservice.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepo extends JpaRepository<User, UUID> {
    Optional<User> findByCin(Integer cin);
    List<User> findByRole(Enum role);
    void deleteById(UUID id);
}
