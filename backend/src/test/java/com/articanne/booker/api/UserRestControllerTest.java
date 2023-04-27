package com.articanne.booker.api;

import com.articanne.booker.model.User;
import com.articanne.booker.model.dto.UserDto;
import com.articanne.booker.service.RoleService;
import com.articanne.booker.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(UserRestController.class)
public class UserRestControllerTest {

    @InjectMocks
    private UserRestController userRestController;

    @Mock
    private UserService userService;

    @Mock
    private RoleService roleService;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    private User user1;
    private User user2;
    private UserDto userDto;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(userRestController).build();
        objectMapper = new ObjectMapper();

        // Setup example users and DTO
        // ... (use your own User and Role objects)
    }

    // CREATE
    /*@Test
    public void testCreateUser() throws Exception {
        when(userService.createUser(any(UserDto.class))).thenReturn(user1);

        mockMvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(user1.getId()))
                .andExpect(jsonPath("$.username").value(user1.getUsername()));

        verify(userService, times(1)).createUser(any(UserDto.class));
    }

    // GET
    @Test
    public void testGetUser() throws Exception {
        when(userService.findById(1L)).thenReturn(Optional.of(user1));

        mockMvc.perform(get("/api/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(user1.getId()))
                .andExpect(jsonPath("$.username").value(user1.getUsername()));

        verify(userService, times(1)).findById(1L);
    }

    @Test
    public void testGetUserNotFound() throws Exception {
        when(userService.findById(1L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/users/1"))
                .andExpect(status().isNotFound());

        verify(userService, times(1)).findById(1L);
    }

    @Test
    public void testGetAllUsers() throws Exception {
        List<User> users = Arrays.asList(user1, user2);
        when(userService.findAll()).thenReturn(users);

        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(users.size()))
                .andExpect(jsonPath("$[0].id").value(user1.getId()))
                .andExpect(jsonPath("$[0].username").value(user1.getUsername()))
                .andExpect(jsonPath("$[1].id").value(user2.getId()))
                .andExpect(jsonPath("$[1].username").value(user2.getUsername()));

        verify(userService, times(1)).findAll();
    }

    //UPDATE
    @Test
    public void testUpdateUser() throws Exception {
        when(userService.updateUser(eq(1L), any(UserDto.class))).thenReturn(user1);

        mockMvc.perform(put("/api/users/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(user1.getId()))
                .andExpect(jsonPath("$.username").value(user1.getUsername()));

        verify(userService, times(1)).updateUser(eq(1L), any(UserDto.class));
    }

    @Test
    public void testUpdateUserNotFound() throws Exception {
        when(userService.updateUser(eq(1L), any(UserDto.class))).thenThrow(RuntimeException.class);

        mockMvc.perform(put("/api/users/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userDto)))
                .andExpect(status().isNotFound());

        verify(userService, times(1)).updateUser(eq(1L), any(UserDto.class));
    }

    // DELETE
    @Test
    public void testDeleteUser() throws Exception {
        when(userService.findById(1L)).thenReturn(Optional.of(user1));

        mockMvc.perform(delete("/api/users/1"))
                .andExpect(status().isNoContent());

        verify(userService, times(1)).findById(1L);
        verify(userService, times(1)).deleteById(1L);
    }

    @Test
    public void testDeleteUserNotFound() throws Exception {
        when(userService.findById(1L)).thenReturn(Optional.empty());

        mockMvc.perform(delete("/api/users/1"))
                .andExpect(status().isNotFound());

        verify(userService, times(1)).findById(1L);
        verify(userService, times(0)).deleteById(anyLong());
    }*/

}