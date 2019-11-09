package br.com.barroso.strategyFlyweight.demo.strategy.flyweight.demo.service.impl

import br.com.barroso.strategyFlyweight.demo.strategy.flyweight.demo.exception.NotFoundException
import br.com.barroso.strategyFlyweight.demo.strategy.flyweight.demo.model.Hero
import br.com.barroso.strategyFlyweight.demo.strategy.flyweight.demo.model.Super
import br.com.barroso.strategyFlyweight.demo.strategy.flyweight.demo.model.TypeOfSuper
import br.com.barroso.strategyFlyweight.demo.strategy.flyweight.demo.model.hero.Aquaman
import br.com.barroso.strategyFlyweight.demo.strategy.flyweight.demo.model.hero.Batman
import br.com.barroso.strategyFlyweight.demo.strategy.flyweight.demo.model.hero.Superman
import br.com.barroso.strategyFlyweight.demo.strategy.flyweight.demo.service.SuperService
import org.springframework.stereotype.Component

@Component
class SuperHeroService implements SuperService {

    List<Hero> heroes

    // TODO: Change this for a database!
    SuperHeroService() {
        heroes = [
            new Batman(
                id: 1,
                name: "Batman",
                powers: [
                    "Billionaire.",
                    "Intelligent",
                    "Good fighter"],
                weaknesses: [
                    "Can easily be injured by a human being",
                    "Trust no one"]),
            new Superman(
                id: 2,
                name: "Superman",
                powers: [
                    "Super strength",
                    "X-ray vision",
                    "Laser vision",
                    "Invulnerability",
                    "Freezing breath",
                    "Super hearing"
                ],
                weaknesses: ["Kryptonita"]),
            new Aquaman(
                id: 3,
                name: "Aquaman",
                powers: [
                    "Breathing under water",
                    "Super strength",
                    "Control all forms of marine life"
                ],
                weaknesses: ["Weapons Created in Atlantis"])
        ]
    }

    @Override
    Super findSuperById(long id) {
        heroes.stream().filter { it.id == id }
            .findFirst()
            .orElseThrow { new NotFoundException("Super hero with ID [ $id ] not found!") }
    }

    @Override
    Super findSuperByName(String name) {
        heroes.stream().filter { it.name == name }
            .findFirst()
            .orElseThrow { new NotFoundException("Super hero with name [ $name ] not found!") }
    }

    @Override
    List<Super> listSupers() {
        heroes
    }

    @Override
    boolean match(TypeOfSuper typeOfSuper) {
        TypeOfSuper.HERO == typeOfSuper
    }

}
