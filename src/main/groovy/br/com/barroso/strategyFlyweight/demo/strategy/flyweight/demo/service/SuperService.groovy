package br.com.barroso.strategyFlyweight.demo.strategy.flyweight.demo.service

import br.com.barroso.strategyFlyweight.demo.strategy.flyweight.demo.model.Super
import br.com.barroso.strategyFlyweight.demo.strategy.flyweight.demo.model.TypeOfSuper

interface SuperService {

    Super findSuperById(long id)

    Super findSuperByName(String name)

    List<Super> listSupers()

    boolean match(TypeOfSuper typeOfSuper)

}