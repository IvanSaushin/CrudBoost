package com.springboot.controller;


import com.springboot.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/district")
public class DistrictController {


    @GetMapping("/")
    public void getDistrict() {
        log.info("Запрошен список областей");
    }


    @PostMapping("/create")
    public void postDisstrict(@RequestBody User user) {
        log.info("Получен запрос на сохранение областей");
    }
}
