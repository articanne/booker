package com.articanne.booker.api;

import com.articanne.booker.model.dto.RoleDto;
import com.articanne.booker.model.dto.RoleDtoWithID;
import com.articanne.booker.model.exception.RoleNotFoundException;
import com.articanne.booker.service.RoleService;
import com.articanne.booker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleRestController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;

    // Create
    @PostMapping
    public ResponseEntity<RoleDtoWithID> createRole(@Valid @RequestBody RoleDto roleDto) {
        try {
            RoleDtoWithID createdRole = roleService.createRole(roleDto);
            return new ResponseEntity<>(createdRole, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException ex) {
            // Handle unique constraint violations for role name
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } catch (Exception ex) {
            // Handle any other exceptions that might occur
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Read
    @GetMapping("/{id}")
    public ResponseEntity<RoleDto> getRole(@PathVariable Long id) {
        try {
            RoleDto roleDto = roleService.findByIdToDto(id);
            return new ResponseEntity<>(roleDto, HttpStatus.OK);
        } catch (RoleNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Read all
    @GetMapping
    public ResponseEntity<List<RoleDtoWithID>> getAllRoles() {
        try {
            List<RoleDtoWithID> roles = roleService.findAll();
            return new ResponseEntity<>(roles, HttpStatus.OK);
        } catch (Exception ex) {
            // Handle any other exceptions that might occur
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<RoleDto> updateRole(@PathVariable Long id, @Valid @RequestBody RoleDto roleDto) {
        try {
            RoleDto updatedRole = roleService.updateRole(id, roleDto);
            return new ResponseEntity<>(updatedRole, HttpStatus.OK);
        } catch (RoleNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            // Handle any other exceptions that might occur
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
        try {
            roleService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RoleNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            // Handle any other exceptions that might occur
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/assign-role")
    public ResponseEntity<Void> assignRoleToUsers(@RequestParam Long roleId, @RequestBody List<Long> userIds) {
        try {
            userService.assignRoleToUsers(roleId, userIds);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RoleNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            // Handle any other exceptions that might occur
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}