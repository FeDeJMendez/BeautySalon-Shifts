package com.CodingDesign.BeautySalonShifts.controller.advice;

import com.CodingDesign.BeautySalonShifts.exceptions.ClientExistsException;
import com.CodingDesign.BeautySalonShifts.exceptions.ClientNotExistsException;
import com.CodingDesign.BeautySalonShifts.exceptions.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ClientControllerAdvice {

    @ExceptionHandler(value = {ClientExistsException.class})
    public ResponseEntity<ErrorMessage> clientExists () {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(ErrorMessage.builder()
                        .code("CEE")
                        .message("Client Already Exists!")
                        .build());
    }

    @ExceptionHandler(value = {ClientNotExistsException.class})
    public ResponseEntity<ErrorMessage> clientNotExists () {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ErrorMessage
                        .builder()
                        .code("CNE")
                        .message("Client Not Exists!")
                        .build());
    }
}
