package com.example.userdashboard.dto;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
public class UserProfile {

    private int userId;
    private String userName;
    private String communityName;
    private String emailId;
    private String password;

}
