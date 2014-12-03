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
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
    
    @FXML //fx:id="reminder"
        Text reminder; 
    
    @FXML //fx:id="pilotBar"
    ProgressBar pilotBar; 
    
    @FXML //fx:id="engineeringBar"
    ProgressBar engineeringBar;
    
    @FXML //fx:id="charismaBar"
    ProgressBar charismaBar;
    
    @FXML //fx:id="luckBar"
    ProgressBar luckBar;
    

    public CharacterCreationController() {
        
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pilotBar.setProgress(RootLayoutController.getPilotSkill() / 100.0); 
        engineeringBar.setProgress(RootLayoutController.getEngineeringSkill() / 100.0);
        charismaBar.setProgress(RootLayoutController.getCharismaSkill() / 100.0);
        luckBar.setProgress(RootLayoutController.getLuckSkill() / 100.0);
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
            luckBar.setProgress(RootLayoutController.getLuckSkill() / 100.0);
        }
    }
 
    public void luckDown() { 
        if(RootLayoutController.getLuckSkill() > 1) {
            RootLayoutController.setLuckSkill(RootLayoutController.getLuckSkill() - 1);
            luckLabel.setText(Integer.toString(RootLayoutController.getLuckSkill()));
            RootLayoutController.setRemainingSkillPoints(RootLayoutController.getSkillPoints() + 1);
            skillLabel.setText(Integer.toString(RootLayoutController.getSkillPoints()));
            luckBar.setProgress(RootLayoutController.getLuckSkill() / 100.0);
        }
    }
    
    public void pilotUp() { 
        if (RootLayoutController.getSkillPoints() > 0) {
            RootLayoutController.setPilotSkill(RootLayoutController.getPilotSkill() + 1);
            pilotLabel.setText(Integer.toString(RootLayoutController.getPilotSkill()));
            RootLayoutController.setRemainingSkillPoints(RootLayoutController.getSkillPoints() - 1);
            skillLabel.setText(Integer.toString(RootLayoutController.getSkillPoints()));
            pilotBar.setProgress(RootLayoutController.getPilotSkill() / 100.0);
        }
    }
    public void pilotDown() { 
        if (RootLayoutController.getPilotSkill() > 1) {
            RootLayoutController.setPilotSkill(RootLayoutController.getPilotSkill() - 1);
            pilotLabel.setText(Integer.toString(RootLayoutController.getPilotSkill()));
            RootLayoutController.setRemainingSkillPoints(RootLayoutController.getSkillPoints() + 1);
            skillLabel.setText(Integer.toString(RootLayoutController.getSkillPoints()));
            pilotBar.setProgress(RootLayoutController.getPilotSkill() / 100.0);
        }
    }
    
    public void engineeringUp() {
        if (RootLayoutController.getSkillPoints() > 0) {    
            RootLayoutController.setEngineeringSkill(RootLayoutController.getEngineeringSkill() + 1);
            engineeringLabel.setText(Integer.toString(RootLayoutController.getEngineeringSkill()));
            RootLayoutController.setRemainingSkillPoints(RootLayoutController.getSkillPoints() - 1);
            skillLabel.setText(Integer.toString(RootLayoutController.getSkillPoints()));
            engineeringBar.setProgress(RootLayoutController.getEngineeringSkill() / 100.0);
        }
    }
   
    public void engineeringDown() { 
        if (RootLayoutController.getEngineeringSkill() > 1) {
            RootLayoutController.setEngineeringSkill(RootLayoutController.getEngineeringSkill() - 1);
            engineeringLabel.setText(Integer.toString(RootLayoutController.getEngineeringSkill()));
            RootLayoutController.setRemainingSkillPoints(RootLayoutController.getSkillPoints() + 1);
            skillLabel.setText(Integer.toString(RootLayoutController.getSkillPoints()));
            engineeringBar.setProgress(RootLayoutController.getEngineeringSkill() / 100.0);
        }
    }
    public void charismaUp() { 
        if (RootLayoutController.getSkillPoints() > 0) {
            RootLayoutController.setCharismaSkill(RootLayoutController.getCharismaSkill() + 1);
            charismaLabel.setText(Integer.toString(RootLayoutController.getCharismaSkill()));
            RootLayoutController.setRemainingSkillPoints(RootLayoutController.getSkillPoints() - 1);
            skillLabel.setText(Integer.toString(RootLayoutController.getSkillPoints()));
            charismaBar.setProgress(RootLayoutController.getCharismaSkill() / 100.0);
        }
    }
    
    public void charismaDown() { 
        if (RootLayoutController.getCharismaSkill() > 1) {
            RootLayoutController.setCharismaSkill(RootLayoutController.getCharismaSkill() - 1);
            charismaLabel.setText(Integer.toString(RootLayoutController.getCharismaSkill()));
            RootLayoutController.setRemainingSkillPoints(RootLayoutController.getSkillPoints() + 1);
            skillLabel.setText(Integer.toString(RootLayoutController.getSkillPoints()));
            charismaBar.setProgress(RootLayoutController.getCharismaSkill() / 100.0);
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
            if(RootLayoutController.getSkillPoints() == 0 && nameField.getCharacters().toString().length() > 0) {
                RootLayoutController.setName(nameField.getCharacters().toString());
                System.out.println(RootLayoutController.getName());
                try {
	        // Load person overview. 
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(MainApp.class.getResource("view/Confirm.fxml"));
                Pane confirm = (Pane) loader.load();
                BorderPane rootLayout = MainApp.getRootLayout(); 
                rootLayout.setCenter(confirm);
                
	    } catch (IOException e) {
	        e.printStackTrace();
	    } 
            } else {
                remind();
                
            }
        }
        
        @FXML public void remind() {
            reminder.setVisible(true);
        }
}
