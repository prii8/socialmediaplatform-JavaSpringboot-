package com.hus23.assignment.socialmediaplatform.controller;

import com.hus23.assignment.socialmediaplatform.entity.User;
import com.hus23.assignment.socialmediaplatform.reprository.UserRespository;
import com.hus23.assignment.socialmediaplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class userController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRespository userRespository;
     @PostMapping("/users")
    public ResponseEntity<?> saveUser(@RequestBody User user){

         User user1 = userRespository.findByusername(user.getUsername());

         if(user1==null) {
             return ResponseEntity.ok().body(userRespository.save(user));
         }
         return ResponseEntity.ok().body("User Already Exists !!");
    }

    @GetMapping("/users")
    public List<User> fetchUserList() {
         return userService.fetchUserList();
    }

    @GetMapping("/users/{id}")
    public User fetchUserById(@PathVariable("id") Long userid){
           return userService.fetchUserById(userid);

    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable("id") Long userid)
    {
        userService.deleteUser(userid);
        return "account Deleted";
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable("id") Long userid,@RequestBody User user){
         return userService.updateUser(userid,user);
    }

    @GetMapping("users/username/{name}")
    public User fetchUserByusernmae(@PathVariable("name") String username)
    {
        return  userService.fetchUserByusername(username);
    }

    @GetMapping("users/search")
    public Optional<User> searchUsers(@RequestBody String name)
    {

        System.out.println(name);
        return userService.searchUsers(name);
    }








}
