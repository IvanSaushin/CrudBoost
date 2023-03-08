package com.springboot.service.impl;

import com.springboot.model.Address;
import com.springboot.repository.AddressRepository;
import com.springboot.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;

    @Autowired
    public void setAddressService (AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public void save(Address address) {
        addressRepository.save(address);
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address find(Long id) {
        return addressRepository.findById(id).get();
    }

    @Override
    public void update(Address address) {
        addressRepository.save(address);
    }

    @Override
    public void delete(Long id) {
        addressRepository.deleteById(id);
    }

}
