package com.example.coffeeshop.controllers.exception;

import com.example.coffeeshop.exceptions.ConflictingDataException;
import com.example.coffeeshop.exceptions.ExceptionResponse;
import com.example.coffeeshop.exceptions.InvalidDataException;
import com.example.coffeeshop.exceptions.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class ControllerAdvisor {

    @ResponseBody
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ExceptionResponse notFound(Exception ex) {
        log.warn(ex.getMessage(), ex.getCause());
        return ExceptionResponse.builder().message(ex.getMessage()).build();
    }

    @ResponseBody
    @ExceptionHandler(ConflictingDataException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    ExceptionResponse conflictResource(Exception ex) {
        log.warn(ex.getMessage(), ex.getCause());
        return ExceptionResponse.builder().message(ex.getMessage()).build();
    }

    @ResponseBody
    @ExceptionHandler(InvalidDataException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ExceptionResponse invalidInput(Exception ex) {
        log.warn(ex.getMessage(), ex.getCause());
        return ExceptionResponse.builder().message(ex.getMessage()).build();
    }
}
