package com.springboot.service;
import com.springboot.model.Address;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface AddressService {

    void save(Address address);
    List<Address> findAll();
    Address findById(Long id);
    void update(Address address);
    void deleteById(Long id);
}
