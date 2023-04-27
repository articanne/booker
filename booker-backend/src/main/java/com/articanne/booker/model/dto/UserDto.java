package com.articanne.booker.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
public class UserDto {

    @NotBlank(message = "Username cannot be blank")
    private String username;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 8, max = 100, message = "Password must be between {min} and {max} characters")
    private String password;

    @Size(min = 1, message = "There must be at least one role")
    private Set<@NotBlank(message = "Role name cannot be blank") String> roles;
}
