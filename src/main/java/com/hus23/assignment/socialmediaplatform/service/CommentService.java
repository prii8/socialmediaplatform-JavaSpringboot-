package com.hus23.assignment.socialmediaplatform.service;

import com.hus23.assignment.socialmediaplatform.entity.Comments;
import com.hus23.assignment.socialmediaplatform.entity.Post;

public interface CommentService {



    public Comments createComment(long postid, Comments comments);

      public Comments updateComment(Long postid, Long commentid, Comments comments);

    public void deletePost(Long commentid);
}
