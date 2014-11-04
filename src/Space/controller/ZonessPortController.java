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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        init();
        creditsLabel.setText(Integer.toString(RootLayoutController.getCredits()));
        fuelLabel.setText(Integer.toString(RootLayoutController.getFuel()));
        if (RootLayoutController.getOrientation() == 0) {
            RootLayoutController.changeSong(
                "src/Space/Music/cowboy ground.wav");
        }
        Planet p = RootLayoutController.getUniverse().getFromName("Zoness");
        RootLayoutController.setPlanetLocation(p);
        BorderPane root = MainApp.getRootLayout();
        Scene scene = root.getScene();
        // Key event handling
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (ke.getCode().equals(KeyCode.DOWN)) {
                    protag.setLayoutY(protag.getLayoutY()+5);
                    System.out.println(protag.getLayoutY());
                }
                if (ke.getCode().equals(KeyCode.RIGHT)) {
                    protag.setImage(new Image(MainApp.class.getResource("view/art/YuRight.png").toExternalForm()));
                    protag.setLayoutX(protag.getLayoutX() +8);

                    }
                if (ke.getCode().equals(KeyCode.LEFT)) {
                    protag.setImage(new Image(MainApp.class.getResource("view/art/YuLeft.png").toExternalForm()));
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
                                        protag.setLayoutY(
                                            protag.getLayoutY() + 50);
                                        isJumping = false;

                                    }
                                });
                            }
                        }, 750);
                    }
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
