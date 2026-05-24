package com.project.fitness.dto;

import com.project.fitness.model.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.relation.Role;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    @NotBlank(message = "Email is Required")
    @Email(message = "Invalid email")
    private  String email;
    @NotBlank(message = "Password  is Required")
    private  String password;
    private  String firstName;
    private  String lastName;
    private UserRole role;
}
