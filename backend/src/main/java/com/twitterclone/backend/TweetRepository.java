package com.twitterclone.backend;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet,Long> {
    @Query(value = "SELECT * FROM tweets WHERE user_id = ?1 ORDER BY id DESC", nativeQuery = true)
    List<Tweet> findTimelineByUserId(Long userId);
    @Modifying
    @Transactional
    @Query(value = "UPDATE tweets SET likes = likes +1 WHERE id = ?1",nativeQuery = true)
    void incrementLikes(Long tweetId);
}
