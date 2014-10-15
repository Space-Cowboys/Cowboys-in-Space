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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Keanu
 */
public class ShipDeathController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void exit() {
        System.exit(0);
    }
    
    public void goAway() {
        try {
            // Load person overview. 
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/" + RootLayoutController.getPlanet().getName() + "Shipyard.fxml"));
            Pane characterCreation = (Pane) loader.load();
            BorderPane rootLayout = MainApp.getRootLayout(); 
            rootLayout.setCenter(characterCreation);

        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
    
}
