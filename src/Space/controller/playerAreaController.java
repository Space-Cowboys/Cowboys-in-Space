/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Space.controller;

import Space.MainApp;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author Keanu
 */
public class playerAreaController {
    @FXML //fx:id="protag"
    ImageView protag; 
    
    @FXML //fx:id="protagL"
    ImageView protagL;
    
    @FXML //fx:id="protagR"
    ImageView protagR;
    
    @FXML //fx:id="spacePortal"
    ImageView spacePortal;
    
    @FXML //fx:id="back"
    AnchorPane back;
    
    Boolean isJumping = false;
        
    Scene myScene;
    Timer timer;
    
    public void init() {
        timer = new Timer();
        BorderPane root = MainApp.getRootLayout(); 
        myScene = root.getScene();
        myScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                
                if (ke.getCode().equals(KeyCode.RIGHT)) {
                    protag.setImage(protagR.getImage());
                    protag.setLayoutX(protag.getLayoutX() + 8);
                }
                
                if (ke.getCode().equals(KeyCode.LEFT)) {
                    protag.setImage(protagL.getImage());
                    protag.setLayoutX(protag.getLayoutX() - 8);
                }
                
                if (ke.getCode().equals(KeyCode.UP)) {
                    if (isJumping == false) {
                        protag.setLayoutY(protag.getLayoutY() - 50);
                        isJumping = true;
                    
                        timer.schedule(new TimerTask() {
                            public void run() {
                                Platform.runLater(new Runnable() {
                                    public void run() {
                                        protag.setLayoutY(protag.getLayoutY() + 50);
                                        isJumping = false;
                                    }
                                });
                            }
                        }, 750);}
                    }
                }
        });
    }
}
