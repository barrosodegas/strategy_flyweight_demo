package br.com.barroso.strategyFlyweight.demo.strategy.flyweight.demo.service

import br.com.barroso.strategyFlyweight.demo.strategy.flyweight.demo.ApplicationTests
import br.com.barroso.strategyFlyweight.demo.strategy.flyweight.demo.exception.NotFoundException
import br.com.barroso.strategyFlyweight.demo.strategy.flyweight.demo.model.TypeOfSuper
import br.com.barroso.strategyFlyweight.demo.strategy.flyweight.demo.service.impl.SuperVillainService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.annotation.DirtiesContext

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class SuperVillainServiceIt extends ApplicationTests {

    @Autowired
    SuperVillainService superVillainService

    void "should return error if villain not found by id"() {
        given:
            def id = 0
        when:
            superVillainService.findSuperById(id)
        then:
            def ex = thrown(NotFoundException)
            ex.message == "Super villain with ID [ $id ] not found!"
    }

    void "should return villain if is valid id"() {
        given:
            def id = 1
        when:
            def superVillain = superVillainService.findSuperById(id)
        then:
            superVillain
            superVillain.name == "Joker"
    }

    void "should return error if villain not found by name"() {
        given:
            def name = "Cave captain"
        when:
            superVillainService.findSuperByName(name)
        then:
            def ex = thrown(NotFoundException)
            ex.message == "Super villain with name [ $name ] not found!"
    }

    void "should return villain by valid name"() {
        given:
            def name = "Joker"
        when:
            def superVillain = superVillainService.findSuperByName(name)
        then:
            superVillain
            superVillain.name == "Joker"
    }

    void "should return villain list"() {
        when:
            def superVillain = superVillainService.listSupers()
        then:
            superVillain
            superVillain.size() > 0
    }

    void "should return false if is not villain service"() {
        when:
            def isVillainService = superVillainService.match(TypeOfSuper.ANTI_HERO)
        then:
            !isVillainService
    }

    void "should return true if is a villain service"() {
        when:
            def isVillainService = superVillainService.match(TypeOfSuper.VILLAIN)
        then:
            isVillainService
    }

}
