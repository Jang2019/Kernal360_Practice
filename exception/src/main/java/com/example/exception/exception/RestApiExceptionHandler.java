package com.example.exception.exception;

import com.example.exception.controller.RestApiBController;
import com.example.exception.controller.RestApiController;
import com.example.exception.model.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@Slf4j
@RestControllerAdvice( basePackageClasses = {RestApiController.class,RestApiBController.class}/*basePackages = "com.example.exception.controller"*/) //컨트롤에서 나오는 모든 예외 잡기 패키지 지정
@Order(1)
public class RestApiExceptionHandler {



    @ExceptionHandler(value = {IndexOutOfBoundsException.class}) //예외 지정 잡기
    public ResponseEntity outOfBound(IndexOutOfBoundsException e){
        log.error("RestApiExceptionHandler",e);

        return ResponseEntity.status(200).build();
    }

    @ExceptionHandler(value = {NoSuchFieldError.class})
    public ResponseEntity<Api> noSuchelement(
            NoSuchFieldError e
    ){
        log.error("",e);

        var response =  Api.builder()
                .resultCode(String.valueOf(HttpStatus.NOT_FOUND.value()))
                .resultMessage(HttpStatus.NOT_FOUND.getReasonPhrase())
                .build();

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }
}
