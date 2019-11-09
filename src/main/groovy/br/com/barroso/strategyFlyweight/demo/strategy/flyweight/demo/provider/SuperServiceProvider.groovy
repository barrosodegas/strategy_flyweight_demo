package br.com.barroso.strategyFlyweight.demo.strategy.flyweight.demo.provider

import br.com.barroso.strategyFlyweight.demo.strategy.flyweight.demo.exception.NotFoundException
import br.com.barroso.strategyFlyweight.demo.strategy.flyweight.demo.model.TypeOfSuper
import br.com.barroso.strategyFlyweight.demo.strategy.flyweight.demo.service.SuperService
import org.springframework.stereotype.Component

@Component
class SuperServiceProvider {

    private final List<SuperService> superServices

    SuperServiceProvider(List<SuperService> superServices) {
        this.superServices = superServices
    }

    SuperService getServiceBySuperName(TypeOfSuper typeOfSuper) {
        this.superServices.stream()
            .filter { it.match(typeOfSuper) }
            .findFirst()
            .orElseThrow { new NotFoundException("[ $typeOfSuper(s) ] not found!") }
    }

}
