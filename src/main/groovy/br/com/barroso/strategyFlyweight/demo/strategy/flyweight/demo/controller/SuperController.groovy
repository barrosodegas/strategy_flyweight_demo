package br.com.barroso.strategyFlyweight.demo.strategy.flyweight.demo.controller

import br.com.barroso.strategyFlyweight.demo.strategy.flyweight.demo.model.Super
import br.com.barroso.strategyFlyweight.demo.strategy.flyweight.demo.model.TypeOfSuper
import br.com.barroso.strategyFlyweight.demo.strategy.flyweight.demo.provider.SuperServiceProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/super")
class SuperController {

    @Autowired
    private SuperServiceProvider superServiceProvider

    @GetMapping(value = "/{typeOfSuper}/{name}")
    Super getSuperByTypeAndName(@PathVariable(value = "typeOfSuper") TypeOfSuper typeOfSuper,
                  @PathVariable(value = "name") String name) {

        this.superServiceProvider.getServiceBySuperName(typeOfSuper).findSuperByName(name)
    }

    // TODO: Apply pagination after creating the database!
    @GetMapping(value = ["/{typeOfSuper}"])
    List<Super> listSuper(@PathVariable(value = "typeOfSuper") TypeOfSuper typeOfSuper) {

        this.superServiceProvider.getServiceBySuperName(typeOfSuper).listSupers()
    }

}
