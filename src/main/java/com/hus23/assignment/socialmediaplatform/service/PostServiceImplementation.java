package com.hus23.assignment.socialmediaplatform.service;

import com.hus23.assignment.socialmediaplatform.entity.Post;
import com.hus23.assignment.socialmediaplatform.entity.User;
import com.hus23.assignment.socialmediaplatform.reprository.PostRepository;
import com.hus23.assignment.socialmediaplatform.reprository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class PostServiceImplementation implements PostService{

    @Autowired
    private PostRepository postRespository;
    @Autowired
    private UserRespository userRespository;


    @Override
    public Post createPost(long userid, Post post) {

        try {

                User user = userRespository.findById(userid).get();
                post.setUser(user);
                return postRespository.save(post);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Post fetchPostById(Long postid) {
        return postRespository.findById(postid).get();
    }


    @Override
    public void deletePost(Long postid) {
        Optional<Post> postob =postRespository.findById(postid);
        if(postob.isPresent()){
            Post post=postob.get();
            postRespository.delete(post);
        }

    }

    @Override
    public void deletePostofUser(long userid) {
    Optional<User> userob=userRespository.findById(userid);
    if(userob.isPresent()){
        User user= userob.get();
        postRespository.deleteAllByUser(user);
    }
    }

    @Override
    public Post updatePost(Long userid, Long postid, Post post) {
        Post value = postRespository.findById(postid).get();

        if(Objects.nonNull(post.getDescription())){
            value.setDescription(post.getDescription());
        }
        if(Objects.nonNull(post.getLocation())){
            value.setLocation(post.getLocation());
        }
        return postRespository.save(value);
    }

    @Override
    public Post fetchpoatByLocation(String location) {
        return postRespository.findBylocation(location);
    }
}
