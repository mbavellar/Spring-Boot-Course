package com.mbavellar.course.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mbavellar.course.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
  
  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {

    HttpStatus status = HttpStatus.NOT_FOUND;
    return getExceptionData(e.getMessage(), request.getRequestURI(), status, "Resource NOT Found!");
  }
  
  @ExceptionHandler(DatabaseException.class)
  public ResponseEntity<StandardError> databaseError(DatabaseException e, HttpServletRequest request) {

    HttpStatus status = HttpStatus.BAD_REQUEST;
    return getExceptionData(e.getMessage(), request.getRequestURI(), status, "Database Error");
  }
  
  private static ResponseEntity<StandardError> getExceptionData(String errorMsg, String uri, HttpStatus status, String error) {
    StandardError err = new StandardError(Instant.now(), status.value(), error, errorMsg, uri);
    return ResponseEntity.status(status).body(err);
  }
}