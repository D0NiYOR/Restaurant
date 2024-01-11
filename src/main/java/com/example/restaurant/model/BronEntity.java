package com.example.restaurant.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BronEntity extends BaseEntity{
    @ManyToOne(cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
    private StolEntity stol;
    private UUID userId;
    private LocalDateTime bronTime;

}
