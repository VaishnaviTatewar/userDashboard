package com.example.userdashboard.controller;

import com.example.userdashboard.UserdashboardApplication;
import com.example.userdashboard.dto.UserProfile;
import com.example.userdashboard.service.UserProfileService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.example.userdashboard.utils.CommonUtil.mapToJson;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = UserdashboardApplication.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class UserProfileControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserProfileService userProfileService;

    private String URI;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getUserProfileTest() throws Exception {
        URI = "/dashboard/1";
        UserProfile profile = UserProfile.builder()
                                .userId(1)
                                .userName("test")
                                .communityName("Student")
                                .emailId("test@gmail.com")
                                .password("test")
                                .build();
        when(userProfileService.getUserProfileDetails(1)).thenReturn(profile);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI)
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expectedResult = mapToJson(profile);
        String actualResult = result.getResponse().getContentAsString();
        assertEquals(expectedResult,actualResult);
    }
}
