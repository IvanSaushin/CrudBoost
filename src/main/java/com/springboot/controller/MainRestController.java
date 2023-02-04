package com.springboot.controller;

import com.springboot.Application;
import com.springboot.model.User;
import com.springboot.service.RoleService;
import com.springboot.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
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
    public List<User>search(@RequestParam ("name") String name) {
        List <User> list = userService.getAllUsers();
        List <User> result = new LinkedList<>();
        for (User user:list) {
            if (user.getEmail().contains(name)) {
                result.add(user);
            }
        }
//      решение через for i
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).getEmail().contains(name)) {
//                result.add(list.get(i));
//            }
//        }
        return result;
    }

//    @EventListener (ApplicationReadyEvent.class)
//    public void init () {
//        List<User> list = userService.getAllUsers();
//
//        for (User user : list) {
//            System.out.println(user.getEmail());
//        }
//    }

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

