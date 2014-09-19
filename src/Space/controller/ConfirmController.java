/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Space.controller;

import Space.MainApp;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

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
    
}
