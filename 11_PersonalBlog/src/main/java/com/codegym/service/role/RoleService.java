package com.codegym.service.role;

import com.codegym.model.Role;

import java.util.Optional;

public interface RoleService {
    Iterable<Role> findAll();
    Optional<Role> findById(Long id);
    Role save(Role role);
    void deleteById(Long id);
}
