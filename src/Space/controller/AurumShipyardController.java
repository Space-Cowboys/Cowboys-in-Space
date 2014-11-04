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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

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

    @FXML //fx:id="creditsLabel2"
    Label creditsLabel2;
    
    @FXML //fx:id="repairCost"
    Label repairCost;
    
    @FXML //fx:id="currentShipStrength"
    Label currentShipStrength;
    
    @FXML //fx:id="maxShipStrength"
    Label maxShipStrength;
    
    @FXML //fx:id="repairCost1"
    Label repairCost1; 
    
    @FXML //fx:id="messageWindow"
    AnchorPane messageWindow;
    
    @FXML //fx:id="shipBuy"
    AnchorPane shipBuy;
    
    @FXML //fx:id="cargoLabel"
    Label cargoLabel;
    
    @FXML //fx:id="playerSip"
    ImageView playerShip;
    
    @FXML //fx:id="hullLabel"
    Label hullLabel;
    
    @FXML //fx:id="energyLabel"
    Label energyLabel;
    
    @FXML //fx:id="pilotLabel"
    Label pilotLabel;
    
    @FXML //fx:id="shipPriceLabel"
    Label shipPriceLabel;
    
    @FXML //fx:id="shieldBuy"
    AnchorPane shieldBuy;
    
    @FXML //fx:id="laserBuy"
    AnchorPane laserBuy;
    
    @FXML //fx:id="energyTankScreen"
    AnchorPane energyTankScreen; 
    
    @FXML //fx:id="eneryPrice"
    Label energyPrice; 
    
    @FXML //fx:id="energyTanksQuantity"
    Label energyTanksQuantity;
    
    @FXML //fx:id="currentEnery"
    Label currentEnergy;
    
    @FXML //fx:id="maxEnergy"
    Label maxEnergy;
    
    @FXML //fx:id="shipSeller"
    ImageView shipSeller;
    
    @FXML //fx:id="repairScreen"
    AnchorPane repairScreen;
    
    @FXML //fx:id="buyShip2Button"
    Button buyShip2Button;
    
    @FXML //fx:id="buyShip3Button"
    Button buyShip3Button;
    
    @FXML //fx:id="shipSHop"
    AnchorPane shipShop;
    
    @FXML //fx:id="denialWindow"
    AnchorPane denialWindow;
    
    @FXML //fx:id="message"
    Text message;
    
    Timer timer;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (RootLayoutController.getOrientation() == 0) {
            RootLayoutController.changeSong(
                    "src/Space/Music/cowboy ground.wav");
            protag.setLayoutX(100);
            protag.setImage(protagR.getImage());
        }
        timer = new Timer();
        creditsLabel.setText(Integer.toString(
                RootLayoutController.getCredits()));
        currentFuel.setText(Integer.toString(RootLayoutController.getFuel()));
        Planet p = RootLayoutController.getUniverse().getFromName("Aurum");
        RootLayoutController.setPlanetLocation(p);
        BorderPane root = MainApp.getRootLayout();
        Scene scene = root.getScene();
         // Key event handling
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
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
                    if (!isJumping) {
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
                        }, 750);
                    }
               }
                if (ke.getCode().equals(KeyCode.SPACE) && Math.abs(
                    protag.getLayoutX() - spacePortal.getLayoutX()) < 50 ) {
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
                if (ke.getCode().equals(KeyCode.SPACE)
                    && Math.abs(protag.getLayoutX()
                        - aurumMarketPortal.getLayoutX()) < 50) {
                    try {
                        // Load person overview.
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(MainApp.class.getResource(
                            "view/AurumMarket.fxml"));
                        Pane characterCreation = (Pane) loader.load();
                        BorderPane rootLayout = MainApp.getRootLayout();
                        rootLayout.setCenter(characterCreation);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (ke.getCode().equals(KeyCode.SPACE) && Math.abs(
                    protag.getLayoutX() - fuelShop.getLayoutX()) < 50 ) {
                    fuelShopContainer.setVisible(true);
                }
                if (ke.getCode().equals(KeyCode.SPACE) && Math.abs(
                    protag.getLayoutX() - shipSeller.getLayoutX()) < 50 ) {
                    fuelShopContainer.setVisible(false);
                    shipShop.setVisible(true);
                    shipBuy.setVisible(false);
                    messageWindow.setVisible(true);
                    shieldBuy.setVisible(false);
                    laserBuy.setVisible(false);
                    buyShip2Button.setVisible(true);
                    buyShip3Button.setVisible(false);
                    energyTankScreen.setVisible(false);
                    repairScreen.setVisible(false);
                    RootLayoutController.setCredits(1000000);
                    creditsLabel2.setText(Integer.toString(RootLayoutController.getCredits()));
                    repairCost.setText(Integer.toString(100 * (RootLayoutController.getShip().getMaxShipHealth() - RootLayoutController.getShip().getCurrentHealth())));
                    
                }
                if (ke.getCode().equals(KeyCode.ENTER)) {
                    try {
                        // Load person overview.
                        RootLayoutController.setLocation(
                            "view/AurumShipYard.fxml");
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
    }
    /**
     * Method that dictates what happens if the player accepts the deal.
     */
    public void accept() {
        if (RootLayoutController.getCredits() >= 300) {
            RootLayoutController.setCredits(
                RootLayoutController.getCredits() - 300);
            RootLayoutController.setFuel(
                RootLayoutController.getFuel() + 300);
            creditsLabel.setText(Integer.toString(
                RootLayoutController.getCredits()));
            currentFuel.setText(Integer.toString(
                RootLayoutController.getFuel()));
            creditsLabel1.setText(Integer.toString(
                RootLayoutController.getCredits()));
            currentFuel1.setText(Integer.toString(
                RootLayoutController.getFuel()));
        }
    }
    
    public void exit() {
        shipShop.setVisible(false);
        denialWindow.setVisible(false);
    }
    /**
     * Dictates what happens if the player decides against the offer.
     */
    public void deny() {
        fuelShopContainer.setVisible(false);
        fuelCheckS.setVisible(false);
        fuelCheckF.setVisible(false);
    }
    /**
     * Decides the course of action if the player tries to barter.
     */
    public void barter() {
        if (RootLayoutController.getCharismaSkill() >= 10) {
            fuelShopContainer.setVisible(false);
            fuelCheckS.setVisible(true);
            creditsLabel1.setText(Integer.toString(
                RootLayoutController.getCredits()));
            currentFuel1.setText(Integer.toString(
                RootLayoutController.getFuel()));
        } else {
            fuelCheckF.setVisible(true);
        }
    }
    /**
     * The actual buying of the item.
    */
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
    
    public void shipLevel2Buy() {
        denialWindow.setVisible(false);
        shipBuy.setVisible(true);
        messageWindow.setVisible(false);
        shieldBuy.setVisible(false);
        laserBuy.setVisible(false);
        buyShip2Button.setVisible(true);
        buyShip3Button.setVisible(false);
        energyTankScreen.setVisible(false);
        repairScreen.setVisible(false);
        cargoLabel.setText(Integer.toString(20));
        hullLabel.setText(Integer.toString(2));
        energyLabel.setText("10");
        pilotLabel.setText("10");
        shipPriceLabel.setText("5000");
        playerShip.setImage(new Image(MainApp.class.getResource("view/art/PlayerShip"
                + Integer.toString(2) + "Status.png").toExternalForm()));
    }
    
    public void buyShip2() {
        if (RootLayoutController.getCredits() >= 5000) {
            if (RootLayoutController.getShip().getShipLevel() < 2) {
                if (RootLayoutController.getPilotSkill() >= 10) {
                    RootLayoutController.getShip().setShipLevel(2);
                    RootLayoutController.getShip().setMaxEnergyBars(10);
                    RootLayoutController.getShip().setMaxShipHealth(2);
                    RootLayoutController.getShip().setCurrentHealth(2);
                    RootLayoutController.getShip().setCurrentEnergy(10);
                    RootLayoutController.getShip().setMaxCapacity(20);
                    RootLayoutController.setCredits(RootLayoutController.getCredits() - 10000);
                    creditsLabel.setText(Integer.toString(RootLayoutController.getCredits()));
                    creditsLabel1.setText(Integer.toString(RootLayoutController.getCredits()));
                    creditsLabel2.setText(Integer.toString(RootLayoutController.getCredits()));
                    denialWindow.setVisible(true);
                    message.setText("Transaction Successful!");
                } else {
                    denialWindow.setVisible(true);
                    message.setText("Your pilot skill is to low ;-;");
                } 
            } else {
                denialWindow.setVisible(true);
                message.setText("Your ship is far more powerful then this one...");
            }
        } else {
            denialWindow.setVisible(true);
            message.setText("Not enough money bucco");
        }
    }
    public void shipLevel3Buy() {
        denialWindow.setVisible(false);
        shipBuy.setVisible(true);
        messageWindow.setVisible(false);
        shieldBuy.setVisible(false);
        laserBuy.setVisible(false);
        buyShip2Button.setVisible(false);
        buyShip3Button.setVisible(true);
        energyTankScreen.setVisible(false);
        repairScreen.setVisible(false);
        cargoLabel.setText(Integer.toString(30));
        hullLabel.setText(Integer.toString(3));
        energyLabel.setText("15");
        pilotLabel.setText("20");
        shipPriceLabel.setText("10000");
        playerShip.setImage(new Image(MainApp.class.getResource("view/art/PlayerShip"
                + Integer.toString(3) + "Status.png").toExternalForm()));    
    }
    
    public void buyShip3() {
        if (RootLayoutController.getCredits() >= 10000) {
            if (RootLayoutController.getShip().getShipLevel() < 3) {
                if (RootLayoutController.getPilotSkill() >= 20) {
                    RootLayoutController.getShip().setShipLevel(3);
                    RootLayoutController.getShip().setMaxEnergyBars(15);
                    RootLayoutController.getShip().setMaxShipHealth(3);
                    RootLayoutController.getShip().setCurrentHealth(3);
                    RootLayoutController.getShip().setCurrentEnergy(15);
                    RootLayoutController.getShip().setMaxCapacity(30);
                    RootLayoutController.setCredits(RootLayoutController.getCredits() - 10000);
                    creditsLabel.setText(Integer.toString(RootLayoutController.getCredits()));
                    creditsLabel1.setText(Integer.toString(RootLayoutController.getCredits()));
                    creditsLabel2.setText(Integer.toString(RootLayoutController.getCredits()));
                    denialWindow.setVisible(true);
                    message.setText("Transaction Sucessful!");
                } else {
                    denialWindow.setVisible(true);
                    message.setText("Your pilot skill is to low ;-;");
                }
            } else {
                denialWindow.setVisible(true);
                message.setText("Your ship is far more powerful then this one...");
            }
        } else {
            denialWindow.setVisible(true);
            message.setText("Not enough money bucco");
        }    
    }
    
    public void shieldView() {
        denialWindow.setVisible(false);
        shipBuy.setVisible(false);
        messageWindow.setVisible(false);
        shieldBuy.setVisible(true);
        laserBuy.setVisible(false);
        energyTankScreen.setVisible(false);
        repairScreen.setVisible(false);
    }
    
    public void laserView() {
        denialWindow.setVisible(false);
        shipBuy.setVisible(false);
        messageWindow.setVisible(false);
        shieldBuy.setVisible(false);
        laserBuy.setVisible(true);
        energyTankScreen.setVisible(false);
        repairScreen.setVisible(false);
    }
    public void buyLaser() {
        if (RootLayoutController.getCredits() > 3000) {
            if (RootLayoutController.getShip().getMaxLaserLevel() < 2) {
                RootLayoutController.setCredits((RootLayoutController.getCredits() - 3000));
                RootLayoutController.getShip().setMaxLaserLevel(2);
                RootLayoutController.getShip().setCurrentLaserLevel(2);
                creditsLabel.setText(Integer.toString(RootLayoutController.getCredits()));
                creditsLabel1.setText(Integer.toString(RootLayoutController.getCredits()));
                creditsLabel2.setText(Integer.toString(RootLayoutController.getCredits()));
                denialWindow.setVisible(true);
                message.setText("Transaction Successful!");
            } else {
                denialWindow.setVisible(true);
                message.setText("Your laser is far more powerful already...");
            }
        } else {
            denialWindow.setVisible(true);
            message.setText("Not enough money bucco");
        }
    }
    public void buyShield() {
        if (RootLayoutController.getCredits() > 2500) {
            if (RootLayoutController.getShip().getMaxShieldLevel() < 2) {
                RootLayoutController.setCredits((RootLayoutController.getCredits() - 2500));
                RootLayoutController.getShip().setMaxShieldLevel(2);
                RootLayoutController.getShip().setCurrentShieldLevel(2);
                creditsLabel.setText(Integer.toString(RootLayoutController.getCredits()));
                creditsLabel1.setText(Integer.toString(RootLayoutController.getCredits()));
                creditsLabel2.setText(Integer.toString(RootLayoutController.getCredits()));     
                denialWindow.setVisible(true);
                message.setText("Transaction Sucessful!");
            } else {
                denialWindow.setVisible(true);
                message.setText("YOu already have a more powerful Shield...");
            }
        } else {
            denialWindow.setVisible(true);
            message.setText("Not enough money bucco");
        }
    }
    
    public void energyView() {
        denialWindow.setVisible(false);
        shipBuy.setVisible(false);
        messageWindow.setVisible(false);
        shieldBuy.setVisible(false);
        laserBuy.setVisible(false);
        energyTankScreen.setVisible(true);
        repairScreen.setVisible(false);
        currentEnergy.setText(Integer.toString(RootLayoutController.getShip().getCurrentEnergy()));
        maxEnergy.setText(Integer.toString(RootLayoutController.getShip().getMaxEnergyBars()));
        energyPrice.setText("50");
        energyTanksQuantity.setText("1");
    }
    
    
    public void showRepair() {
        denialWindow.setVisible(false);
        shipBuy.setVisible(false);
        messageWindow.setVisible(false);
        shieldBuy.setVisible(false);
        laserBuy.setVisible(false);
        energyTankScreen.setVisible(false);
        repairScreen.setVisible(true);
        currentShipStrength.setText(Integer.toString(RootLayoutController.getShip().getCurrentHealth()));
        maxShipStrength.setText(Integer.toString(RootLayoutController.getShip().getMaxShipHealth()));
        repairCost1.setText(Integer.toString(100 * (RootLayoutController.getShip().getMaxShipHealth() - RootLayoutController.getShip().getCurrentHealth())));
    }
    public void repairIt() {
        int price = 100 * (RootLayoutController.getShip().getMaxShipHealth()) - RootLayoutController.getShip().getCurrentHealth();
        if (RootLayoutController.getCredits() >= price) {
            RootLayoutController.setCredits(RootLayoutController.getCredits() - price);
            RootLayoutController.getShip().setCurrentHealth(RootLayoutController.getShip().getMaxShipHealth());
            currentShipStrength.setText(Integer.toString(RootLayoutController.getShip().getCurrentHealth()));
            maxShipStrength.setText(Integer.toString(RootLayoutController.getShip().getMaxShipHealth()));
            repairCost1.setText(Integer.toString(100 * (RootLayoutController.getShip().getMaxShipHealth() - RootLayoutController.getShip().getCurrentHealth())));            
            repairCost.setText(Integer.toString(100 * (RootLayoutController.getShip().getMaxShipHealth() - RootLayoutController.getShip().getCurrentHealth())));   
            creditsLabel.setText(Integer.toString(RootLayoutController.getCredits()));
            denialWindow.setVisible(true);
            message.setText("Transaction Succesful");
        } else {
            denialWindow.setVisible(true);
            message.setText("Not enough money bucco");
        }
    }
    
    public void quatUp() {
        if (Integer.parseInt(energyTanksQuantity.getText()) < (RootLayoutController.getShip().getMaxEnergyBars() - RootLayoutController.getShip().getCurrentEnergy())) {
            energyTanksQuantity.setText(Integer.toString(Integer.parseInt(energyTanksQuantity.getText())+1));
            energyPrice.setText(Integer.toString(100 * Integer.parseInt(energyTanksQuantity.getText())));
        }
    }
    
    public void quatDown() {
        if (Integer.parseInt(energyTanksQuantity.getText()) > 1) {
            energyTanksQuantity.setText(Integer.toString(Integer.parseInt(energyTanksQuantity.getText())-1));
            energyPrice.setText(Integer.toString(100 * Integer.parseInt(energyTanksQuantity.getText())));
        }
    }
    
    public void setMax() {
        int num = (RootLayoutController.getShip().getMaxEnergyBars() - RootLayoutController.getShip().getCurrentEnergy());
        energyTanksQuantity.setText(Integer.toString(num));
        energyPrice.setText(Integer.toString(100 * num));
    }
    public void buyEnergy() {
        if (RootLayoutController.getCredits() >= Integer.parseInt(energyPrice.getText())) {
            if (RootLayoutController.getShip().getCurrentEnergy() != RootLayoutController.getShip().getMaxEnergyBars()) {
                RootLayoutController.getShip().setCurrentEnergy(RootLayoutController.getShip().getCurrentEnergy() + Integer.parseInt(energyTanksQuantity.getText()));
                RootLayoutController.setCredits(RootLayoutController.getCredits() - Integer.parseInt(energyPrice.getText()));
                creditsLabel.setText(Integer.toString(RootLayoutController.getCredits()));
                creditsLabel1.setText(Integer.toString(RootLayoutController.getCredits()));
                creditsLabel2.setText(Integer.toString(RootLayoutController.getCredits()));                
                energyTanksQuantity.setText("1");
                energyPrice.setText("100");
                currentEnergy.setText(Integer.toString(RootLayoutController.getShip().getCurrentEnergy()));
                maxEnergy.setText(Integer.toString(RootLayoutController.getShip().getMaxEnergyBars()));
                denialWindow.setVisible(true);
                message.setText("Transaction Succesful!");
            } else {
                denialWindow.setVisible(true);
                message.setText("You can't hold that much energy!");
            }
        } else {
            denialWindow.setVisible(true);
            message.setText("Not enough money bucco");
        }
    }
   }    
    
