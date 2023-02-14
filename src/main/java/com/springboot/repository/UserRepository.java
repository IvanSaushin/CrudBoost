package com.springboot.repository;

import com.springboot.model.Role;
import com.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByFirstname(String firstname);

    @Query("from User where email =:email")
    User getUserByEmail(@Param("email") String email);

    @Query("from User where email like concat('%', :email, '%')")
    List<User> findUsersBySearch(@Param("email") String searchName);

    @Query("from Role where role = :name")
    Role getRole(@Param("name") String name);

}
