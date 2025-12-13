package com.example.userAuth.service;

import com.example.userAuth.dto.ForgotPasswordRequest;
import com.example.userAuth.dto.ForgotPasswordResponse;

public interface ForgotPasswordService {

    ForgotPasswordResponse forgotPassword(ForgotPasswordRequest forgotPasswordRequest);
}