/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se3313project;
import java.util.TimerTask;
/**
 *
 * @author psk
 */
public class BrewingTask extends TimerTask {
    private CoffeeMakerModel coffeeMakerModel;

    public BrewingTask(CoffeeMakerModel coffeeMakerModel) {
        this.coffeeMakerModel = coffeeMakerModel;
    }

    @Override
    public void run() {
        
        coffeeMakerModel.stopBrewingTimer(); 
        coffeeMakerModel.setCurrentState(new DoneState(coffeeMakerModel)); 
        coffeeMakerModel.insertDataIntoDatabase(); 
        System.out.println("Brewing timer expired - Transitioning to DoneState");
    }
}
