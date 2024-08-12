package se3313project;

import java.awt.Color;


public class CoffeeMakerController {
    private final CoffeeMakerModel coffeeMakerModel;
    private final ViewInterface coffeeMakerView;

    
    public CoffeeMakerController(CoffeeMakerModel coffeeMakerModel, ViewInterface coffeeMakerView) {
        this.coffeeMakerModel = coffeeMakerModel;
        this.coffeeMakerView = coffeeMakerView;

        
        coffeeMakerView.getStartButton().addActionListener(e -> handleStartButtonClick());
        coffeeMakerView.getFilledButton().addActionListener(e -> handleFilledButtonClick());
        coffeeMakerView.getResetButton().addActionListener(e -> handleResetButtonClick());
    }

    
    private void handleStartButtonClick() {
      
        CoffeeMakerState currentState = coffeeMakerModel.getCurrentState();

    if (currentState instanceof IdleState) {
        coffeeMakerModel.start();
        coffeeMakerView.getErrorMessageLabel().setText("Your Coffee brewing... Please wait");
        coffeeMakerView.getIDLEpanel().setBackground(Color.RED);
        coffeeMakerView.getBrewingPanel().setBackground(Color.YELLOW); 
    }
    System.out.println(coffeeMakerModel.getCurrentState().getClass().getName()); 
    if (coffeeMakerModel.getCurrentState().getClass().getName() == "se3313project.BrewingState") {
        
        try {
            Thread.sleep(3000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    coffeeMakerView.getBrewingPanel().setBackground(Color.RED);
    coffeeMakerView.getDonePanel().setBackground(Color.YELLOW);
    coffeeMakerView.getErrorMessageLabel().setText("Your Coffee is Done! Have a nice day :)");
       
    } else {
        System.out.println("Start button clicked - Other state");
    } 
    
    
    
   
        
    }

    
    private void handleFilledButtonClick() {
         try {
        int cups = Integer.parseInt(coffeeMakerView.getTotalCupsTextField().getText());
        coffeeMakerModel.fillCups(cups);
        coffeeMakerView.getIDLEpanel().setBackground(Color.yellow); 
        coffeeMakerView.getErrorMessageLabel().setText("You can press start to brew your coffee");
        // Assuming that "IDLE" is the desired state after filling cups
        coffeeMakerModel.setCurrentState(new IdleState(coffeeMakerModel));
       System.out.println("State after filling cups: "+ coffeeMakerModel.getCurrentState().getClass().getSimpleName());
    } catch (NumberFormatException ex) {
        // Handle invalid input (non-numeric) if needed
        coffeeMakerView.getErrorMessageLabel().setText("Invalid input for the number of cups.");
    }
    }

    
    private void handleResetButtonClick() {
        coffeeMakerModel.reset();
        coffeeMakerModel.setCurrentState(new EmptyState(coffeeMakerModel));
    }
}
