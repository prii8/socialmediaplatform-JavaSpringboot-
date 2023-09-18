package com.hus23.assignment.socialmediaplatform.controller;

import com.hus23.assignment.socialmediaplatform.entity.Comments;
import com.hus23.assignment.socialmediaplatform.entity.Post;
import com.hus23.assignment.socialmediaplatform.entity.User;
import com.hus23.assignment.socialmediaplatform.reprository.CommentRepository;
import com.hus23.assignment.socialmediaplatform.reprository.PostRepository;
import com.hus23.assignment.socialmediaplatform.reprository.UserRespository;
import com.hus23.assignment.socialmediaplatform.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
public class commentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/comments/{postid}")
    public Comments saveComment(@PathVariable Long postid, @RequestBody Comments commets)
    {
        return commentService.createComment(postid,commets);
    }

    @PutMapping("/commentUpdate/{postId}/{commentId}")
    public Comments updateUser(@PathVariable Long postid,@PathVariable("id") Long commentid,@RequestBody Comments comments){
        return commentService.updateComment(postid, commentid,comments);
    }

    @DeleteMapping("/comment/deletebyid/{commentid}")
    public void deletePost(@PathVariable Long commentid)
    {
        commentService.deletePost(commentid);
    }






}
