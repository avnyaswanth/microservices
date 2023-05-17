package com.user.application.controller;

import com.user.application.dto.UserDetails;
import com.user.application.entity.Userr;
import com.user.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public List<Userr> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("/addUser")
    public void addUser(@RequestBody Userr user) {
        userService.addUser(user);
    }

    @GetMapping("/getuserwithdept/{id}")
    public ResponseEntity<UserDetails> getUserWithDept(@PathVariable int id) {
        return ResponseEntity.ok(userService.getUserWithDept(id));
    }

}
