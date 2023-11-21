package com.example.demo.usuario.controller;

import com.example.demo.usuario.model.User;
import com.example.demo.usuario.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @GetMapping
    @Secured("ADMIN")
    public ResponseEntity<List<User>> persons() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PutMapping("/{email}")
    @Secured("ADMIN")
    public ResponseEntity<String> changeUser(@PathVariable String email, @RequestBody User user){
        String response = userService.update(email, user);

        if (Objects.equals(response, "Updated"))
            return ResponseEntity.status(200).body(response);
        else
            return ResponseEntity.status(404).body(response);
    }

    @PatchMapping("/{email}")
    public ResponseEntity<String> updateUser(@PathVariable String email, @RequestBody User user){
        String response = userService.patch(email, user);

        if (Objects.equals(response, "Updated"))
            return ResponseEntity.status(200).body(response);
        else
            return ResponseEntity.status(404).body(response);
    }

    @DeleteMapping("/{email}")
    @Secured("ADMIN")
    public ResponseEntity<String> deleteUser(@PathVariable String email) {
        boolean deleted = userService.deleteUser(email);

        if (deleted) {
            return new ResponseEntity<>("User deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }

}
