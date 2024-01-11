package com.example.restaurant.model.dto.response;

import com.example.restaurant.model.dto.request.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BronResponse {
    private Integer stolNumber;
    private Integer chairCount;
    private UserResponse  user;
}
