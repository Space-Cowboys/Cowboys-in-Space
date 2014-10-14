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
public class AurumShipyardController implements Initializable {
    @FXML //fx:id="protag"
    ImageView protag; 
    
    @FXML //fx:id="back"
    AnchorPane back;
    
    Boolean isJumping = false;
    
    @FXML //fx:id="protagL"
    ImageView protagL;
    
    @FXML //fx:id="protagR"
    ImageView protagR;
    
    @FXML //fx:id="shopContainer"
    AnchorPane shopContainer;
    
    @FXML //fx:id="fuelShop"
    ImageView fuelShop;
    
    @FXML //fx:id="fuelShopContainer"
    AnchorPane fuelShopContainer;
    
    @FXML //fx:id="currentFuel"
    Label currentFuel; 
    
    @FXML //fx:id="creditsLabel"
    Label creditsLabel;
    
    @FXML //fx:id="currentFuel1"
    Label currentFuel1; 
    
    @FXML //fx:id="creditsLabel1"
    Label creditsLabel1;
    
    @FXML //fx:id="fuelCheckS"
    AnchorPane fuelCheckS;
    
    @FXML //fx:id="fuelCheckF"
    AnchorPane fuelCheckF;
    
    @FXML //fx:id="aurumMarketPortal
    ImageView aurumMarketPortal;
    
    @FXML //fx;id="spacePortal"
    ImageView spacePortal;
    
    Timer timer;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (RootLayoutController.getOrientation() == 0) {
            protag.setLayoutX(100);
            protag.setImage(protagR.getImage());
            
        }
        timer = new Timer();
        creditsLabel.setText(Integer.toString(RootLayoutController.getCredits()));
        currentFuel.setText(Integer.toString(RootLayoutController.getFuel()));
        Planet p = RootLayoutController.getUniverse().getFromName("Aurum");
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
                    protag.setImage(protagR.getImage());
                    protag.setLayoutX(protag.getLayoutX() +8);

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
              // if (ke.getCode().equals(KeyCode.SPACE) && Math.abs(shop.getLayoutX() - protag.getLayoutX()) < 80) {
                    

              //  } 
               if (ke.getCode().equals(KeyCode.SPACE) && Math.abs(protag.getLayoutX() - spacePortal.getLayoutX()) < 50 ) {
                   try {
	        // Load person overview. 
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(MainApp.class.getResource("view/RushGalaxy.fxml"));
                Pane characterCreation = (Pane) loader.load();
                BorderPane rootLayout = MainApp.getRootLayout(); 
                rootLayout.setCenter(characterCreation);
                
	    } catch (IOException e) {
	        e.printStackTrace();
	    } 
               }
             if (ke.getCode().equals(KeyCode.SPACE) && Math.abs(protag.getLayoutX() - aurumMarketPortal.getLayoutX()) < 50 ) {
                 try {
	        // Load person overview. 
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(MainApp.class.getResource("view/AurumMarket.fxml"));
                Pane characterCreation = (Pane) loader.load();
                BorderPane rootLayout = MainApp.getRootLayout(); 
                rootLayout.setCenter(characterCreation);
                
	    } catch (IOException e) {
	        e.printStackTrace();
	    } 
               }
             if (ke.getCode().equals(KeyCode.SPACE) && Math.abs(protag.getLayoutX() - fuelShop.getLayoutX()) < 50 ) {
                 fuelShopContainer.setVisible(true);
                 
             }
            }
        });

         
    }
    
    public void accept() {
        if (RootLayoutController.getCredits() >= 300) {
            RootLayoutController.setCredits(RootLayoutController.getCredits() - 300);
            RootLayoutController.setFuel(RootLayoutController.getFuel() + 300);
            creditsLabel.setText(Integer.toString(RootLayoutController.getCredits()));
            currentFuel.setText(Integer.toString(RootLayoutController.getFuel()));
            creditsLabel1.setText(Integer.toString(RootLayoutController.getCredits()));
            currentFuel1.setText(Integer.toString(RootLayoutController.getFuel()));
        }
    }
    
    public void deny() {
        fuelShopContainer.setVisible(false);
        fuelCheckS.setVisible(false);
        fuelCheckF.setVisible(false);
 
    }
    
    public void barter() {
        if (RootLayoutController.getCharismaSkill() >= 10) {
            fuelShopContainer.setVisible(false);
            fuelCheckS.setVisible(true);
            creditsLabel1.setText(Integer.toString(RootLayoutController.getCredits()));
            currentFuel1.setText(Integer.toString(RootLayoutController.getFuel()));
        } else {
            fuelCheckF.setVisible(true);
        }
    }

    public void buy1(){
        if (RootLayoutController.getCredits() >= 150) {
            RootLayoutController.setCredits(RootLayoutController.getCredits() - 150);
            RootLayoutController.setFuel(RootLayoutController.getFuel() + 300);
            creditsLabel.setText(Integer.toString(RootLayoutController.getCredits()));
            currentFuel.setText(Integer.toString(RootLayoutController.getFuel()));
            creditsLabel1.setText(Integer.toString(RootLayoutController.getCredits()));
            currentFuel1.setText(Integer.toString(RootLayoutController.getFuel()));
        }
    }
    }    
    
