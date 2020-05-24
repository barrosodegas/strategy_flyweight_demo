# Strategy Flyweight Demo API
Rest API with Strategy and Flyweight.  A great combination of structural design patterns.

This combination of design patterns is indicated when we need to process the same information in different ways depending on how it is parameterized.

## About this project

It is designed to illustrate code building using these standards and is not fully finalized. This REST API brings data from super heroes and super villains based on the information passed on the endpoint call it exposes.

### This is a spring boot project with java 14 and Groovy.

### BDD tests were also built to cover all scenarios foreseen in these operations.

## Endpoints

- [Get Hero by type and name](http://localhost:8180/super/HERO/Batman) - Response: Json
- [List Heroes by type](http://localhost:8180/super/HERO) - Response: Json

- [Get Villain by type and name](http://localhost:8180/super/VILLAIN/Joker) - Response: Json
- [List Villains by type](http://localhost:8180/VILLAIN/HERO) - Response: Json

## To compile project

- mvn clean package compile -U -T 2

## To run API

With java 14 version

- java -jar (absolute path to file)/strategy_flyweight_demo.jar
