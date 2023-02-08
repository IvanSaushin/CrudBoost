package com.springboot.controller;

import com.springboot.model.User;
import com.springboot.service.RoleService;
import com.springboot.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/r-api/")
public class MainRestController {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private RoleService roleService;


    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/search")
    public List<User> search (@RequestParam ("name") String email) {
        List<User> list = userService.findUsersBySearch(email);
        return list;
    }

    @PostMapping("/create")
    public ResponseEntity<User> create(@RequestBody User user) {
        userService.saveUser(user);
        return ResponseEntity.ok().body(user);
    }

    @PutMapping("/update")
    public ResponseEntity<User> update(@RequestBody User user) {
        userService.update(user);
        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        userService.deleteById(id);
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

