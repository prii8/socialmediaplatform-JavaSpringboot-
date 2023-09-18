package com.hus23.assignment.socialmediaplatform.reprository;

import com.hus23.assignment.socialmediaplatform.entity.Post;
import com.hus23.assignment.socialmediaplatform.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {


   public void deleteAllByUser(User user);
   public Post findBylocation(String location);
}
