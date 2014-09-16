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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Keanu
 */
public class CharacterCreationController implements Initializable {
    @FXML //fx:id="pilotLabel"
        Label pilotLabel;
    
    @FXML //fx:id="charismaLabel"
        Label charismaLabel;
    
    @FXML //fx:id="luckLabel"
        Label luckLabel;
    
    @FXML //fx:id="engineeringLabel"
        Label engineeringLabel;
    
    @FXML //fx:id="skillLabel"
        Label skillLabel; 
    @FXML //fx:id="nameField"
        TextField nameField; 
    

    public CharacterCreationController() {
        
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pilotLabel.setText(Integer.toString(RootLayoutController.getPilotSkill()));
        engineeringLabel.setText(Integer.toString(RootLayoutController.getEngineeringSkill()));
        charismaLabel.setText(Integer.toString(RootLayoutController.getCharismaSkill()));
        luckLabel.setText(Integer.toString(RootLayoutController.getLuckSkill()));
        skillLabel.setText(Integer.toString(RootLayoutController.getSkillPoints()));
        
    }    
    
    public void luckUp() {
        if (RootLayoutController.getSkillPoints() > 0) {
            RootLayoutController.setLuckSkill(RootLayoutController.getLuckSkill() + 1);
            luckLabel.setText(Integer.toString(RootLayoutController.getLuckSkill()));
            RootLayoutController.setRemainingSkillPoints(RootLayoutController.getSkillPoints() - 1);
            skillLabel.setText(Integer.toString(RootLayoutController.getSkillPoints()));
        }
    }
 
    public void luckDown() { 
        if(RootLayoutController.getLuckSkill() > 1) {
            RootLayoutController.setLuckSkill(RootLayoutController.getLuckSkill() - 1);
            luckLabel.setText(Integer.toString(RootLayoutController.getLuckSkill()));
            RootLayoutController.setRemainingSkillPoints(RootLayoutController.getSkillPoints() + 1);
            skillLabel.setText(Integer.toString(RootLayoutController.getSkillPoints()));
        }
    }
    
    public void pilotUp() { 
        if (RootLayoutController.getSkillPoints() > 0) {
            RootLayoutController.setPilotSkill(RootLayoutController.getPilotSkill() + 1);
            pilotLabel.setText(Integer.toString(RootLayoutController.getPilotSkill()));
            RootLayoutController.setRemainingSkillPoints(RootLayoutController.getSkillPoints() - 1);
            skillLabel.setText(Integer.toString(RootLayoutController.getSkillPoints()));
        }
    }
    public void pilotDown() { 
        if (RootLayoutController.getPilotSkill() > 1) {
            RootLayoutController.setPilotSkill(RootLayoutController.getPilotSkill() - 1);
            pilotLabel.setText(Integer.toString(RootLayoutController.getPilotSkill()));
            RootLayoutController.setRemainingSkillPoints(RootLayoutController.getSkillPoints() + 1);
            skillLabel.setText(Integer.toString(RootLayoutController.getSkillPoints()));
        }
    }
    
    public void engineeringUp() {
        if (RootLayoutController.getSkillPoints() > 0) {    
            RootLayoutController.setEngineeringSkill(RootLayoutController.getEngineeringSkill() + 1);
            engineeringLabel.setText(Integer.toString(RootLayoutController.getEngineeringSkill()));
            RootLayoutController.setRemainingSkillPoints(RootLayoutController.getSkillPoints() - 1);
            skillLabel.setText(Integer.toString(RootLayoutController.getSkillPoints()));
        }
    }
   
    public void engineeringDown() { 
        if (RootLayoutController.getEngineeringSkill() > 1) {
            RootLayoutController.setEngineeringSkill(RootLayoutController.getEngineeringSkill() - 1);
            engineeringLabel.setText(Integer.toString(RootLayoutController.getEngineeringSkill()));
            RootLayoutController.setRemainingSkillPoints(RootLayoutController.getSkillPoints() + 1);
            skillLabel.setText(Integer.toString(RootLayoutController.getSkillPoints()));
        }
    }
    public void charismaUp() { 
        if (RootLayoutController.getSkillPoints() > 0) {
            RootLayoutController.setCharismaSkill(RootLayoutController.getCharismaSkill() + 1);
            charismaLabel.setText(Integer.toString(RootLayoutController.getCharismaSkill()));
            RootLayoutController.setRemainingSkillPoints(RootLayoutController.getSkillPoints() - 1);
            skillLabel.setText(Integer.toString(RootLayoutController.getSkillPoints()));
        }
    }
    
    public void charismaDown() { 
        if (RootLayoutController.getCharismaSkill() > 1) {
            RootLayoutController.setCharismaSkill(RootLayoutController.getCharismaSkill() - 1);
            charismaLabel.setText(Integer.toString(RootLayoutController.getCharismaSkill()));
            RootLayoutController.setRemainingSkillPoints(RootLayoutController.getSkillPoints() + 1);
            skillLabel.setText(Integer.toString(RootLayoutController.getSkillPoints()));
        }
    }
    
        @FXML public void showWelcomeScreen() {
	    try {
	        // Load person overview. 
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(MainApp.class.getResource("view/WelcomeScreen.fxml"));
                Pane welcomeScreen = (Pane) loader.load();
                BorderPane rootLayout = MainApp.getRootLayout(); 
                rootLayout.setCenter(welcomeScreen);
                
	    } catch (IOException e) {
	        e.printStackTrace();
	    } 
	}
        @FXML public void confirm() {
           System.out.println(nameField.getCharacters());
           RootLayoutController.setName(nameField.getCharacters().toString());
        }
}
