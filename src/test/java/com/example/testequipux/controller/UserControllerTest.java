package com.example.testequipux.controller;

import com.example.testequipux.entity.User;
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
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
@Import({SecurityConfig.class, JwtAuthenticationFilter.class, RestAuthenticationEntryPoint.class, RestAccessDeniedHandler.class})
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private JwtTokenProvider jwtTokenProvider;

    @Test
    void shouldRequireAuthenticationForUserList() throws Exception {
        mockMvc.perform(get("/api/v1/user/list"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser
    void shouldReturnUserListWhenAuthenticated() throws Exception {
        User user = new User();
        user.setId(1L);
        user.setName("John");
        user.setLastName("Doe");
        user.setEmail("john@example.com");
        user.setDocument("12345678901");

        given(userService.listUsers()).willReturn(List.of(user));

        mockMvc.perform(get("/api/v1/user/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].email").value("john@example.com"));
    }
}
