package com.springboot.controller;

import com.springboot.model.User;
import com.springboot.service.RoleService;
import com.springboot.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/r-api/")
public class MainRestController {

    private static final Logger log = LoggerFactory.getLogger(MainRestController.class);
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private RoleService roleService;

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        log.info("GET запрос на /r-api/getAllUsers");
        return userService.getAllUsers();
    }

    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable("id") Long id) {
        log.info("GET запрос на /r-api/getUser/{id}");
        return userService.getUserById(id);
    }

    @GetMapping("/search")
    public List<User> search (@RequestParam ("name") String searchName) {
        List<User> list = userService.findUsersBySearch(searchName);
        log.info("GET запрос на /r-api/search");
        return list;
    }

    @PostMapping("/create")
    public ResponseEntity<User> create(@RequestBody User user) {
        userService.saveUser(user);
        log.info("POST запрос на /r-api/create");
        return ResponseEntity.ok().body(user);
    }

    @PutMapping("/update")
    public ResponseEntity<User> update(@RequestBody User user) {
        userService.update(user);
        log.info("PUT запрос на /r-api/update");
        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        userService.deleteById(id);
        log.info("DELETE запрос на /r-api/delete/{id}");
    }

}

















//    @PostMapping("/createpost")
//    public String createUser(@ModelAttribute("person") User user,
//                             @RequestParam(value = "roles[]") String[] roles) {
//
//        Set<Role> roleSet = new HashSet<>();
//
//        for (String r: roles) {
//            roleSet.add(roleService.findRoleById(Long.parseLong(r)));
//        }
//        user.setRoles(roleSet);
//        userService.saveUser(user);
//        return "redirect:/bootstrap/adminpage";
//    }
//    @PostMapping("/save")
//    public String save(User user) {
//        userService.setDefaultRole(user);
//        userService.saveUser(user);
//        return "redirect:/bootstrap/adminpage";
//    }
//
//    @PostMapping("update/{id}")
//    public String update(@ModelAttribute User user,
//                         @RequestParam(value = "roles[]") String[] roles) {
//        Set<Role> roleSet = new HashSet<>();
//
//        for (String r: roles) {
//            roleSet.add(roleService.findRoleById(Long.parseLong(r)));
//        }
//        user.setRoles(roleSet);
//        userService.saveUser(user);
//        return "redirect:/bootstrap/adminpage";
//    }

