package com.example.wheelmanager;

import com.example.wheelmanager.domain.model.User;
import com.example.wheelmanager.domain.repository.UserRepository;
import com.example.wheelmanager.domain.service.UserService;
import com.example.wheelmanager.exception.ResourceNotFoundException;
import com.example.wheelmanager.service.UserServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class UserServiceImplIntegrationTest {
    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @TestConfiguration
    static class UserServiceImplTestConfiguration{
        @Bean
        public UserService userService(){
            return new UserServiceImpl();
        }
    }

    @Test
    @DisplayName("When Get User By Id With Valid Id Then Returns User")
    public void whenGetUserByIdWithValidIdThenReturnsUser(){
        // Arrange
        Long id = 1L;
        User user = new User();
        user.setId(id).setName("Jose");
        when(userRepository.findById(id))
                .thenReturn(Optional.of(user));
        // Act
        User foundUser = userService.getUserById(id);
        // Assert
        assertThat(foundUser.getId()).isEqualTo(id);
    }

    @Test
    @DisplayName("When Get User By Id With Invalid Id Then Returns ResourceNotFoundException")
    public void whenGetUserByIdWithInvalidIdThenReturnsResourceNotFoundException(){
        // Arrange
        Long userid = 1L;
        String template = "Resource %s not found for %s with value %s";
        when(userRepository.findById(userid))
                .thenReturn(Optional.empty());
        String expectedMessage = String.format(template,"User","Id",userid);
        // Act
        Throwable exception = catchThrowable(() -> {
            User foundUser = userService.getUserById(userid);
        });
        // Assert
        assertThat(exception).isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);
    }
}
