package com.CodingDesign.BeautySalonShifts.controller.advice;

import com.CodingDesign.BeautySalonShifts.exceptions.EmployeeExistsException;
import com.CodingDesign.BeautySalonShifts.exceptions.EmployeeNotExistsException;
import com.CodingDesign.BeautySalonShifts.exceptions.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeControllerAdvice {

    @ExceptionHandler(value = {EmployeeExistsException.class})
    public ResponseEntity<ErrorMessage> employeeExists () {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(ErrorMessage
                        .builder()
                        .code("EAR")
                        .message("Employee Already Exists!")
                        .build());
    }

    @ExceptionHandler(value = {EmployeeNotExistsException.class})
    public ResponseEntity<ErrorMessage> employeeNotExists () {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ErrorMessage
                        .builder()
                        .code("ENE")
                        .message("Employee Not Exists!")
                        .build());
    }
}

