package com.twitterclone.backend;

import jakarta.persistence.*;

@Entity
@Table(name ="tweets")

public class Tweet{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;
    private String author;

    public Tweet(){}

    public Tweet(String content, String author){
        this.content = content;
        this.author = author;
    }
    public Long getId(){return id;}
    public String getContent(){return content;}
    public void setContent(String content){this.content = content;}
    public String getAuthor(){return author;}
    public void setAuthor(String author){this.author = author;}
}
