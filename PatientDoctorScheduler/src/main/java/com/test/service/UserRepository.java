package com.test.service;

import org.springframework.data.repository.CrudRepository;

import com.test.dto.User;
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByName(String name);
}