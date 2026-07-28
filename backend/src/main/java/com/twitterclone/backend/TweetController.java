package com.twitterclone.backend;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@RestController
public class TweetController {
    @Autowired
    private TweetRepository tweetRepository;

    @PostMapping("/tweets")
    public Tweet createRealTweet(@RequestBody Tweet incomingTweet){
        //receive the 'incomingTweet' from the frontend
        //save it to postgreSQL
        return tweetRepository.save(incomingTweet);
    }

    @GetMapping("/get-all-tweets")
    public List<Tweet> getTweets(){
        return tweetRepository.findAll();
    }
}
