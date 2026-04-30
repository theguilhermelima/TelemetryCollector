package com.industria.telemetrycollector.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.industria.telemetrycollector.model.TelemetryEntity;

public interface TelemetryRepository extends JpaRepository<TelemetryEntity, Long>{
    
    // Buscar histórico por ID de uma máquina específica
    List<TelemetryEntity> findByMachineIdOrderByCollectedAtDesc(String machineId);
}
