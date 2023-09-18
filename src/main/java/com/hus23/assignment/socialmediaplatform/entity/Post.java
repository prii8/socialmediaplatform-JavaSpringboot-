package com.hus23.assignment.socialmediaplatform.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "poststable")

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long postid;

    @Column(name = "description")
    private String description;

    @Column(name = "postDateTime")
    private LocalDateTime postDateTime;

    @Column(name="location")
    private String location;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private User user;

    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
    @JsonManagedReference
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Comments> comments= new ArrayList<>();

    public Post(){
        this.postDateTime=LocalDateTime.now();
    }

    public long getPostid() {
        return postid;
    }

    public void setPostid(long postid) {
        this.postid = postid;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getPostDateTime() {
        return postDateTime;
    }

    public void setPostDateTime(LocalDateTime postDateTime) {
        this.postDateTime = postDateTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postid=" + postid +
                ", postDateTime=" + postDateTime +
                ", location='" + location + '\'' +
                ", user=" + user +
                '}';
    }

    public Post(long postid, LocalDateTime postDateTime, String location, User user) {
        this.postid = postid;
        this.postDateTime = postDateTime;
        this.location = location;
        this.user = user;
    }
}
