/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se3313project;

/**
 *
 * @author psk
 */
public class EmptyState implements CoffeeMakerState{
    private CoffeeMakerModel coffeeMaker;
  

    public EmptyState(CoffeeMakerModel coffeeMaker) {
        this.coffeeMaker = coffeeMaker;
        
    }

    @Override
    public void start() {
        System.out.println("Warning: Cannot start brewing when the machine is empty.");
        
        
    }

    @Override
    public void fillCups(int cups) {
        coffeeMaker.incrementTotalCups(cups);
        coffeeMaker.setCurrentState(new IdleState(coffeeMaker));
    }

    @Override
    public void reset() {
        
    }

  
}
