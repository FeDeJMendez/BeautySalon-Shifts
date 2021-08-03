package com.CodingDesign.BeautySalonShifts.controller.advice;

import com.CodingDesign.BeautySalonShifts.exceptions.ErrorMessage;
import com.CodingDesign.BeautySalonShifts.exceptions.ShiftNotExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ShiftControllerAdvice {

    @ExceptionHandler(value = {ShiftNotExistsException.class})
    public ResponseEntity<ErrorMessage> shiftNotExists () {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ErrorMessage
                        .builder()
                        .code("SHNE")
                        .message("Shift Not Exists!")
                        .build());
    }
}
