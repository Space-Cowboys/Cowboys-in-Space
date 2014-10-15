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
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Keanu
 */
public class ZonessMarketController extends EmptyMarketController implements Initializable  {
   
    /**
     * Initializes the controller class.
     * This is what happens when the window itself is first initialized
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        init("Zoness");
        myScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (ke.getCode().equals(KeyCode.DOWN)) {
                    protag.setLayoutY(protag.getLayoutY()+5);
                    System.out.println(protag.getLayoutY());
                    
                }
                if (ke.getCode().equals(KeyCode.RIGHT)) {
                    protag.setImage(protagR.getImage());
                    protag.setLayoutX(protag.getLayoutX() +8);
                    if(protag.getLayoutX() > 500 && protag.getLayoutX() < 1300) {
                        back.setTranslateX(back.getTranslateX() - 8);
                    }
                    }
                if (ke.getCode().equals(KeyCode.LEFT)) {
                    protag.setImage(protagL.getImage());
                    protag.setLayoutX(protag.getLayoutX() - 8);
                    if(protag.getLayoutX() > 500 && protag.getLayoutX() < 1300) {
                        back.setTranslateX(back.getTranslateX() + 8);
                    }
                    
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
               if (ke.getCode().equals(KeyCode.SPACE) && Math.abs(shop.getLayoutX() - protag.getLayoutX()) < 80) {
                    shopWindowAnchor.setVisible(true);
                    shopWindowAnchor2.setVisible(true);
                    inventory.setVisible(true);
                    inventory1.setVisible(true);
                    messageWindow.setVisible(true);

                } 
               if (ke.getCode().equals(KeyCode.SPACE) && Math.abs(spacePortal.getLayoutX() - protag.getLayoutX()) < 80) {
                   try {
	        // Load person overview. 
                RootLayoutController.setOrientation(1);
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(MainApp.class.getResource("view/ZonessShipyard.fxml"));
                Pane characterCreation = (Pane) loader.load();
                BorderPane rootLayout = MainApp.getRootLayout(); 
                rootLayout.setCenter(characterCreation);
                
	    } catch (IOException e) {
	        e.printStackTrace();
	    } 
               }
            if (ke.getCode().equals(KeyCode.ENTER)) {
                    try {
                        // Load person overview. 
                        RootLayoutController.setLocation("view/ZonessMarket.fxml");
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(MainApp.class.getResource("view/Inventory.fxml"));
                        Pane characterCreation = (Pane) loader.load();
                        BorderPane rootLayout = MainApp.getRootLayout(); 
                        rootLayout.setCenter(characterCreation);

                    } catch (IOException e) {
                        e.printStackTrace();
                    } 
                }
            }
        });
    }
}