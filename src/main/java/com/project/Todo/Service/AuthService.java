package com.project.Todo.Service;

import com.project.Todo.Model.User;
import com.project.Todo.Repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private AuthRepository authRepository;

    public User SaveData(User user){
        return authRepository.save(user);
    }
    public ResponseEntity<?> Login(User user){
        User byUsername = authRepository.findByUsername(user.getUsername());
        if(byUsername.getEmail().equals(user.getEmail())&&
        byUsername.getPassword().equals(user.getPassword())){
            return ResponseEntity.ok().body("Login have successfully");
        }
        else {
            return ResponseEntity.badRequest().body("Invalid Credentials");
        }
    }
}
