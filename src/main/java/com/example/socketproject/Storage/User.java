package com.example.socketproject.Storage;

import java.util.HashSet;
import java.util.Set;

public class User {
    private static User instance;
    private Set<String> users;

    private User(){
        users = new HashSet<>();
    }
    public static synchronized User getInstance(){
        if(instance==null){
            instance = new User();
        }
        return instance;
    }
    public Set<String> getUsers(){
        return users;
    }
    public void setUser(String username) throws Exception {
        if(users.contains(username)){
            throw new Exception("User already exist"+ username);
        }
        users.add(username);
    }
}
