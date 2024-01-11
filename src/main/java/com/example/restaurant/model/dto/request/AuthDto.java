package com.example.restaurant.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthDto {
    @NotBlank(message = "phone number must not be blank")
    private String phoneNumber;
    @NotBlank(message = "password must not be blank")
    private String password;
}

