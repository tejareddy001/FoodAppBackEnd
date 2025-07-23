package com.example.userAuth.service;
import com.example.userAuth.model.User;
import com.example.userAuth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Register user
    public String registerUser(User user) {
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            return "User already exists with this email.";
        }
        userRepository.save(user);
        return "Registration successful.";
    }

    // Login user
    public String loginUser(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return "Login successful.";
        }
        return "Invalid email or password.";
    }

    public String changePassword(String email, String oldPassword, String newPassword) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (user.getPassword().equals(oldPassword)) {
                user.setPassword(newPassword);
                userRepository.save(user);
                return "Password changed successfully";
            }
        }
        return "Invalid email or old password";
    }

    public String forgotPassword(String email, String phoneNumber){
        Optional<User> optionaluser = userRepository.findByPhoneNumber(phoneNumber);
        if(optionaluser.isPresent()){
           User user = optionaluser.get();
           return user.getPassword();
        }
        return "user does not exist";
    }
}