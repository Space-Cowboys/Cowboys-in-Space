/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Space.controller;

import Space.MainApp;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import java.util.Timer;
import Space.POJO.Planet;

/**
 * FXML Controller class
 *
 * @author Cameron
 */
public class MissionController implements Initializable {
    @FXML //fx:id="spaceship"
    ImageView spaceship; 
    
    @FXML //fx:id="laser"
    ImageView laser; 
    
    @FXML //fx:id="rock"
    ImageView rock; 
    
    Planet location;
    Planet destination;

    Timer timer;
    
    /**
     * Initializes the controller class.
     * This is what happens when the window itself is first initialized
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        timer = new Timer(); 
        RootLayoutController.changeSong("src/Space/Music/flying.wav");
        BorderPane root = MainApp.getRootLayout(); 
        Scene scene = root.getScene();
        Planet location = RootLayoutController.getPlanet();
        Planet destination = RootLayoutController.getDestination();
       

        // Key event handling
scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (ke.getCode().equals(KeyCode.DOWN)) {
                    spaceship.setLayoutY(spaceship.getLayoutY()+8);
                }
                
                if (ke.getCode().equals(KeyCode.RIGHT)) {
                    spaceship.setLayoutX(spaceship.getLayoutX() +8);
                }
                
                if (ke.getCode().equals(KeyCode.LEFT)) {
                    spaceship.setLayoutX(spaceship.getLayoutX() - 8);
                }
                
                if (ke.getCode().equals(KeyCode.UP)) {
                    spaceship.setLayoutY(spaceship.getLayoutY() - 8);
                }
            }
        });
    }
}