package com.msf.movement_middleend.service.impl;

import com.msf.movement_middleend.client.MovementServiceClient;
import com.msf.movement_middleend.domain.Movement;
import com.msf.movement_middleend.service.IMovementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovementServiceImpl implements IMovementService {
    private final MovementServiceClient movementServiceClient;

    @Override
    public Movement createMovement(Movement movement) {

        return movementServiceClient
                .createMovement("wer","wer",movement).getBody();
    }

    @Override
    public List<Movement> getMovements(Integer accountId){
        return movementServiceClient.getMovements("aws", "aws", accountId).getBody();
    }


}
