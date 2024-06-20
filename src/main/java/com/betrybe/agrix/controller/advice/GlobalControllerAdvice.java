package com.betrybe.agrix.controller.advice;

import com.betrybe.agrix.service.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Advice to global exception.
 */
@ControllerAdvice
public class GlobalControllerAdvice {

  /**
   * Execption Response by Not Found.
   */
  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<String> handleNotFound(NotFoundException e) {
    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(
          e.getMessage()
    );
  }
}
