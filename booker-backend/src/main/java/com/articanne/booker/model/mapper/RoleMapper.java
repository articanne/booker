package com.articanne.booker.model.mapper;

import com.articanne.booker.model.Role;
import com.articanne.booker.model.dto.RoleDto;
import com.articanne.booker.model.dto.RoleDtoWithID;

import java.util.List;
import java.util.stream.Collectors;

public class RoleMapper {

    public static List<RoleDto> toRoleDtoList(List<Role> roles) {
        return roles.stream()
                .map(RoleMapper::toRoleDto)
                .collect(Collectors.toList());
    }

    public static List<RoleDtoWithID> toRoleDtoWithIdList(List<Role> roles) {
        return roles.stream()
                .map(RoleMapper::toRoleDtoWithId)
                .collect(Collectors.toList());
    }

    public static RoleDto toRoleDto(Role role) {
        return new RoleDto(role.getName());
    }

    public static RoleDtoWithID toRoleDtoWithId(Role role) {
        return new RoleDtoWithID(role.getId(), role.getName());
    }

    public static Role toRole(RoleDto roleDto) {
        Role role = new Role();
        role.setName(roleDto.getName());
        return role;
    }

}
