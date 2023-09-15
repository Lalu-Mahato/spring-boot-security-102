package com.example.springbootsecurity102.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springbootsecurity102.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}