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

import static com.DocDB.validator.UserValidator.verifyEmail;
import static com.DocDB.validator.UserValidator.verifyPassword;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final IUserRepository repository;

    public User createUser(User user) {
        verifyEmail(user.getEmail());
        verifyPassword(user.getPassword());
        if(findByEmail(user.getEmail()) != null) throw new RuntimeException("Email already in use.");
        if (findByUsername(user.getUsername()) != null) throw new RuntimeException("Username already in use.");

        return repository.save(user);
    }

    User findByEmail(String email){
        return repository.findByEmail(email);
    }
    User findByUsername(String username){
        return repository.findByUsername(username);
    }
    User login(String username, String password){
        return repository.findByUsernameAndPassword(username, password);
    }

    public User getUserById(Long id) {
        return repository.findById(id).orElseGet(() -> {
            log.warn("user not found for id {}", id);
            throw new UserNotFoundException(id);
        });
    }

    public void removeUser(Long id) {
        User user = getUserById(id);
        repository.delete(user);
    }

    public User updateUser(User user) {
        return repository.save(user);
    }

    public List<User> findAllActivePatients(){
        return repository.findByStatusAndAccountType(Status.ACTIVE, AccountType.PATIENT);
    }
    public List<User> findAllSuspendedPatients(){
        return repository.findByStatusAndAccountType(Status.SUSPENDED, AccountType.PATIENT);
    }
    public List<User> findAllActiveDoctors(){
        return repository.findByStatusAndAccountType(Status.ACTIVE, AccountType.DOCTOR);
    }

}
