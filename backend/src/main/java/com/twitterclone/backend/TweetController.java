package com.twitterclone.backend;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TweetController {
    @Autowired
    private TweetRepository tweetRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/tweets")
    public Tweet createRealTweet(@RequestBody Tweet incomingTweet){
        Long providedUserId = incomingTweet.getUser().getId();
        User realUser = userRepository.findById(providedUserId).orElseThrow(()->new RuntimeException("Error: UserID " +
                        providedUserId + " does not exist!"));
        incomingTweet.setUser(realUser);
        //receive the 'incomingTweet' from the frontend
        //save it to postgreSQL
        return tweetRepository.save(incomingTweet);
    }

    @GetMapping("/get-all-tweets")
    public List<Tweet> getTweets(){
        return tweetRepository.findAll();
    }

    @GetMapping("/users/{userId}/tweets")
    public List<Tweet> getUserTimeline(@PathVariable Long userId){
        return tweetRepository.findTimelineByUserId((userId));
    }
}
