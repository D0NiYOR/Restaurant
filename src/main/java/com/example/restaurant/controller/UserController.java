package com.example.restaurant.controller;

import com.example.restaurant.model.dto.request.AuthDto;
import com.example.restaurant.model.dto.request.UserDto;
import com.example.restaurant.model.dto.response.BronResponse;
import com.example.restaurant.model.dto.response.JwtResponse;
import com.example.restaurant.model.dto.response.StolResponse;
import com.example.restaurant.servie.BronService;
import com.example.restaurant.servie.UserService;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {
    private final UserService userService;
    private final BronService bronService;

    @PermitAll
    @PostMapping("/sign-in")
    public JwtResponse signIn(@Valid @RequestBody AuthDto dto) {
        return userService.signIn(dto);
    }
    @PermitAll
    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@Valid @RequestBody UserDto userDto) {
            userService.signUp(userDto);
            return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }


    @PreAuthorize(" hasRole('USER') ")
    @PostMapping("/bron/{stolId}")
    public ResponseEntity<BronResponse> bron(Principal principal, @PathVariable UUID stolId){
        return ResponseEntity.ok(bronService.bron(UUID.fromString(principal.getName()), stolId));
    }

    @PreAuthorize("hasRole('USER')")
    @DeleteMapping("/cancel-bron/{stolId}")
    public ResponseEntity<String> cancelBron(Principal principal, @PathVariable UUID stolId) {
        bronService.cancelBron(UUID.fromString(principal.getName()), stolId);
        return ResponseEntity.ok("Bron canceled successfully");
    }


    @PreAuthorize(" hasRole('USER') ")
    @GetMapping("/my-brons")
    public ResponseEntity<List<StolResponse>> myBrons(Principal principal){
        return bronService.getByUserId(UUID.fromString(principal.getName()));
    }

    }


