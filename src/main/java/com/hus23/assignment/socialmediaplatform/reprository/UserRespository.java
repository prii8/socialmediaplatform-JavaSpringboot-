package com.hus23.assignment.socialmediaplatform.reprository;

import com.hus23.assignment.socialmediaplatform.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRespository extends JpaRepository<User,Long> {

    public User findByusername(String username);

//    @Query("SELECT user u FROM usertable x WHERE x.username = ?1 ")
    public Optional<User> findByfirstname(String firstname);


    //public List<User> findbyfirstnameAndlastname(String firstname,String lastname);
    //void  savePost(User user);

}
