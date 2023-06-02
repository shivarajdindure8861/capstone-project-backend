package com.ani.project.dto;

import java.util.Optional;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserDTO {

    private long id;
    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotNull(message = "Email is mandatory")
    @Email(message = "Invalid email address")
    private String email;

    @NotNull(message = "Password is mandatory")
    @Size(min = 8, max = 16, message = "Password must be between 8 and 16 characters")
    private String password;


}