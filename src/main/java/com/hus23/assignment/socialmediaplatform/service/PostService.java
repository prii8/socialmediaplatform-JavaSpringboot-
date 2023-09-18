package com.hus23.assignment.socialmediaplatform.service;

import com.hus23.assignment.socialmediaplatform.entity.Post;
import com.hus23.assignment.socialmediaplatform.entity.User;

public interface PostService {




   public Post createPost(long userid, Post post);

   public Post fetchPostById(Long postid);

  public void deletePost(Long postid);


   public void deletePostofUser(long userid);

   public Post updatePost(Long userid, Long postid, Post post);

   public  Post fetchpoatByLocation(String location);
}
