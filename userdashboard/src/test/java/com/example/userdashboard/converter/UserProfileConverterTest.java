package com.example.userdashboard.converter;

import com.example.userdashboard.dto.UserProfile;
import com.example.userdashboard.entities.CommunityEntity;
import com.example.userdashboard.entities.UserEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.example.userdashboard.utils.CommonUtil.mapToJson;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserProfileConverterTest {

    @Autowired
    private UserProfileConverter userProfileConverter;

    @Test
    public void getUserProfileTest() throws JsonProcessingException {
        CommunityEntity communityEntity = new CommunityEntity();
        communityEntity.setCommunityId(1);
        communityEntity.setCommunityName("Student");
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(1);
        userEntity.setUserName("test");
        userEntity.setEmailId("test@gmail.com");
        userEntity.setPassword("test");
        userEntity.setCommunityByCommunityId(communityEntity);

        UserProfile userProfileExpected = UserProfile.builder()
                .userId(1)
                .userName("test")
                .communityName("Student")
                .emailId("test@gmail.com")
                .password("test")
                .build();

        UserProfile userProfileActual = userProfileConverter.toUserProfile(userEntity);
        assertEquals(mapToJson(userProfileExpected), mapToJson(userProfileActual));

    }
}
