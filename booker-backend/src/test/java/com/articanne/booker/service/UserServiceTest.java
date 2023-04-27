package com.articanne.booker.service;

import com.articanne.booker.repository.UserRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private RoleService roleService;

    /*@Test
    void shouldCreateUser() {
        // Given
        UserDto userCreateDto = new UserDto();
        userCreateDto.setUsername("exampleUser");
        userCreateDto.setPassword("examplePassword");
        userCreateDto.setRoles(Set.of("ROLE_USER"));

        User user = new User();
        user.setUsername(userCreateDto.getUsername());
        user.setPassword(userCreateDto.getPassword());

        Role role = new Role();
        role.setName("ROLE_USER");

        when(roleService.findByName("ROLE_USER")).thenReturn(Optional.of(role));
        when(userRepository.save(any(User.class))).thenReturn(user);

        // When
        User createdUser = userService.createUser(userCreateDto);

        // Then
        assertEquals(user.getUsername(), createdUser.getUsername());
        assertEquals(user.getPassword(), createdUser.getPassword());
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void shouldUpdateUser() {
        // Given
        Long userId = 1L;
        UserDto userUpdateDto = new UserDto();
        userUpdateDto.setUsername("updatedUser");
        userUpdateDto.setPassword("updatedPassword");
        userUpdateDto.setRoles(Set.of("ROLE_USER"));

        User user = new User();
        user.setId(userId);
        user.setUsername("exampleUser");
        user.setPassword("examplePassword");

        Role role = new Role();
        role.setName("ROLE_USER");

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(roleService.findByName("ROLE_USER")).thenReturn(Optional.of(role));
        when(userRepository.save(any(User.class))).thenReturn(user);

        // When
        User updatedUser = userService.updateUser(userId, userUpdateDto);

        // Then
        assertEquals(userUpdateDto.getUsername(), updatedUser.getUsername());
        assertEquals(userUpdateDto.getPassword(), updatedUser.getPassword());
        verify(userRepository, times(1)).findById(userId);
        verify(userRepository, times(1)).save(any(User.class));
    }*/

}