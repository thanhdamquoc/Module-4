package com.codegym.service.user;

import com.codegym.model.User;

import java.util.Optional;

public interface UserService {
    Iterable<User> findAll();
    Optional<User> findById(Long id);
    Optional<User> findByUsername(String username);
}
