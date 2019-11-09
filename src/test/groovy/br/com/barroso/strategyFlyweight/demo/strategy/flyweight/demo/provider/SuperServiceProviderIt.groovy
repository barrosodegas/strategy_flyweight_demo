package br.com.barroso.strategyFlyweight.demo.strategy.flyweight.demo.provider;

import br.com.barroso.strategyFlyweight.demo.strategy.flyweight.demo.ApplicationTests
import br.com.barroso.strategyFlyweight.demo.strategy.flyweight.demo.exception.NotFoundException
import br.com.barroso.strategyFlyweight.demo.strategy.flyweight.demo.model.TypeOfSuper
import br.com.barroso.strategyFlyweight.demo.strategy.flyweight.demo.service.impl.SuperHeroService
import br.com.barroso.strategyFlyweight.demo.strategy.flyweight.demo.service.impl.SuperVillainService
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class SuperServiceProviderIt extends ApplicationTests {

    @Autowired
    SuperServiceProvider superServiceProvider

    void "should return error if service not found"() {
        given:
            def typeOfSuper = TypeOfSuper.ANTI_HERO
        when:
            superServiceProvider.getServiceBySuperName(typeOfSuper)
        then:
            def ex = thrown(NotFoundException)
            ex.message == "[ $typeOfSuper(s) ] not found!"
    }

    void "should return a super hero service if type is HERO"() {
        given:
            def typeOfSuper = TypeOfSuper.HERO
        when:
            def service = superServiceProvider.getServiceBySuperName(typeOfSuper)
        then:
            service instanceof SuperHeroService
    }

    void "should return a super villain service if type is HERO"() {
        given:
        def typeOfSuper = TypeOfSuper.VILLAIN
        when:
        def service = superServiceProvider.getServiceBySuperName(typeOfSuper)
        then:
        service instanceof SuperVillainService
    }

}
