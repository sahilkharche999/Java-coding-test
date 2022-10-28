package com.example.test.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.slf4j.MDC;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "IST")
    private LocalDateTime timestamp;
    private ErrorType errorType;
    private String errorMessage;

    public ErrorResponse(){
        this.timestamp = LocalDateTime.now();
    }

    public ErrorResponse(ErrorType errorType, String errorMessage) {
        this.timestamp = LocalDateTime.now();
        this.errorType = errorType;
        this.errorMessage = errorMessage;
    }
}
