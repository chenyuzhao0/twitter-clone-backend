package com.twitterclone.backend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet,Long> {
    @Query(value = "SELECT * FROM tweets WHERE user_id = ?1 ORDER BY id DESC", nativeQuery = true)
    List<Tweet> findTimelineBuUserId(Long userId);

    List<Tweet> findTimelineByUserId(Long userId);
}
