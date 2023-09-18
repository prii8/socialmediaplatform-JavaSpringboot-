package com.hus23.assignment.socialmediaplatform.controller;

import com.hus23.assignment.socialmediaplatform.entity.Post;
import com.hus23.assignment.socialmediaplatform.entity.User;
import com.hus23.assignment.socialmediaplatform.service.PostService;
import com.hus23.assignment.socialmediaplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class postController {

    @Autowired
    private  PostService postService;







    @PostMapping("/post/{userid}")
    public Post savePost(@PathVariable long userid, @RequestBody Post post)
    {
        return postService.createPost(userid,post);
    }

    @GetMapping("/post/{id}")
    public Post fetchPostById(@PathVariable("id") Long postid){
        return postService.fetchPostById(postid);

    }



    @DeleteMapping("/post/deletebyid/{postid}")
    public void deletePost(@PathVariable Long postid)
    {
        postService.deletePost(postid);
    }

    @DeleteMapping("/post/delete/{userid}")
    public void deletePostOfUser(@PathVariable long userid){
        postService.deletePostofUser(userid);
    }

    @PutMapping("/postupdate/{userid}/{id}")
    public Post updateUser(@PathVariable Long userid,@PathVariable("id") Long postid,@RequestBody Post post){
        return postService.updatePost(userid, userid,post);
    }

    @GetMapping("/post/location/{location}")
    public Post fetchpoatByLocation(@PathVariable("location") String location)
    {
        return postService.fetchpoatByLocation(location);
    }





}
