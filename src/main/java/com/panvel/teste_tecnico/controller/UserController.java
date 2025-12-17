package com.panvel.teste_tecnico.controller;

import com.panvel.teste_tecnico.entities.User;
import com.panvel.teste_tecnico.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/usuario")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok().body(this.userService.getUsers());
    }

    @GetMapping("{id}")
    public User getUserById(@PathVariable UUID id){
        try{
            return this.userService.getUserById(id);
        } catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @PostMapping
    public User addUser(@RequestBody User user){
        try{
            return this.userService.addUser(user);
        } catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("{id}")
    public User updateUser(@PathVariable UUID id, @RequestBody User user){
        try{
            return this.userService.updateUser(id, user);
        } catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public String deleteUser(@PathVariable UUID id){
        try{
            return this.userService.deleteUser(id);
        } catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

}
