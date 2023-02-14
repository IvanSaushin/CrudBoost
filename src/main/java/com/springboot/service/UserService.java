package com.springboot.service;

import com.springboot.model.Role;
import com.springboot.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface UserService {

    void saveUser(User user);

    List<User> getAllUsers();
    List<User> findUsersBySearch(String searchName);

    User findUserByFirstname(String firstname);

    User getUserByEmail(String email);

    User getUserById(Long id);

    void update(User user);

    void deleteById(Long id);

    Role getRole(String rolename);

    void setRole(User user, String role);

    void setDefaultRole(User user);

}
