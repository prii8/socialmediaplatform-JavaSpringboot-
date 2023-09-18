package com.hus23.assignment.socialmediaplatform.service;

import com.hus23.assignment.socialmediaplatform.entity.Post;
import com.hus23.assignment.socialmediaplatform.entity.User;
import com.hus23.assignment.socialmediaplatform.reprository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImplimentation implements UserService {

    @Autowired
    private UserRespository userRespository;
    @Override
    public User saveUser(User user) {


            return userRespository.save(user);


    }

    @Override
    public List<User> fetchUserList() {
        return userRespository.findAll();

    }

    @Override
    public User fetchUserById(Long userid) {
        return userRespository.findById(userid).get();
    }

    @Override
    public void deleteUser(Long userid) {
        userRespository.deleteById(userid);

    }



    @Override
    public User updateUser(Long userid, User user) {
        User updatedUserdb = userRespository.findById(userid).get();
        List<User> list;

        list = userRespository.findAll();

        if(Objects.nonNull(user.getUsername()) && !"".equalsIgnoreCase(user.getUsername()))
        {
            updatedUserdb.setUsername(user.getUsername());
        }

        if(Objects.nonNull(user.getFirstname()) && !"".equalsIgnoreCase(user.getFirstname()))
        {
            updatedUserdb.setFirstname(user.getFirstname());
        }

        if(Objects.nonNull(user.getLastname()) && !"".equalsIgnoreCase(user.getLastname()))
        {
            updatedUserdb.setLastname(user.getLastname());
        }

        if(Objects.nonNull(user.getBio()) && !"".equalsIgnoreCase(user.getBio()))
        {
            updatedUserdb.setBio(user.getBio());
        }

        if(Objects.nonNull(user.getPassword()) && !"".equalsIgnoreCase(user.getPassword()))
        {
            updatedUserdb.setPassword(user.getPassword());
        }

        return userRespository.save(updatedUserdb);
    }

    @Override
    public User fetchUserByusername(String username) {
        return userRespository.findByusername(username);
    }

    @Override
    public Optional<User> searchUsers(String name) {
        if (name!=null) {
            return userRespository.findByfirstname(name);
        }

//        } else if (lastname!=null) {
//           return userRespository.findBylastname(lastname);
//        }
        else{
            throw new IllegalArgumentException("provide search parameter");
        }
    }


}
