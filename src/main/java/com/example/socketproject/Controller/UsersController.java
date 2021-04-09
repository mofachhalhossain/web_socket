package com.example.socketproject.Controller;

import com.example.socketproject.Storage.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class UsersController {
    @GetMapping("/registration/{userName}")
    public ResponseEntity<Void> register(@PathVariable String userName){
        System.out.println("Handling user register request: " +userName);
        try {
            User.getInstance().setUser(userName);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/fetchAllUsers")
    public Set<String> fetchAllUsers(){
        return User.getInstance().getUsers();
    }
}
