package com.springboot.controller;


import com.springboot.model.District;
import com.springboot.service.DistrictService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/district")
public class DistrictController {

    @Autowired
    DistrictService districtService;

    @GetMapping("/")
    public List<District> getDistrict() {
        log.info("Запрошен список областей");
        return districtService.getAll();
    }

    @GetMapping("/getUser/{id}")
    public District getUser(@PathVariable("id") Long id) {
        return districtService.getById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<District> create(@RequestBody District district) {
        log.info("Получен запрос на сохранение областей");
        districtService.save(district);
        return ResponseEntity.ok().body(district);
    }

    @PutMapping("/update")
    public ResponseEntity<District> update(@RequestBody District district) {
        districtService.update(district);
        return ResponseEntity.ok().body(district);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        districtService.delete(id);
    }
}
