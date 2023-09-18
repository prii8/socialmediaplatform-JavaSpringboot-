package com.hus23.assignment.socialmediaplatform.service;

import com.hus23.assignment.socialmediaplatform.entity.Comments;
import com.hus23.assignment.socialmediaplatform.entity.Post;
import com.hus23.assignment.socialmediaplatform.entity.User;
import com.hus23.assignment.socialmediaplatform.reprository.CommentRepository;
import com.hus23.assignment.socialmediaplatform.reprository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class CommentServiceImplentation implements CommentService {

    @Autowired
    private PostRepository postRespository;
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comments createComment(long postid, Comments comments) {
        Post post=postRespository.findById(postid).get();
      comments.setPost(post);
       return commentRepository.save(comments);
    }

    @Override
    public Comments updateComment(Long postid, Long commentid, Comments comments) {
        Comments value = commentRepository.findById(commentid).get();

        if(Objects.nonNull(comments.getComment())){
            value.setComment(comments.getComment());
        }

        return commentRepository.save(value);
    }

    @Override
    public void deletePost(Long commentid) {
        Optional<Comments> commentob =commentRepository.findById(commentid);
        if(commentob.isPresent()){
            Comments comment=commentob.get();
            commentRepository.delete(comment);
        }
    }

    //    @Override
//    public Comments createComment(long postid, Comments comments) {
//        Post post=postRespository.findById(postid).get();
//        comments.setPost(post);
//        return commentRepository.save(comments);
//    }
}
