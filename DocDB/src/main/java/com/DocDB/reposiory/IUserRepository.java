package com.DocDB.reposiory;

import com.DocDB.entities.User;
import com.DocDB.dto.AccountType;
import com.DocDB.dto.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
    User findByUsername(String username);
    User findByUsernameAndPassword(String username, String password);

    List<User> findByStatusAndAccountType(Status status, AccountType accountType );
}
