package com.DocDB.controller;

import com.DocDB.common.AccountType;
import com.DocDB.common.Status;
import com.DocDB.entities.User;
import com.DocDB.exception.UserNotFoundException;
import com.DocDB.reposiory.IUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.DocDB.validator.UserValidator.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final IUserRepository userRepository;

    public User createUser(User user) {
        if (!isEmailValid(user.getEmail())) throw new RuntimeException("Invalid email.");
        verifyPassword(user.getPassword());
        if (findByEmail(user.getEmail()) != null) throw new RuntimeException("Email already in use.");
        if (findByUsername(user.getUsername()) != null) throw new RuntimeException("Username already in use.");
        user.setStatus(Status.UNCOMPLETED);
        user.setAccountType(AccountType.PATIENT);

        return userRepository.save(user);
    }

    User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    User login(String identifier, String password) {
        if (isEmailValid(identifier))
            return userRepository.findByEmailAndPassword(identifier, password).orElse(new User(0L));
        else
            return userRepository.findByUsernameAndPassword(identifier, password).orElse(new User(0L));

    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseGet(() -> {
            log.warn("user not found for id {}", id);
            throw new UserNotFoundException(id);
        });
    }

    public void removeUser(Long id) {
        User user = getUserById(id);
        userRepository.delete(user);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public List<User> findAllActivePatients() {
        return userRepository.findByStatusAndAccountType(Status.ACTIVE, AccountType.PATIENT);
    }

    public List<User> findAllSuspendedPatients() {
        return userRepository.findByStatusAndAccountType(Status.SUSPENDED, AccountType.PATIENT);
    }

    public List<User> findAllActiveDoctors() {
        return userRepository.findByStatusAndAccountType(Status.ACTIVE, AccountType.DOCTOR);
    }

}
