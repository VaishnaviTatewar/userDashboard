package com.example.userdashboard.service;

import com.example.userdashboard.converter.UserProfileConverter;
import com.example.userdashboard.dto.UserProfile;
import com.example.userdashboard.entities.CommunityEntity;
import com.example.userdashboard.entities.UserEntity;
import com.example.userdashboard.repository.UserProfileRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.example.userdashboard.utils.CommonUtil.mapToJson;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserProfileServiceTest {

    @MockBean
    private UserProfileRepository userProfileRepository;

    @MockBean
    private UserProfileConverter converter;

    @Autowired
    private UserProfileService userProfileService;

    @InjectMocks
    private UserProfileServiceTest userProfileServiceImpl;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getUserProfileDetailsTest() throws JsonProcessingException {
        CommunityEntity communityEntity = new CommunityEntity();
        communityEntity.setCommunityId(1);
        communityEntity.setCommunityName("Student");
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(1);
        userEntity.setUserName("test");
        userEntity.setEmailId("test@gmail.com");
        userEntity.setPassword("test");
        userEntity.setCommunityByCommunityId(communityEntity);

        UserProfile profile = UserProfile.builder()
                .userId(1)
                .userName("test")
                .communityName("Student")
                .emailId("test@gmail.com")
                .password("test")
                .build();

        when(userProfileRepository.findByUserId(1)).thenReturn(userEntity);
        when(converter.toUserProfile(userEntity)).thenReturn(profile);

        UserProfile actual = userProfileService.getUserProfileDetails(1);
        assertEquals(mapToJson(profile),mapToJson(actual));
    }

}
