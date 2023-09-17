package com.DocDB.reposiory;

import com.DocDB.common.AccountStatus;
import com.DocDB.entities.User;
import com.DocDB.common.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    User findByUsername(String username);

    Optional<User> findByUsernameAndPassword(String username, String password);

    Optional<User> findByEmailAndPassword(String email, String password);

    List<User> findByStatusAndAccountType(AccountStatus status, AccountType accountType);
}
