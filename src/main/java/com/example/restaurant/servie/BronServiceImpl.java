package com.example.restaurant.servie;

import com.example.restaurant.model.BronEntity;
import com.example.restaurant.model.dto.request.UserDto;
import com.example.restaurant.model.dto.response.BronResponse;
import com.example.restaurant.model.dto.response.StolResponse;
import com.example.restaurant.model.dto.response.UserResponse;
import com.example.restaurant.model.exceptions.DataNotFoundException;
import com.example.restaurant.repository.BronRepository;
import com.example.restaurant.repository.StolRepository;
import com.example.restaurant.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BronServiceImpl implements BronService{
    private final BronRepository bronRepository;
    private final ModelMapper modelMapper;
    private final StolRepository stolRepository;
    private final UserRepository userRepository;
    @Override
    public BronResponse bron(UUID userId, UUID stolId) {
       bronRepository.save(new BronEntity(stolRepository.findById(stolId).get(),
                userId, LocalDateTime.now()));
        return new BronResponse(stolRepository.findById(stolId).get().getNumber(),
                stolRepository.findById(stolId).get().getChairCount(),
                new UserResponse(userRepository.findById(userId).get().getName(),
                        userRepository.findById(userId).get().getPhoneNumber()));

    }

    public ResponseEntity<List<StolResponse>> getByUserId(UUID userId){
        List<BronEntity> allByUserId = bronRepository.findAllByUserId(userId);
        return ResponseEntity.ok(modelMapper.map(allByUserId, new TypeToken<List<StolResponse>>() {}.getType()));
    }
    @Override
    public void cancelBron(UUID userId, UUID stolId) {
        BronEntity bronEntity = bronRepository.findByUserIdAndStolId(userId, stolId)
                .orElseThrow(() -> new DataNotFoundException("Bron not found for user and stol"));
        bronRepository.delete(bronEntity);
    }
}
