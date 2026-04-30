package com.industria.telemetrycollector.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "telemetry_hustory")
@Getter
@Setter
@NoArgsConstructor
public class TelemetryEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "machine_id", nullable = false)
    private String machineId;

    @Column(name = "temperature")
    private Double temperature;

    @Column(name = "power_consumption")
    private Double powerConsumption;

    @Column(name = "vibration")
    private Double vibration;

    @Column(name = "collected_at")
    private LocalDateTime collectedAt;

    // Construtor auxiliar para facilitar a criação de Service
    public TelemetryEntity(String machineId, Double temperature, Double powerConsumption, Double vibration) {
        this.machineId = machineId;
        this.temperature = temperature;
        this.powerConsumption = powerConsumption;
        this.vibration = vibration;
        this.collectedAt = LocalDateTime.now();
    }
}
