package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "device_ownership")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeviceOwnershipRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String serialNumber;

    private String ownerName;

    private LocalDate purchaseDate;

    @PrePersist
    void created() {
        if (purchaseDate == null) {
            purchaseDate = LocalDate.now();
        }
    }
}
