/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se3313project;

/**
 *
 * @author psk
 */
public class DoneState implements CoffeeMakerState{
    private CoffeeMakerModel coffeeMaker;

    public DoneState(CoffeeMakerModel coffeeMaker) {
        this.coffeeMaker = coffeeMaker;
    }

    @Override
    public void start() {
        
         System.out.println("Cannot start brewing in the done state");
    }

    @Override
    public void fillCups(int cups) {
        
         System.out.println("Cannot fill cups in the done state");
    }

    @Override
    public void reset() {
        coffeeMaker.setCurrentState(new EmptyState(coffeeMaker));
    }

  
}
