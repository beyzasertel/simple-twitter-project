package com.workitech.twitter.repository;

import com.workitech.twitter.entity.Tweet;
import com.workitech.twitter.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);

}
