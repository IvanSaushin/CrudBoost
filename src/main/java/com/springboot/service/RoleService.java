package com.springboot.service;

import com.springboot.model.Role;
import com.springboot.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Transient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role findRoleById(Long id){
        return roleRepository.findById(id).get();
    }

    public List<Role> getRoles() {
        return roleRepository.findAll();
    }
}
