package br.com.barroso.strategyFlyweight.demo.strategy.flyweight.demo.handler

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException

@RestControllerAdvice
class GlobalControllerExceptionHandler {

    @ExceptionHandler(value = [MethodArgumentTypeMismatchException.class])
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        String message
        if( "typeOfSuper" == ex.name ) {
            message = "Super [ ${ex.value} ] not found!"
        } else {
            message = ex.message
        }
        message
    }
}
