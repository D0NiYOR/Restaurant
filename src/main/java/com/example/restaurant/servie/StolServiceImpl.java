package com.example.restaurant.servie;

import com.example.restaurant.model.StolEntity;
import com.example.restaurant.model.dto.request.StolCr;
import com.example.restaurant.model.dto.request.StolUpdate;
import com.example.restaurant.model.dto.response.StolResponse;
import com.example.restaurant.model.enums.StolStatus;
import com.example.restaurant.model.exceptions.DataNotFoundException;
import com.example.restaurant.model.exceptions.DuplicateValueException;
import com.example.restaurant.repository.StolRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StolServiceImpl implements StolService{
private final StolRepository stolRepository;
    private final ModelMapper modelMapper;

    public StolResponse createStol(StolCr stolCr){
        StolEntity stolEntity = modelMapper.map(stolCr, StolEntity.class);
        List<StolEntity> stols = stolRepository.findByNumber(stolCr.getNumber());
        for (StolEntity entity : stols) {
            if(!Objects.equals(null,entity) &&
                    Objects.equals(entity.getNumber(),stolEntity.getNumber())
            ){
                throw new DuplicateValueException("Stol already exist by this number!");
            }
        }
        stolEntity.setStatus(StolStatus.EMPTY);
        return modelMapper.map(stolRepository.save(stolEntity), StolResponse.class);
    }

    public void deleteStol(UUID stolId) {
        stolRepository.findById(stolId)
                .orElseThrow(() -> new DataNotFoundException("Stol not found with ID: " + stolId));
        stolRepository.deleteById(stolId);

    }
    public StolResponse updateById(UUID stolId, StolUpdate update) {
        StolEntity stol = stolRepository
                .findById(stolId)
                .orElseThrow( () -> new DataNotFoundException("stol not found"));
        stol.setChairCount(update.getChairCount());
        stolRepository.save(stol);
        return new StolResponse(stolRepository.findById(stolId).get().getNumber(),
                update.getChairCount(),stolId);
    }

    @Override
    public List<StolResponse> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return modelMapper.map(stolRepository.findAll(pageable).getContent(),
                new TypeToken<List<StolResponse>>() {}.getType());
    }
}
