package dev.ferv.courier_service.application.exeptionHandler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import dev.ferv.courier_service.application.dto.response.ValidationResponse;
import dev.ferv.courier_service.domain.exeptions.CodeNotValidExeption;
import dev.ferv.courier_service.domain.exeptions.ExpiredCodeExeption;

@ControllerAdvice
public class ControllerAdvise {

    @ExceptionHandler(CodeNotValidExeption.class)
    public ResponseEntity<ValidationResponse> handleCodeNotValidExeption(CodeNotValidExeption exeption){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(new ValidationResponse(false, ErrorResponse.CODE_NOT_VALID.getMessage(), ErrorResponse.CODE_NOT_VALID.name()));
    }
    @ExceptionHandler(ExpiredCodeExeption.class)
    public ResponseEntity<ValidationResponse> handleExpiredCodeExeption(ExpiredCodeExeption exeption){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(new ValidationResponse(false, ErrorResponse.EXPIRED_CODE.getMessage(), ErrorResponse.EXPIRED_CODE.name()));
    }

}
