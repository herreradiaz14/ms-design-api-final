package com.msf.movement_middleend.exceptions;

import feign.FeignException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler({FeignException.BadRequest.class})
    public ResponseEntity<String> feignExceptionBadRequest(FeignException.BadRequest e) {
        return ResponseEntity.badRequest().body("Error en la petición código 400: " + e.getMessage());
    }

    @ExceptionHandler({FeignException.BadGateway.class})
    public ResponseEntity<String> badGatewayBadRequest(FeignException.BadGateway e) {
        return ResponseEntity.status(502).body("Error en la petición código 502: " + e.getMessage());
    }

    @ExceptionHandler({FeignException.Forbidden.class})
    public ResponseEntity<String> forbiddenRequest(FeignException.Forbidden e) {
        return ResponseEntity.status(403).body("Error en la petición código 403: " + e.getMessage());
    }

    @ExceptionHandler({FeignException.NotFound.class})
    public ResponseEntity<String> notFoundRequest(FeignException.NotFound e) {
        return ResponseEntity.status(404).body("Error en la petición código 404: " + e.getMessage());
    }

    @ExceptionHandler({FeignException.NotAcceptable.class})
    public ResponseEntity<String> notAcceptableRequest(FeignException.NotAcceptable e) {
        return ResponseEntity.status(406).body("Error en la petición código 404: " + e.getMessage());
    }

    @ExceptionHandler({
            Exception.class
    })
    public ResponseEntity<String> exceptionNotControled(Exception e){
        return ResponseEntity.badRequest().body("Error en la petición " + e.getMessage());
    }
}
