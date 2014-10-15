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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Keanu
 */
public class ConfirmController implements Initializable {

    
    @FXML // fx:id="name"
    Label name; 
    
    @FXML //fx:id="pilot"
    Label pilot;
    
    @FXML //fx:id="engineer"
    Label engineer;
    
    @FXML //fx:id="charisma"
    Label charisma;
    
    @FXML //fx:id="luck"
    Label luck;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pilot.setText(Integer.toString(RootLayoutController.getPilotSkill()));
        engineer.setText(Integer.toString(RootLayoutController.getEngineeringSkill()));
        charisma.setText(Integer.toString(RootLayoutController.getCharismaSkill()));
        luck.setText(Integer.toString(RootLayoutController.getLuckSkill()));
        name.setText(RootLayoutController.getName());
        // TODO
    }    
    
    public void cowboyTime() {
        try {
	        // Load person overview. 
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(MainApp.class.getResource("view/ZonessShipyard.fxml"));
                Pane characterCreation = (Pane) loader.load();
                BorderPane rootLayout = MainApp.getRootLayout(); 
                rootLayout.setCenter(characterCreation);
                
	    } catch (IOException e) {
	        e.printStackTrace();
	    } 
    }
    
    public void pussyOut() {
        try {
	        // Load person overview. 
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(MainApp.class.getResource("view/CharacterCreation.fxml"));
                Pane characterCreation = (Pane) loader.load();
                BorderPane rootLayout = MainApp.getRootLayout(); 
                rootLayout.setCenter(characterCreation);
                
	    } catch (IOException e) {
	        e.printStackTrace();
	    } 
    }
    
}
