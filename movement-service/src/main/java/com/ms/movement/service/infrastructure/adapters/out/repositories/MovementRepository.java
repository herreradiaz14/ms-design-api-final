package com.ms.movement.service.infrastructure.adapters.out.repositories;

import com.ms.movement.service.domain.models.Movement;
import com.ms.movement.service.infrastructure.adapters.out.entities.MovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovementRepository extends JpaRepository<MovementEntity, Integer> {

    @Query("SELECT u FROM MovementEntity u WHERE u.accountId = :accountId")
    List<MovementEntity> movementByAccountId(@Param("accountId") Integer idCustomer);
}
