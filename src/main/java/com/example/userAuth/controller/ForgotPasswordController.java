package com.example.userAuth.controller;

import com.example.userAuth.dto.ForgotPasswordRequest;
import com.example.userAuth.dto.ForgotPasswordResponse;
import com.example.userAuth.service.ForgotPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class ForgotPasswordController {

    @Autowired
    private ForgotPasswordService forgotPasswordService;


    @PostMapping("/forgotPassword")
    public ResponseEntity<ForgotPasswordResponse>
              forgotPassword(@RequestBody ForgotPasswordRequest forgotPassword){
        ForgotPasswordResponse response = forgotPasswordService.forgotPassword(forgotPassword);
        return ResponseEntity.ok(response);
    }

}
