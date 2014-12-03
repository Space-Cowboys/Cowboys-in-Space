/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Space.controller;

import Space.MainApp;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
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
    Image[] yuWalkRight;
    Image[] yuWalkLeft;
    int yuRightCount;
    int yuLeftCount;
    Timer rightTimer;
    Timer leftTimer;/**
     * Initializes the controller class.
     * This is what happens when the window itself is first initialized
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        super.init();
        RootLayoutController.interestBank();
        RootLayoutController.interestLoan();
        
        back.setStyle("-fx-background-image: url(" +this.getClass().getResource("Art/ZonessMarketplace.png").toExternalForm() +"); -fx-background-size: 2250 100%;");
        yuWalkRight = new Image[4];
        yuWalkLeft = new Image[4];
        yuRightCount = 0;
        yuLeftCount = 0;
        yuWalkRight[0] = new Image(this.getClass().getResource("Art/YuWalkRight1.png").toExternalForm());
        yuWalkRight[1] = new Image(this.getClass().getResource("Art/YuWalkRight2.png").toExternalForm());
        yuWalkRight[2] = new Image(this.getClass().getResource("Art/YuWalkRight3.png").toExternalForm());
        yuWalkRight[3] = new Image(this.getClass().getResource("Art/YuWalkRight4.png").toExternalForm());
        
        yuWalkLeft[0] = new Image(this.getClass().getResource("Art/YuWalkLeft1.png").toExternalForm());
        yuWalkLeft[1] = new Image(this.getClass().getResource("Art/YuWalkLeft2.png").toExternalForm());
        yuWalkLeft[2] = new Image(this.getClass().getResource("Art/YuWalkLeft3.png").toExternalForm());
        yuWalkLeft[3] = new Image(this.getClass().getResource("Art/YuWalkLeft4.png").toExternalForm());
       myScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (ke.getCode().equals(KeyCode.RIGHT)) {
                    if (rightTimer == null) {
                    rightTimer = new Timer();
                }
                    if (protag.getLayoutX() < 2200) {
                                protag.setLayoutX(protag.getLayoutX() + 12);
                                if (protag.getLayoutX() > 500
                        && protag.getLayoutX() < 1300) {
                        back.setTranslateX(back.getTranslateX() - 12);
                    }
                                }
                    rightTimer.schedule(new TimerTask() {
                    public void run() {
                        Platform.runLater(new Runnable() {
                            public void run() {
                                
                                protag.setImage(yuWalkRight[yuRightCount++ % 4]);
                            }
                        });
                    }
                },0,400); 
                }
                 if (ke.getCode().equals(KeyCode.LEFT)) {
                    if (leftTimer == null) {
                        leftTimer = new Timer();
                    }
                    if (protag.getLayoutX() > 0) {
                                protag.setLayoutX(protag.getLayoutX() - 12);
                                
                                if(protag.getLayoutX() > 500
                        && protag.getLayoutX() < 1300) {
                        back.setTranslateX(back.getTranslateX() + 12);
                    }
                                }
                    leftTimer.schedule(new TimerTask() {
                    public void run() {
                        Platform.runLater(new Runnable() {
                            public void run() {
                                
                       protag.setImage(yuWalkLeft[yuLeftCount++ % 4]);

                                

                            }
                        });
                    }
                },0,400); 
                    
                }
               if (ke.getCode().equals(KeyCode.SPACE) && Math.abs(
                       shop.getLayoutX() - protag.getLayoutX()) < 80) {
                    shopWindowAnchor.setVisible(true);
                    shopWindowAnchor2.setVisible(true);
                    inventory.setVisible(true);
                    inventory1.setVisible(true);
                    messageWindow.setVisible(true);
                    sellWindow.setVisible(false);
                    buyWindow.setVisible(false);
                    denialWindow.setVisible(false);
                    shopContainer.setVisible(true);
                }
                if (ke.getCode().equals(KeyCode.SPACE) && Math.abs(
                    spacePortal.getLayoutX() - protag.getLayoutX()) < 80) {
                   try {
                    // Load person overview.
                    RootLayoutController.setOrientation(1);
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(MainApp.class.getResource(
                        "view/ZonessShipyard.fxml"));
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
                        RootLayoutController.setLocation(
                            "view/ZonessMarket.fxml");
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(MainApp.class.getResource(
                            "view/Inventory.fxml"));
                        Pane characterCreation = (Pane) loader.load();
                        BorderPane rootLayout = MainApp.getRootLayout();
                        rootLayout.setCenter(characterCreation);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                
            }

        });
        myScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (ke.getCode().equals(KeyCode.RIGHT)) {
                    if (rightTimer != null) {
                        rightTimer.cancel();

                    }
                    protag.setImage(new Image(this.getClass().getResource("Art/YuRight.png").toExternalForm()));
                    rightTimer = new Timer();
                }
                if (ke.getCode().equals(KeyCode.LEFT)) {
                    if (leftTimer != null) {
                        leftTimer.cancel();
                    }
                    protag.setImage(new Image(this.getClass().getResource("Art/YuLeft.png").toExternalForm()));
                    leftTimer = new Timer();
                }
            }
        });

    }
}