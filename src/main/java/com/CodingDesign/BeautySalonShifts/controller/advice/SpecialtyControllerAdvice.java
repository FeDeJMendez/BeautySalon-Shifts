package com.CodingDesign.BeautySalonShifts.controller.advice;

import com.CodingDesign.BeautySalonShifts.exceptions.ErrorMessage;
import com.CodingDesign.BeautySalonShifts.exceptions.SpecialtyNotExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SpecialtyControllerAdvice {

    @ExceptionHandler(value = {SpecialtyNotExistsException.class})
    public ResponseEntity<ErrorMessage> specialtyNotExists () {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ErrorMessage
                        .builder()
                        .code("SNE")
                        .message("Specialty Not Exists")
                        .build());
    }
}
