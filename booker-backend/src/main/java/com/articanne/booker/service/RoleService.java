package com.articanne.booker.service;

import com.articanne.booker.model.Role;
import com.articanne.booker.model.dto.RoleDto;
import com.articanne.booker.model.dto.RoleDtoWithID;
import com.articanne.booker.model.exception.RoleNotFoundException;
import com.articanne.booker.model.mapper.RoleMapper;
import com.articanne.booker.repository.RoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<RoleDtoWithID> findAll() {
        try {
            List<Role> all = roleRepository.findAllByOrderByIdAsc();
            return RoleMapper.toRoleDtoWithIdList(all);
        } catch (Exception ex) {
            // Handle any other exceptions that might occur
            throw new RuntimeException("An unexpected error occurred while finding all roles", ex);
        }
    }


    public RoleDto findByIdToDto(Long id) {
        try {
            Optional<Role> role = roleRepository.findById(id);
            if (role.isPresent()) {
                return RoleMapper.toRoleDto(role.get());
            } else {
                throw new RoleNotFoundException("Role not found with id: " + id);
            }
        } catch (NoSuchElementException ex) {
            // Handle NoSuchElementException, which can be thrown by role.get()
            throw new RoleNotFoundException("Role not found with id: " + id, ex);
        } catch (Exception ex) {
            // Handle any other exceptions that might occur
            throw new RuntimeException("An unexpected error occurred while finding role by id: " + id, ex);
        }
    }

    public Role findById(Long id) {
        try {
            Optional<Role> role = roleRepository.findById(id);
            if (role.isPresent()) {
                return role.get();
            } else {
                throw new RoleNotFoundException("Role not found with id: " + id);
            }
        } catch (NoSuchElementException ex) {
            // Handle NoSuchElementException, which can be thrown by role.get()
            throw new RoleNotFoundException("Role not found with id: " + id, ex);
        } catch (Exception ex) {
            // Handle any other exceptions that might occur
            throw new RuntimeException("An unexpected error occurred while finding role by id: " + id, ex);
        }
    }

    public Role save(Role role) {
        return roleRepository.save(role);
    }

    public void deleteById(Long id) {
        try {
            Optional<Role> roleOptional = roleRepository.findById(id);
            if (roleOptional.isPresent()) {
                roleRepository.deleteById(id);
            } else {
                throw new RoleNotFoundException("Role not found with id: " + id);
            }
        } catch (Exception ex) {
            // Handle any other exceptions that might occur
            throw new RuntimeException("An unexpected error occurred while deleting role by id: " + id, ex);
        }
    }

    public Optional<Role> findByName(String name) {
        return roleRepository.findByName(name);
    }

    public RoleDtoWithID createRole(RoleDto roleCreateDto) {
        Role role = new Role();
        role.setName(roleCreateDto.getName());
        Role rolSaved = save(role);
        return RoleMapper.toRoleDtoWithId(rolSaved);
    }

    public RoleDto updateRole(Long id, RoleDto roleUpdateDto) {
        Optional<Role> roleOptional = roleRepository.findById(id);
        if (roleOptional.isPresent()) {
            Role role = roleOptional.get();
            role.setName(roleUpdateDto.getName());
            Role rolSaved = save(role);
            return RoleMapper.toRoleDto(rolSaved);
        } else {
            throw new RoleNotFoundException("Role not found with id: " + id);
        }
    }


}
