package com.msf.movement_middleend.controller;


import com.msf.movement_middleend.domain.Movement;
import com.msf.movement_middleend.service.IMovementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.util.CollectionUtils;
import java.util.List;

@RestController
@RequestMapping("api/v1/movements")
@RequiredArgsConstructor
public class MovementController {

    private final IMovementService iMovementService;

    @PostMapping()
    @CrossOrigin
    public ResponseEntity<Movement> createMovement(@RequestBody Movement movement) {
        return new ResponseEntity<>(iMovementService.createMovement(movement), HttpStatus.CREATED);

    }

    @GetMapping("/{accountId}")
    @CrossOrigin
    public ResponseEntity<List<Movement>> getMovements(@PathVariable Integer accountId){
        List<Movement> movementList = iMovementService.getMovements(accountId);
        if(CollectionUtils.isEmpty(movementList)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(movementList, HttpStatus.OK);
    }
}
