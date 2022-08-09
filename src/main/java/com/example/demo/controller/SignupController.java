package com.example.demo.controller;

import com.example.demo.dto.ActivityDTO;
import com.example.demo.dto.CamperDTO;
import com.example.demo.dto.CreateSignupDTO;
import com.example.demo.service.CamperService;
import com.example.demo.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signups")
public class SignupController {
    @Autowired
    SignupService signupService;

    @PostMapping // localhost:8080/signup post
    public ActivityDTO createSignup(@RequestBody CreateSignupDTO signupDTO){
        return signupService.createSignup(signupDTO);
    }
}
