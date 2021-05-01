package com.zerotospring.zerotospring.Handlers;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.zerotospring.zerotospring.Exceptions.BadRequestException;
import com.zerotospring.zerotospring.Exceptions.BadRequestExceptionDetails;
import com.zerotospring.zerotospring.Exceptions.ValidationExceptionDetails;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
  @ExceptionHandler(BadRequestException.class)
  public ResponseEntity<BadRequestExceptionDetails> handlerBadRequestException(BadRequestException exception) {
    return new ResponseEntity<>(
      BadRequestExceptionDetails.builder()
        .devMessage(exception.getMessage())
        .build(),
        HttpStatus.BAD_REQUEST
    );
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ValidationExceptionDetails> handlerValidationExceptionDetails(MethodArgumentNotValidException exception) {
    List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
    String fields = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(", "));
    String errorMessages = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(", "));

    return new ResponseEntity<>(
      ValidationExceptionDetails.builder()
        .devMessage(fields + errorMessages)
        .build(),
        HttpStatus.BAD_REQUEST
    );
  }
}
