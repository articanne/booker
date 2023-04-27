package com.articanne.booker.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDtoWithID {

    @NotNull(message = "User ID cannot be null")
    private Long id;

    @NotBlank(message = "Role name cannot be blank")
    private String name;
}
