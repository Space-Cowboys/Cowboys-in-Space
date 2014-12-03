/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Space.controller;

import Space.MainApp;
import Space.POJO.Planet;
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
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Keanu
 */
public class ZonessPortController extends playerAreaController implements Initializable {


    @FXML //fx:="portal1"
    ImageView portal1;

    @FXML //fx:id="portal2"
    ImageView portal2;
    
    @FXML //fx:id="fuelShopOwner"
    ImageView fuelShopOwner;
    
    @FXML //fx:id="fuelShop"
    AnchorPane fuelShop;
    
    @FXML //fx:id="creditslabel";
    Label creditsLabel;
    
    @FXML //fx:id="fuelLabel"
    Label fuelLabel;
    
    @FXML //fx:id="outOfMoney"
    AnchorPane outOfMoney;
    @FXML
    Pane background;
    
    Image[] yuWalkRight;
    Image[] yuWalkLeft;
    int yuRightCount;
    int yuLeftCount;
    Timer rightTimer;
    Timer leftTimer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        init();
        RootLayoutController.interestBank();
        RootLayoutController.interestLoan();
        yuWalkRight = new Image[4];
        yuWalkLeft = new Image[4];
        yuRightCount = 0;
        yuLeftCount = 0;
        background.setStyle("-fx-background-image: url(" +this.getClass().getResource("Art/ZonessPort.png").toExternalForm() +"); -fx-background-size: 100% 100%;");
        yuWalkRight[0] = new Image(this.getClass().getResource("Art/YuWalkRight1.png").toExternalForm());
        yuWalkRight[1] = new Image(this.getClass().getResource("Art/YuWalkRight2.png").toExternalForm());
        yuWalkRight[2] = new Image(this.getClass().getResource("Art/YuWalkRight3.png").toExternalForm());
        yuWalkRight[3] = new Image(this.getClass().getResource("Art/YuWalkRight4.png").toExternalForm());
        
        yuWalkLeft[0] = new Image(this.getClass().getResource("Art/YuWalkLeft1.png").toExternalForm());
        yuWalkLeft[1] = new Image(this.getClass().getResource("Art/YuWalkLeft2.png").toExternalForm());
        yuWalkLeft[2] = new Image(this.getClass().getResource("Art/YuWalkLeft3.png").toExternalForm());
        yuWalkLeft[3] = new Image(this.getClass().getResource("Art/YuWalkLeft4.png").toExternalForm());
        
        creditsLabel.setText(Integer.toString(RootLayoutController.getCredits()));
        fuelLabel.setText(Integer.toString(RootLayoutController.getFuel()));
        if (RootLayoutController.getOrientation() == 0) {
                    RootLayoutController.changeSong(this.getClass().getResource("Music/zoness.wav").toExternalForm());

        }
        Planet p = RootLayoutController.getUniverse().getFromName("Zoness");
        RootLayoutController.setPlanetLocation(p);
        BorderPane root = MainApp.getRootLayout();
        Scene scene = root.getScene();
        // Key event handling
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (ke.getCode().equals(KeyCode.RIGHT)) {
                     if (rightTimer == null) {
                    rightTimer = new Timer();
                }
                     if (protag.getLayoutX() < portal1.getLayoutX() + 50) {
                                protag.setLayoutX(protag.getLayoutX() +12);
                                }
                    rightTimer.schedule(new TimerTask() {
                    public void run() {
                        Platform.runLater(new Runnable() {
                            public void run() {
                                
                                protag.setImage(yuWalkRight[yuRightCount++ % 4]);

                            }
                        });
                    }
                },0,300); 
                    }
                if (ke.getCode().equals(KeyCode.LEFT)) {
                    if (leftTimer == null) {
                        leftTimer = new Timer();
                    }
                    if (protag.getLayoutX() > portal2.getLayoutX()) {
                                protag.setLayoutX(protag.getLayoutX() - 12);
                                }
                    leftTimer.schedule(new TimerTask() {
                    public void run() {
                        Platform.runLater(new Runnable() {
                            public void run() {
                                
                                protag.setImage(yuWalkLeft[yuLeftCount++ % 4]);

                            }
                        });
                    }
                },0,300); 
                }
                if (ke.getCode().equals(KeyCode.SPACE) && Math.abs(
                    protag.getLayoutX() - portal2.getLayoutX()) < 50 ) {
                    try {
                    // Load person overview.
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(MainApp.class.getResource(
                        "view/RushGalaxy.fxml"));
                    Pane characterCreation = (Pane) loader.load();
                    BorderPane rootLayout = MainApp.getRootLayout();
                    rootLayout.setCenter(characterCreation);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (ke.getCode().equals(KeyCode.SPACE) && Math.abs(protag.getLayoutX() - portal1.getLayoutX()) < 50 ) {
                    try {
                    // Load person overview.
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(MainApp.class.getResource(
                            "view/ZonessMarket.fxml"));
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
                            "view/ZonessShipyard.fxml");
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
                if (ke.getCode().equals(KeyCode.SPACE) && Math.abs(
                    protag.getLayoutX() - fuelShopOwner.getLayoutX()) < 50 ) {
                    if (RootLayoutController.getCredits() > 200
                            || RootLayoutController.getFuel() > 130) {
                        fuelShop.setVisible(true);
                    } else {
                        outOfMoney.setVisible(true);
                    }
                        
                }
            }
        });
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
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
    public void accept() {
        if (RootLayoutController.getCredits() >= 200) {
            RootLayoutController.setCredits(
                RootLayoutController.getCredits() - 200);
            RootLayoutController.setFuel(
                RootLayoutController.getFuel() + 150);
            creditsLabel.setText(Integer.toString(
                RootLayoutController.getCredits()));
            fuelLabel.setText(Integer.toString(
                RootLayoutController.getFuel()));
            creditsLabel.setText(Integer.toString(
                RootLayoutController.getCredits()));
            creditsLabel.setText(Integer.toString(
                RootLayoutController.getFuel()));
        }
    }
    
    public void deny() {
        outOfMoney.setVisible(false);
        fuelShop.setVisible(false);        
    }
    

}
