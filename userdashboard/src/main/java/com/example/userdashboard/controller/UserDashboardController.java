package com.example.userdashboard.controller;

import com.example.userdashboard.dto.UserProfile;
import com.example.userdashboard.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard")
public class UserDashboardController {
    @Autowired
    private UserProfileService userProfileService;

    @GetMapping("/{userId}")
    public UserProfile getUserProfile(@PathVariable int userId){
        return userProfileService.getUserProfileDetails(userId);
    }

}
