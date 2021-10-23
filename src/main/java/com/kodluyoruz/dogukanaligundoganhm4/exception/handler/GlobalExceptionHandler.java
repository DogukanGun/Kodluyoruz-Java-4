package com.kodluyoruz.dogukanaligundoganhm4.exception.handler;

import com.kodluyoruz.dogukanaligundoganhm4.exception.ApiException;
import com.kodluyoruz.dogukanaligundoganhm4.model.response.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {


    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorResponse> handleErrorResponse(ApiException exception){
        ErrorResponse errorResponse = ErrorResponse.builder()
                .responseType(exception.getClass().getSimpleName())
                .errorMessage(exception.getMessage())
                .build();
        return ResponseEntity.status(exception.getHttpStatus()).body(errorResponse);
    }
}
