package com.example.restaurant.servie;

import com.example.restaurant.config.jwt.JwtService;
import com.example.restaurant.model.UserEntity;
import com.example.restaurant.model.dto.request.AuthDto;
import com.example.restaurant.model.dto.request.UserDto;
import com.example.restaurant.model.dto.response.JwtResponse;
import com.example.restaurant.model.exceptions.DataNotFoundException;
import com.example.restaurant.model.exceptions.UserRegistrationException;
import com.example.restaurant.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    public JwtResponse signIn(AuthDto dto) {
        UserEntity user = userRepository.findByPhoneNumber(dto.getPhoneNumber()).orElseThrow(() -> new DataNotFoundException("user not found"));
        if (dto.getPassword().equals(user.getPassword())) {
            return new JwtResponse(jwtService.generateToken(user));
        }
        throw new AuthenticationCredentialsNotFoundException("password didn't match");
    }

    public void signUp(UserDto userDto) throws UserRegistrationException {
        // Check if the username is already taken
        if (userRepository.existsByPhoneNumber(userDto.getPhoneNumber())) {
            throw new UserRegistrationException("Phone number is already taken");
        }
        // Create a new User entity
        UserEntity newUser = new UserEntity();
        newUser.setPhoneNumber(userDto.getPhoneNumber());

        // Hash the password before saving it
        newUser.setPassword(passwordEncoder.encode(userDto.getPassword()));

        // You might set other properties here based on your User entity

        // Save the user to the database
        userRepository.save(newUser);
    }
}
