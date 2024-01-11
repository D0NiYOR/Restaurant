package com.example.restaurant.servie;

import com.example.restaurant.model.dto.request.AuthDto;
import com.example.restaurant.model.dto.request.UserDto;
import com.example.restaurant.model.dto.response.JwtResponse;
import com.example.restaurant.model.exceptions.UserRegistrationException;

public interface UserService {
     void signUp(UserDto userDto) throws UserRegistrationException;
     JwtResponse signIn(AuthDto dto);
}
