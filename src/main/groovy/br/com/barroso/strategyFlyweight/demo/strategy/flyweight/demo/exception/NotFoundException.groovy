package br.com.barroso.strategyFlyweight.demo.strategy.flyweight.demo.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(code = HttpStatus.NOT_FOUND)
class NotFoundException extends RuntimeException {

    NotFoundException(String message) {
        super(message)
    }

}
