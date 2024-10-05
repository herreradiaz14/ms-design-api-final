package com.ms.movement.service.infrastructure.adapters.out.repositories;

import com.ms.movement.service.domain.models.Movement;
import com.ms.movement.service.infrastructure.adapters.out.entities.MovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementRepository extends JpaRepository<MovementEntity, Integer> {
}
