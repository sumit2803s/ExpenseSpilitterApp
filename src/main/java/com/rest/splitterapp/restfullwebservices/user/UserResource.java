package com.rest.splitterapp.restfullwebservices.user;


import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {
    private UserDaoService service;
    public UserResource(UserDaoService service) {
        this.service=service;
    }
    @GetMapping("/users")
    public List<User> RetrieveAllUsers(){
        return service.findAll();
    }
    @GetMapping("/users/{id}")
    public User RetrieveUsers(@PathVariable int id){
        User user = service.findOne(id);
        if(user==null)
            throw new UserNotFoundExecption("id"+id);
        return user;
    }
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        service.deleteById(id);
    }
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser=service.save(user);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(null).build();
    }
}

