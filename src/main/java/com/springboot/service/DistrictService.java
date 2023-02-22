package com.springboot.service;

import com.springboot.model.District;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface DistrictService {

    void save(District user);

    List<District> getAll();

    District getById(Long id);

    void update(District user);

    void delete(Long id);
}
