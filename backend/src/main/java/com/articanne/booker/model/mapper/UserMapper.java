package com.articanne.booker.model.mapper;

import com.articanne.booker.model.Role;
import com.articanne.booker.model.User;
import com.articanne.booker.model.dto.UserDto;
import com.articanne.booker.model.dto.UserDtoWithID;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static UserDto toUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword()); // Do not return the password if it's not necessary
        userDto.setRoles(user.getRoles().stream().map(Role::getName).collect(Collectors.toSet()));
        return userDto;
    }

    public static UserDtoWithID toUserDtoWithId(User user) {
        UserDtoWithID userDtoWithId = new UserDtoWithID();
        userDtoWithId.setId(user.getId());
        userDtoWithId.setUsername(user.getUsername());
        userDtoWithId.setPassword(user.getPassword()); // Do not return the password if it's not necessary
        userDtoWithId.setRoles(user.getRoles().stream().map(Role::getName).collect(Collectors.toSet()));
        return userDtoWithId;
    }

    public static User toUser(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword()); // Make sure to hash the password before saving it
        user.setRoles(userDto.getRoles().stream().map(roleName -> {
            Role role = new Role();
            role.setName(roleName);
            return role;
        }).collect(Collectors.toSet()));
        return user;
    }

    public static List<UserDto> toUserDtoList(List<User> users) {
        return users.stream()
                .map(UserMapper::toUserDto)
                .collect(Collectors.toList());
    }

    public static List<UserDtoWithID> toUserDtoWithIdList(List<User> users) {
        return users.stream()
                .map(UserMapper::toUserDtoWithId)
                .collect(Collectors.toList());
    }

    public static List<User> toUserList(List<UserDto> userDtos) {
        return userDtos.stream()
                .map(UserMapper::toUser)
                .collect(Collectors.toList());
    }
}

