package com.goit.Spring.Boot.controllerTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collection;
import java.util.Collections;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//Помилка яка вискакує ,може бути пов'язане з конфігурацією моєї тестової середи та використовуваною віртуальною машиною Java (JVM).

@ExtendWith({SpringExtension.class, MockitoExtension.class})
@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserDetails userDetails;

    @Test
    void testGetUserInfo() throws Exception {
        // Arrange
        doReturn("testUser").when(userDetails).getUsername();
        Collection<? extends GrantedAuthority> authorities = Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
        doReturn(authorities).when(userDetails).getAuthorities();
        doReturn(true).when(userDetails).isEnabled();
        doReturn("password").when(userDetails).getPassword();

        // Act & Assert
        mockMvc.perform(get("/api/userInfo"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.Name").value("testUser"))
                .andExpect(jsonPath("$.Authorities[0]").value("ROLE_USER"))
                .andExpect(jsonPath("$.isEnabled").value("true"))
                .andExpect(jsonPath("$.Password").value("password"));
    }
}
