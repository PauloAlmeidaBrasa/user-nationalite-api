package com.example.testequipux.controller;

import com.example.testequipux.dto.request.LoginRequest;
import com.example.testequipux.dto.response.LoginResponse;
import com.example.testequipux.security.JwtAuthenticationFilter;
import com.example.testequipux.security.JwtTokenProvider;
import com.example.testequipux.security.RestAccessDeniedHandler;
import com.example.testequipux.security.RestAuthenticationEntryPoint;
import com.example.testequipux.security.SecurityConfig;
import com.example.testequipux.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AuthController.class)
@Import({SecurityConfig.class, JwtAuthenticationFilter.class, RestAuthenticationEntryPoint.class, RestAccessDeniedHandler.class})
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private JwtTokenProvider jwtTokenProvider;

    @Test
    void shouldReturnJwtTokenWhenLoginIsSuccessful() throws Exception {
        given(userService.login(anyString(), anyString())).willReturn("test-jwt-token");

        String requestBody = "{\"email\":\"test@example.com\",\"password\":\"secret123\"}";

        mockMvc.perform(post("/api/v1/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").value("test-jwt-token"));
    }
}
