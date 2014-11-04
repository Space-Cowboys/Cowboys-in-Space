/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Space.controller;

import Space.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Keanu
 */
public class WelcomeScreenController implements Initializable {

    
    
    @FXML public void exit(ActionEvent e) {
        System.exit(0);
    }
    
    @FXML public void showCharacterCreation() {
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
    
    public void load() {
        RootLayoutController.load();
            String name = RootLayoutController.getPlanet().getName();
            System.out.println(name);
                try {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(MainApp.class.getResource("view/" + name + "Shipyard.FXML"));
                    Pane characterCreation = (Pane) loader.load();
                    BorderPane rootLayout = MainApp.getRootLayout(); 
                    rootLayout.setCenter(characterCreation);

                } catch (IOException e) {
                    e.printStackTrace();
                }
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {


    }    


}
