package com.msf.movement_middleend.client;


import com.msf.movement_middleend.domain.Movement;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name="movement-service")
public interface MovementServiceClient {

    @PostMapping("api/v1/movements")
    ResponseEntity<Movement> createMovement(@RequestHeader(value = "x-cm-client-request-id", required = true) String xCmClientRequestId,
                                            @RequestHeader(value = "x-cm-client-user-agent", required = true) String xCmClientUserAgent,
                                            @RequestBody Movement movement);

    @GetMapping("api/v1/movements/{accountId}")
    ResponseEntity<List<Movement>> getMovements(@RequestHeader(value = "x-sw-client-request-id", required = true) String xCmClientRequestId,
                                              @RequestHeader(value = "x-sw-client-user-agent", required = true) String xCmClientUserAgent,
                                              @RequestHeader(value = "accountId", required = true) Integer accountId);
}
