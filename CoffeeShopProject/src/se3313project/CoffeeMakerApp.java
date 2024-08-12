/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package se3313project;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author psk
 */
public class CoffeeMakerApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
               
                CoffeeMakerModel model = new CoffeeMakerModel();
                ViewInterface view = new ViewInterface(model);
                view.setVisible(true); 
                CoffeeMakerController controller = new CoffeeMakerController(model,view);

            }
        });
        
    }
    
}
