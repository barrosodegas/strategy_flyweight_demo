package br.com.barroso.strategyFlyweight.demo.strategy.flyweight.demo.service

import br.com.barroso.strategyFlyweight.demo.strategy.flyweight.demo.ApplicationTests
import br.com.barroso.strategyFlyweight.demo.strategy.flyweight.demo.exception.NotFoundException
import br.com.barroso.strategyFlyweight.demo.strategy.flyweight.demo.model.TypeOfSuper
import br.com.barroso.strategyFlyweight.demo.strategy.flyweight.demo.service.impl.SuperHeroService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.annotation.DirtiesContext

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class SuperHeroServiceIt extends ApplicationTests {

    @Autowired
    SuperHeroService superHeroService

    void "should return error if hero not found by id"() {
        given:
            def id = 0
        when:
            superHeroService.findSuperById(id)
        then:
            def ex = thrown(NotFoundException)
            ex.message == "Super hero with ID [ $id ] not found!"
    }

    void "should return hero if is valid id"() {
        given:
            def id = 1
        when:
            def superHero = superHeroService.findSuperById(id)
        then:
            superHero
            superHero.name == "Batman"
    }

    void "should return error if hero not found by name"() {
        given:
            def name = "Cave captain"
        when:
            superHeroService.findSuperByName(name)
        then:
            def ex = thrown(NotFoundException)
            ex.message == "Super hero with name [ $name ] not found!"
    }

    void "should return hero by valid name"() {
        given:
            def name = "Batman"
        when:
            def superHero = superHeroService.findSuperByName(name)
        then:
            superHero
            superHero.name == "Batman"
    }

    void "should return hero list"() {
        when:
            def superHero = superHeroService.listSupers()
        then:
            superHero
            superHero.size() > 0
    }

    void "should return false if is not hero service"() {
        when:
            def isHeroService = superHeroService.match(TypeOfSuper.ANTI_HERO)
        then:
            !isHeroService
    }

    void "should return true if is a hero service"() {
        when:
            def isHeroService = superHeroService.match(TypeOfSuper.HERO)
        then:
            isHeroService
    }

}
