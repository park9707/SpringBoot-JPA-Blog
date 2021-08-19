package com.cos.blog.repository;

import com.cos.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//DAO
//@자동으로 bean등록이 됨, @Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    //SELECT * FROM user WHERE username= 1?;
    Optional<User> findByUsername(String username);
}


//    User findByUsernameAndPassword(String username,String password); //SELECT * FROM user WHERE username=? AND password=?;