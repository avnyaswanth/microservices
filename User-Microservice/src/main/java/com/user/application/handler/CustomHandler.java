package com.user.application.handler;

import com.user.application.dto.Payload;
import com.user.application.exception.InvalidHeaderException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;


@ControllerAdvice
public class CustomHandler {
    @ExceptionHandler(value = InvalidHeaderException.class)
    public ResponseEntity<Payload> handleInvalidHeaderException(InvalidHeaderException ex) {
        Payload payload = Payload.builder()
                .message(ex.getMessage())
                .status(HttpStatus.BAD_REQUEST)
                .date(new Date())
                .build();
        return new ResponseEntity<>(payload, HttpStatus.BAD_REQUEST);
    }
}
