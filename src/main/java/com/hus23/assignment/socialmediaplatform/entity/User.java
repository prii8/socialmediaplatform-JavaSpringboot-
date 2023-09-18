package com.hus23.assignment.socialmediaplatform.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "usertable")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long userId;
    @Column(name="username",unique = false)
    private String username;
    @Column(name="Firstname",nullable = false)
    private String firstname;
    @Column(name="Lastname",nullable = false)
    private String lastname;
    @Column(name = "Password",nullable = false)
    private String password;
    @Column(name="Bio" ,nullable = true)
    private String bio;

    private String followers;

    private String following;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonManagedReference
    @OnDelete(action = OnDeleteAction.CASCADE)
    @OrderBy("postDateTime DESC")
    private List<Post> posts= new ArrayList<>();

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
       this.firstname = firstname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public User(long userId, String username, String firstname, String lastname, String password, String bio) {
        this.userId = userId;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.bio = bio;
    }


    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", Firstname='" + firstname + '\'' +
                ", Lastname='" + lastname + '\'' +
                ", Bio='" + bio + '\'' +
                ", Password='" + password + '\'' +
                '}';
    }
}
