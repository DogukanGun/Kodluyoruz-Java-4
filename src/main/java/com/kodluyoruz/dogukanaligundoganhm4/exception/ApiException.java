package com.kodluyoruz.dogukanaligundoganhm4.exception;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;


@Data
@Builder
public class ApiException extends RuntimeException{

    private HttpStatus httpStatus;
    public ApiException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus=httpStatus;
    }
}