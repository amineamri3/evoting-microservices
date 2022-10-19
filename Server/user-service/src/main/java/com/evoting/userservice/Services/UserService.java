package com.evoting.userservice.Services;

import com.evoting.userservice.Models.Role;
import com.evoting.userservice.Models.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface UserService {

    List<User> getAllUsers();

    Optional<User> getUserById(UUID id);

    User createUser(User employee);

    User updateUser(User employee, UUID id);

    void deleteById(UUID id);

    Optional<User> getUserByCin(Integer cin);

    List<User> getUsersByRole(Role role);
}
