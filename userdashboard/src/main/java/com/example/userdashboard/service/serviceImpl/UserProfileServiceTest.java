package com.example.userdashboard.service.serviceImpl;

import com.example.userdashboard.converter.UserProfileConverter;
import com.example.userdashboard.dto.UserProfile;
import com.example.userdashboard.entities.UserEntity;
import com.example.userdashboard.repository.UserProfileRepository;
import com.example.userdashboard.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserProfileServiceTest implements UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private UserProfileConverter converter;

    @Override
    public UserProfile getUserProfileDetails(int userId) {
        UserEntity userEntity = userProfileRepository.findByUserId(userId);
        return converter.toUserProfile(userEntity);
    }
}
