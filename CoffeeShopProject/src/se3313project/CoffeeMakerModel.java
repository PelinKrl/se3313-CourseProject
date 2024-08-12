/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se3313project;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
/**
 *
 * @author psk
 */

public class CoffeeMakerModel {
    private CoffeeMakerState currentState;
    private int totalCupsInMonth;
    private Date currentDate;
    private BrewingState brewingState; 
    private Timer brewingTimer;
    private TimerTask brewingTask;
    private TimerManager timerManager;

    // Database operations
    private CoffeeMakerDatabase coffeeMakerDatabase;

    // Timer for brewing state
    

    public CoffeeMakerModel() {
        
        currentState = new EmptyState(this);
        totalCupsInMonth = 0;
        currentDate = new Date();
        coffeeMakerDatabase = new CoffeeMakerDatabase();
        //brewingTimer = new Timer();
         brewingTask = new BrewingTask(this); 
          timerManager = new TimerManager();
    }

    // Setters and getters for the state
    public void setCurrentState(CoffeeMakerState state) {
        this.currentState = state;
        if(state instanceof BrewingState) {
            this.brewingState = (BrewingState) state;
        }
        notifyObservers(); 
    }

    public CoffeeMakerState getCurrentState() {
        return currentState;
    }

    
    public void start() {
        currentState.start();
    }

    public void fillCups(int cups) {
        currentState.fillCups(cups);
    }

    public void reset() {
        currentState.reset();
    }

    
    public void insertDataIntoDatabase() {
        coffeeMakerDatabase.insertData(totalCupsInMonth, currentDate);
        System.out.println("Data added to the database");
    }

    
    public void incrementTotalCups(int cups) {
        totalCupsInMonth += cups;
    }

    public int getTotalCupsInMonth() {
        return totalCupsInMonth;
    }

    
    public void startBrewingTimer() {
        brewingTask = new BrewingTask(this);
        timerManager.scheduleBrewingTimer(new BrewingTask(this), 5000);
        System.out.println("Brewing timer started");
    }

    public void stopBrewingTimer() {
        timerManager.cancelBrewingTimer();
        System.out.println("Brewing timer stopped");
    }

    
    private CoffeeMakerObserver observer;

    public void addObserver(CoffeeMakerObserver observer) {
        this.observer = observer;
    }

    public void notifyObservers() {
        if (observer != null) {
            observer.update();
        }
    }
}

