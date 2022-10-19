package com.evoting.userservice.Services;

import com.evoting.userservice.Exceptions.UserNotFoundException;
import com.evoting.userservice.Models.Role;
import com.evoting.userservice.Models.User;
import com.evoting.userservice.Respository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User createUser(User user) {
        user.setPsw(passwordEncoder.encode(user.getPsw()));
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public Optional<User> getUserById(UUID id) {
        return userRepo.findById(id);
    }

    @Override
    public Optional<User> getUserByCin(Integer cin) {
        return userRepo.findByCin(cin);
    }

    @Override
    public List<User> getUsersByRole(Role role) {
        return userRepo.findByRole(role);
    }

    @Override
    public User updateUser(User userDto, UUID id) {
        Optional<User> user = this.userRepo.findById(id);
        if (user.isPresent()) {
            userDto.setId(id);
            return this.userRepo.save(userDto);
        } else {
            try {
                throw new UserNotFoundException(id);
            } catch (UserNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void deleteById(UUID id) {
        userRepo.deleteById(id);
    }

}
