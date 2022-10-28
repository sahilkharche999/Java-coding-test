package com.example.test.handler;

import com.example.test.model.ErrorResponse;
import com.example.test.model.ErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class ExceptionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionController.class);

    private void logErrorMessage(ErrorResponse message) {
        LOGGER.error("Error Response : {}", message);
    }

    private void logUrlAndError(HttpServletRequest req, String message) {
        LOGGER.error("Request {} {} raised {}", req.getMethod(), req.getRequestURI(), message);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(HttpServletRequest req, Exception ex) {
        logUrlAndError(req, ex.getMessage());
        ErrorResponse response = new ErrorResponse(ErrorType.SYSTEM_ERROR, ex.getMessage());
        logErrorMessage(response);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

}
