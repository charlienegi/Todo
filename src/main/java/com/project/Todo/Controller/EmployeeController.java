package com.project.Todo.Controller;

import com.project.Todo.Model.User;
import com.project.Todo.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private AuthService authService;
    @GetMapping("/register")
    public RedirectView Registerview(){
        return new RedirectView("/register");
    }
    @PostMapping("/savedata")
    public User Registration(User user){
        return authService.SaveData(user);
    }

    public ResponseEntity<?> Login(User user){
        ResponseEntity<?> login = authService.Login(user);
        if(login.getStatusCodeValue()==200){
            return ResponseEntity.ok().body(user);
        }
        else {
            return ResponseEntity.badRequest().body("Invalid Credentials");
        }
    }
}
