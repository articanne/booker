package com.articanne.booker.api;

import com.articanne.booker.model.dto.RoleDto;
import com.articanne.booker.service.RoleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


@ExtendWith(SpringExtension.class)
@WebMvcTest(RoleRestController.class)
public class RoleRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RoleService roleService;

    @Autowired
    private ObjectMapper objectMapper;

    private RoleDto role1;
    private RoleDto role2;
    private RoleDto roleDto;

    @BeforeEach
    public void setUp() {
        role1 = new RoleDto("ROLE_USER");
        role2 = new RoleDto("ROLE_ADMIN");

        roleDto = new RoleDto();
        roleDto.setName("ROLE_USER");
    }


    /*// CREATE
    @Test
    @WithMockUser
    public void testCreateRole() throws Exception {
        when(roleService.createRole(any(RoleDto.class))).thenReturn(role1);

        mockMvc.perform(post("/api/roles")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(roleDto))
                        .with(csrf())
                )
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(role1.getId()))
                .andExpect(jsonPath("$.name").value(role1.getName()));

        verify(roleService, times(1)).createRole(any(RoleDto.class));
    }

    // GET
    @Test
    @WithMockUser
    public void testGetRole() throws Exception {
        when(roleService.findById(1L)).thenReturn(Optional.of(role1));

        mockMvc.perform(get("/api/roles/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(role1.getId()))
                .andExpect(jsonPath("$.name").value(role1.getName()));

        verify(roleService, times(1)).findById(1L);
    }

    @Test
    @WithMockUser
    public void testGetRoleNotFound() throws Exception {
        when(roleService.findById(1L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/roles/1"))
                .andExpect(status().isNotFound());

        verify(roleService, times(1)).findById(1L);
    }

    @Test
    @WithMockUser
    public void testGetAllRoles() throws Exception {
        when(roleService.findAll()).thenReturn(Arrays.asList(role1, role2));

        mockMvc.perform(get("/api/roles"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(role1.getId()))
                .andExpect(jsonPath("$[0].name").value(role1.getName()))
                .andExpect(jsonPath("$[1].id").value(role2.getId()))
                .andExpect(jsonPath("$[1].name").value(role2.getName()));

        verify(roleService, times(1)).findAll();

    }

    // UPDATE
    @Test
    @WithMockUser
    public void testUpdateRole() throws Exception {
        when(roleService.updateRole(eq(1L), any(RoleDto.class))).thenReturn(role1);

        mockMvc.perform(put("/api/roles/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(roleDto))
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(role1.getId()))
                .andExpect(jsonPath("$.name").value(role1.getName()));

        verify(roleService, times(1)).updateRole(eq(1L), any(RoleDto.class));
    }

    @Test
    @WithMockUser
    public void testUpdateRoleNotFound() throws Exception {
        when(roleService.updateRole(eq(1L), any(RoleDto.class))).thenThrow(new RuntimeException("Role not found"));

        mockMvc.perform(put("/api/roles/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(roleDto))
                        .with(csrf()))
                .andExpect(status().isNotFound());

        verify(roleService, times(1)).updateRole(eq(1L), any(RoleDto.class));
    }

    // DELETE
    @Test
    @WithMockUser
    public void testDeleteRole() throws Exception {
        when(roleService.findById(1L)).thenReturn(Optional.of(role1));

        mockMvc.perform(delete("/api/roles/1")
                        .with(csrf()))
                .andExpect(status().isNoContent());

        verify(roleService, times(1)).findById(1L);
        verify(roleService, times(1)).deleteById(1L);
    }

    @Test
    @WithMockUser
    public void testDeleteRoleNotFound() throws Exception {
        when(roleService.findById(1L)).thenReturn(Optional.empty());

        mockMvc.perform(delete("/api/roles/1")
                        .with(csrf()))
                .andExpect(status().isNotFound());

        verify(roleService, times(1)).findById(1L);
        verify(roleService, times(0)).deleteById(1L);
    }*/

}
