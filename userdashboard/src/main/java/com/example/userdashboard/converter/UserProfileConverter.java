package com.example.userdashboard.converter;


import com.example.userdashboard.dto.UserProfile;
import com.example.userdashboard.entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserProfileConverter {

    public UserProfile toUserProfile(UserEntity userEntity) {
        return UserProfile.builder()
                .userId(userEntity.getUserId())
                .emailId(userEntity.getEmailId())
                .userName(userEntity.getUserName())
                .communityName(userEntity.getCommunityByCommunityId().getCommunityName())
                .password(userEntity.getPassword())
                .build();

    }

}
