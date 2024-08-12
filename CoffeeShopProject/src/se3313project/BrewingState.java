/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se3313project;

/**
 *
 * @author psk
 */


public class BrewingState implements CoffeeMakerState {
    private CoffeeMakerModel coffeeMaker;

    public BrewingState(CoffeeMakerModel coffeeMaker) {
        this.coffeeMaker = coffeeMaker;
    }

    @Override
    public void start() {
        
        System.out.println("Already brewing");

        
        coffeeMaker.startBrewingTimer();
    }

    @Override
    public void fillCups(int cups) {
        
        System.out.println("Cannot fill cups while brewing");
    }

    @Override
    public void reset() {
        coffeeMaker.stopBrewingTimer();
        coffeeMaker.setCurrentState(new EmptyState(coffeeMaker));
    }
}