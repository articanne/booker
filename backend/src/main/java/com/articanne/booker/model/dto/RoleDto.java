package com.articanne.booker.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto {

    @NotBlank(message = "Role name cannot be blank")
    private String name;
}
