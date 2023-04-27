package com.articanne.booker.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoWithID {

    @NotNull(message = "User ID cannot be null")
    private Long id;

    @NotBlank(message = "Username cannot be blank")
    private String username;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 8, max = 100, message = "Password must be between {min} and {max} characters")
    private String password;

    @Size(min = 1, message = "There must be at least one role")
    private Set<@NotBlank(message = "Role name cannot be blank") String> roles;
}
