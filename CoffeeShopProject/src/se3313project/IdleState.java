/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se3313project;

/**
 *
 * @author psk
 */
public class IdleState implements CoffeeMakerState{
    private CoffeeMakerModel coffeeMaker;

    public IdleState(CoffeeMakerModel coffeeMaker) {
        this.coffeeMaker = coffeeMaker;
    }

    @Override
    public void start() {
        coffeeMaker.startBrewingTimer();
        coffeeMaker.setCurrentState(new BrewingState(coffeeMaker));
    }

    @Override
    public void fillCups(int cups) {
        
    }

    @Override
    public void reset() {
        coffeeMaker.setCurrentState(new EmptyState(coffeeMaker));
    }

  
}
