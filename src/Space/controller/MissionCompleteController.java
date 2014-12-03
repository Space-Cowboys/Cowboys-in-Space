/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Space.controller;

import Space.MainApp;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.util.Random;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Keanu
 */
public class MissionCompleteController implements Initializable {

    @FXML //fx:id="scoreLabel"
    Label scoreLabel;
    
    @FXML //fx:id="fuelReward"
    Label fuelReward; 
    
    @FXML //fx:id="creditsReward"
    Label creditsReward;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Random rand = new Random();
        scoreLabel.setText(Integer.toString(RootLayoutController.getFlyingPoints()));
        if (RootLayoutController.getFlyingPoints() == 0) {
            RootLayoutController.setFlyingPoints(10);
        }
        int num = rand.nextInt(RootLayoutController.getFlyingPoints()/2) + RootLayoutController.getFlyingPoints()/2;
        int num2 = rand.nextInt(RootLayoutController.getFlyingPoints()/2) + RootLayoutController.getFlyingPoints()/2;
        int num3 = rand.nextInt(RootLayoutController.getFlyingPoints()/2) + RootLayoutController.getFlyingPoints()/2;
        int leftover = num % 10; 
        int leftover2 = num2 % 10;
        int reward2 = num2 - leftover;
        int reward = num - leftover; 
        leftover = num3 % 10;
        int reward3 = num3 - leftover;
        
        RootLayoutController.setCredits(RootLayoutController.getCredits() + reward2);
        RootLayoutController.setFuel(RootLayoutController.getFuel() + reward);
        RootLayoutController.setXp( reward3 + RootLayoutController.getXp());
        if (RootLayoutController.getXp() >= 1000) {
            RootLayoutController.setLevel(RootLayoutController.getLevel() + 1);
            RootLayoutController.setXp(RootLayoutController.getXp() - 1000);
            RootLayoutController.setRemainingSkillPoints(RootLayoutController.getSkillPoints() + 4);
        }
        fuelReward.setText(Integer.toString(reward));
        creditsReward.setText(Integer.toString(reward2));
        
    }    
    
    public void onwards() {
        try {
            // Load person overview. 
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/" + RootLayoutController.getToPlanet().getName() + "Shipyard.fxml"));
            Pane characterCreation = (Pane) loader.load();
            BorderPane rootLayout = MainApp.getRootLayout(); 
            rootLayout.setCenter(characterCreation);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
