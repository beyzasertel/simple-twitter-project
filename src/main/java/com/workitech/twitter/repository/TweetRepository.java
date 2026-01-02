package com.workitech.twitter.repository;

import com.workitech.twitter.entity.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
    List<Tweet> findByUserId(Long userId);

    Optional<Tweet> findById(Long id);

    void deleteById(Long id);
}