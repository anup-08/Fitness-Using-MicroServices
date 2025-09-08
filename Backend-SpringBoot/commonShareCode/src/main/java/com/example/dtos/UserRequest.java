package com.example.dtos;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UserRequest {
    @NotBlank(message = "First name is mandatory")
    @Size(min = 2, max = 20, message = "First name must be between 2 and 20 characters")
    private String firstName;
    private String lastName;

    @NotBlank(message = "Email is mandatory")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@gmail\\.com$",
            message = "Email must be a valid Gmail address (e.g., example@gmail.com)")
    private String email;

    @NotBlank(message = "Password is mandatory")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).*$",
            message = "Password should be alpha numeric")
    private String password;

    @NotNull(message = "Age is mandatory")
    private Integer age;

    @NotBlank(message = "Gender is mandatory")
    private String gender;

    private String role;

}
