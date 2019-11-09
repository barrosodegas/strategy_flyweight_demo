package br.com.barroso.strategyFlyweight.demo.strategy.flyweight.demo.service.impl

import br.com.barroso.strategyFlyweight.demo.strategy.flyweight.demo.exception.NotFoundException
import br.com.barroso.strategyFlyweight.demo.strategy.flyweight.demo.model.Super
import br.com.barroso.strategyFlyweight.demo.strategy.flyweight.demo.model.TypeOfSuper
import br.com.barroso.strategyFlyweight.demo.strategy.flyweight.demo.model.Villain
import br.com.barroso.strategyFlyweight.demo.strategy.flyweight.demo.model.villain.Joker
import br.com.barroso.strategyFlyweight.demo.strategy.flyweight.demo.model.villain.LexLuthor
import br.com.barroso.strategyFlyweight.demo.strategy.flyweight.demo.model.villain.BlackStingray
import br.com.barroso.strategyFlyweight.demo.strategy.flyweight.demo.service.SuperService
import org.springframework.stereotype.Component

@Component
class SuperVillainService implements SuperService {

    List<Villain> villains

    // TODO: Change this for a database!
    SuperVillainService() {
        villains = [
            new Joker(
                id: 1,
                name: "Joker",
                powers: [
                    "Good fighter",
                    "Intelligent"
                ],
                weaknesses: ["Can easily be injured by a human being"]),
            new LexLuthor(
                id: 2,
                name: "Lex Luthor",
                powers: [
                    "Intelligent",
                    "Billionaire"],
                weaknesses: ["Can easily be injured by a human being"]),
            new BlackStingray(
                id: 3,
                name: "Black Stingray",
                powers: [
                    "Good fighter",
                    "Laser ray"],
                weaknesses: ["Can easily be injured by a human being"])
        ]
    }

    @Override
    Super findSuperById(long id) {
        villains.stream().filter { it.id == id }
            .findFirst()
            .orElseThrow { new NotFoundException("Super villain with ID [ $id ] not found!") }
    }

    @Override
    Super findSuperByName(String name) {
        villains.stream().filter { it.name == name }
            .findFirst()
            .orElseThrow { new NotFoundException("Super villain with name [ $name ] not found!") }
    }

    @Override
    List<Super> listSupers() {
        villains
    }

    @Override
    boolean match(TypeOfSuper typeOfSuper) {
        TypeOfSuper.VILLAIN == typeOfSuper
    }

}
