package com.example.restaurant.model;

import com.example.restaurant.model.dto.request.OrderCr;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderPaperEntity extends BaseEntity{
    private List<OrderEntity> orders;
    private UUID stolId;
    @Builder.Default
    private Boolean isFinished=false;
}
