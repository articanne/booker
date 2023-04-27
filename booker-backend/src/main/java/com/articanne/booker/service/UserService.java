package com.articanne.booker.service;

import com.articanne.booker.model.Role;
import com.articanne.booker.model.User;
import com.articanne.booker.model.dto.RoleDto;
import com.articanne.booker.model.dto.UserDto;
import com.articanne.booker.model.dto.UserDtoWithID;
import com.articanne.booker.model.exception.RoleNotFoundException;
import com.articanne.booker.model.exception.UserNotFoundException;
import com.articanne.booker.model.mapper.RoleMapper;
import com.articanne.booker.model.mapper.UserMapper;
import com.articanne.booker.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleService roleService;

    public void addRoleToUser(Role role, User user) {
        user.getRoles().add(role);
        userRepository.save(user);
    }

    public Page<UserDtoWithID> findAll(Pageable pageable) {
        Page<User> all = userRepository.findAllByOrderByIdAsc(pageable);
        return all.map(UserMapper::toUserDtoWithId);
    }

    public Page<UserDtoWithID> findAll(String search, Pageable pageable) {
        Page<User> all;
        if (search == null || search.trim().isEmpty()) {
            all = userRepository.findAllByOrderByIdAsc(pageable);
        } else {
            all = userRepository.findByUsernameContainingIgnoreCase(search.trim(), pageable);
        }
        return all.map(UserMapper::toUserDtoWithId);
    }

    public UserDto findById(Long id) throws UserNotFoundException {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
        return UserMapper.toUserDto(user);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void deleteById(Long id) throws UserNotFoundException {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new UserNotFoundException("User not found with id: " + id);
        }
    }

    public UserDto findByUsername(String username) throws UserNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException("User not found with username: " + username));
        return UserMapper.toUserDto(user);
    }

    public UserDtoWithID createUser(UserDto userCreateDto) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        User user = UserMapper.toUser(userCreateDto);
        user.setPassword(passwordEncoder.encode(userCreateDto.getPassword())); // Hash the password

        Set<Role> roles = userCreateDto.getRoles().stream()
                .map(roleName -> roleService.findByName(roleName)
                        .orElseThrow(() -> new RuntimeException("Role not found: " + roleName)))
                .collect(Collectors.toSet());
        user.setRoles(roles);

        User savedUser = save(user);
        return UserMapper.toUserDtoWithId(savedUser);
    }

    public UserDto updateUser(Long id, UserDto userUpdateDto) throws UserNotFoundException {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));

        user.setUsername(userUpdateDto.getUsername());
        user.setPassword(userUpdateDto.getPassword()); // You should encrypt the password before saving

        Set<Role> roles = userUpdateDto.getRoles().stream()
                .map(roleName -> roleService.findByName(roleName)
                        .orElseThrow(() -> new RuntimeException("Role not found: " + roleName)))
                .collect(Collectors.toSet());
        user.setRoles(roles);

        User updatedUser = save(user);
        return UserMapper.toUserDto(updatedUser);
    }

    public Set<Role> getUserRolesByUsername(String username) throws UserNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException("User not found with username: " + username));
        return user.getRoles();
    }

    public void assignRoleToUsers(Long roleId, List<Long> userIds) throws RoleNotFoundException, UserNotFoundException {
        RoleDto roleDto = roleService.findByIdToDto(roleId);
        Role role = RoleMapper.toRole(roleDto);
        for (Long userId : userIds) {
            User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found with id: " + userId));
            user.getRoles().add(role);
            userRepository.save(user);
        }
    }

    public void assignRolesToUser(Long userId, List<Long> roleIds) throws UserNotFoundException, RoleNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found with id: " + userId));

        for (Long roleId : roleIds) {
            user.getRoles().add(roleService.findById(roleId));
        }
        userRepository.save(user);
    }

}







