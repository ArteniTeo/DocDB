package com.DocDB.reposiory;

import com.DocDB.entities.User;
import com.DocDB.common.AccountType;
import com.DocDB.common.Status;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public record UserRepository(IUserRepository repository) {
//    public User insert(User user) {
//        if (user.getId() != null) {
//            throw new IllegalArgumentException("Id provided");
//        }
//        return repository.save(user);
//    }
//
//    public User update(User user) {
//        if (user.getId() == null) {
//            throw new IllegalArgumentException("Null id provided");
//        }
//        return repository.save(user);
//    }
//
//    public void delete(User user) {
//        repository.delete(user);
//    }
//
//    public Optional<User> findById(Long id) {
//        return repository.findById(id);
//    }
//
//    public User findByEmail(String email){
//        return repository.findByEmail(email);
//    }
//    public User findByUsername(String username){
//        return repository.findByUsername(username);
//    }
//
//    public User login(String username, String password){
//        return repository.findByUsernameAndPassword(username, password);
//    }
//
//    public List<User> findAllActivePatients(){
//        return repository.findByStatusAndAccountType(Status.ACTIVE, AccountType.PATIENT);
//    }
//    public List<User> findAllSuspendedPatients(){
//        return repository.findByStatusAndAccountType(Status.SUSPENDED, AccountType.PATIENT);
//    }
//    public List<User> findAllActiveDoctors(){
//        return repository.findByStatusAndAccountType(Status.ACTIVE, AccountType.DOCTOR);
//    }
}
