package com.hus23.assignment.socialmediaplatform.service;

import com.hus23.assignment.socialmediaplatform.entity.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface UserService {

    public User saveUser(User user);

   public List<User> fetchUserList();

    public User fetchUserById(Long userid);

    public void deleteUser(Long userid);

    public User updateUser(Long userid, User user);

    public User fetchUserByusername(String username);

    public Optional<User> searchUsers(String name);

    //public void createPost(User user, String description, LocalDateTime postDateTime,String location);

}
