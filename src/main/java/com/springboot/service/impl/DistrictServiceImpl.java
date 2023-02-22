package com.springboot.service.impl;

import com.springboot.model.District;
import com.springboot.repository.DistrictRepo;
import com.springboot.service.DistrictService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    private DistrictRepo districtRepo;


    @Override
    public void save(District district) {
        districtRepo.save(district);
    }

    @Override
    public List<District> getAll() {
        return districtRepo.findAll();
    }

    @Override
    public District getById(Long id) {
        return districtRepo.findById(id).get();
    }

    @Override
    public void update(District district) {
        districtRepo.save(district);
    }

    @Override
    public void delete(Long id) {
        districtRepo.deleteById(id);
    }
}
