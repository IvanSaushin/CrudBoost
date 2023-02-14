package com.springboot.service.impl;

import com.springboot.model.Role;
import com.springboot.repository.RoleRepository;
import com.springboot.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findRoleById(Long id) {
        log.debug("Запрошена роль по id = " + id);
        return roleRepository.findById(id).get();
    }

    @Override
    public List<Role> getRoles() {
        log.debug("Запрошен список ролей");
        return roleRepository.findAll();
    }
}
