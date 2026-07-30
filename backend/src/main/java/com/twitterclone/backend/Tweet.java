package com.twitterclone.backend;

import jakarta.persistence.*;

@Entity
@Table(name ="tweets")

public class Tweet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(columnDefinition = "integer default 0")
    private int likes = 0;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public User getUser(){
        return user;
    }
    public void setUser(User user){
        this.user = user;
    }

    public int getLikes(){
        return likes;
    }
    public void setLikes(int likes){
        this.likes = likes;
    }
}
