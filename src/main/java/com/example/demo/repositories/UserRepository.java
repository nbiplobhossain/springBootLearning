package com.example.demo.repositories;

import com.example.demo.schemas.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByEmailAndName(String email,String name);
    User findById(int id);

    @Query("SELECT u from user u where id = ?1")
    User customFind(int id);
}
