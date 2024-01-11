package com.example.restaurant.model;

import com.example.restaurant.model.enums.StolStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class StolEntity extends BaseEntity {
    private Integer number;
    private Integer chairCount;
    @Enumerated(EnumType.STRING)
    private StolStatus status;

}
