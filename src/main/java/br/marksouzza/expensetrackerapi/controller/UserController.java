package br.marksouzza.expensetrackerapi.controller;

import br.marksouzza.expensetrackerapi.domain.User;
import br.marksouzza.expensetrackerapi.domain.UserModel;
import br.marksouzza.expensetrackerapi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> saveUser(@Valid @RequestBody UserModel user){
        return new ResponseEntity<User>(userService.create(user), HttpStatus.CREATED);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> readUser(@PathVariable Long id){
        return new ResponseEntity<User>(userService.read(id), HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@RequestBody UserModel user, @PathVariable Long id){
        return new ResponseEntity<User>(userService.update(user, id), HttpStatus.OK);

    }
}
