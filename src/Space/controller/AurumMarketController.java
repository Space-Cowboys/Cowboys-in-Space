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
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
public class AurumMarketController extends EmptyMarketController
    implements Initializable {

    @FXML
    AnchorPane initial;
    
    @FXML 
    AnchorPane initialBank;
    
    @FXML 
    AnchorPane initialLoan;
    
    @FXML
    AnchorPane withdrawPane;
    
    @FXML 
    AnchorPane depositPane;
    
    @FXML
    AnchorPane initialNoLoan;
    
    @FXML
    AnchorPane payOffPane;
    
    @FXML
    AnchorPane takeOutLoan;
    
    @FXML
    Label moneyInBank;
    
    @FXML
    Label moneyInInventory;
    
    @FXML
    Label moneyInInventory2;
    
    @FXML 
    Label moneyInInventory3;
    
    @FXML
    Label moneyInInventory4;
    
    @FXML
    Label loanAmount; 
    
    @FXML
    Label takeOutable;
    
    @FXML
    TextField withdrawArea;
    
    @FXML 
    TextField depositArea;
    
    @FXML
    TextField takeOutLoanArea;
    
    @FXML
    TextField payOffArea;
    
    @FXML 
    AnchorPane newPane;
    
    @FXML
    ImageView board;
    
    @FXML
    ImageView bank;
    
    Image[] yuWalkRight;
    Image[] yuWalkLeft;
    int yuRightCount;
    int yuLeftCount;
    Timer rightTimer;
    Timer leftTimer;
    
    @FXML
    AnchorPane mercBoard; 
    
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.init();
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
        RootLayoutController.interestBank();
        RootLayoutController.interestLoan();
        back.setStyle("-fx-background-image: url(" + this.getClass().getResource("Art/AurumMarketplace.png").toExternalForm() +"); -fx-background-size: 2250 100%;");
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
                        "view/AurumShipyard.fxml"));
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
                            "view/AurumMarket.fxml");
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
                    bank.getLayoutX() - protag.getLayoutX()) < 80 ) {
                    newPane.setVisible(true);
                    initial.setVisible(true);
                }
                
                if (ke.getCode().equals(KeyCode.SPACE) && Math.abs(
                    board.getLayoutX() - protag.getLayoutX()) < 80 ) {
                    mercBoard.setVisible(true);
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
    public void exitMerc() {
        mercBoard.setVisible(false);
    }
    public void merc1() {
        RootLayoutController.setMercLevel(1);
    }
    public void merc2() {
        RootLayoutController.setMercLevel(2);
    }
    public void merc3() {
        RootLayoutController.setMercLevel(3);
    }
    public void exit() {
        initial.setVisible(false);
        initialBank.setVisible(false);
        initialLoan.setVisible(false);
        depositPane.setVisible(false);
        withdrawPane.setVisible(false);
        takeOutLoan.setVisible(false);
        initialNoLoan.setVisible(false);
        payOffPane.setVisible(false);
    }
    
    public void showBank() {
        initialLoan.setVisible(false);
        depositPane.setVisible(false);
        withdrawPane.setVisible(false);
        takeOutLoan.setVisible(false);
        initialNoLoan.setVisible(false);
        payOffPane.setVisible(false);
        initialBank.setVisible(true);
        moneyInBank.setText(Integer.toString(RootLayoutController.getMoneyInBank()));
    }
    
    public void showDeposit() {
        depositPane.setVisible(true);
        withdrawPane.setVisible(false);
        moneyInInventory2.setText(Integer.toString(RootLayoutController.getCredits()));
    }
    public void depositAccept() {
        int value = -1;
        try {
            value = Integer.parseInt(depositArea.getCharacters().toString());
        } catch(Exception e) {
        }
        if (value <= RootLayoutController.getCredits() && value > -1) {
            RootLayoutController.setCredits(RootLayoutController.getCredits() - value);
            RootLayoutController.setMoneyInBank(RootLayoutController.getMoneyInBank() + value);
            moneyInBank.setText(Integer.toString(RootLayoutController.getMoneyInBank()));
            moneyInInventory2.setText(Integer.toString(RootLayoutController.getCredits()));
        }
    }
    public void showWithdraw() {
        depositPane.setVisible(false);
        withdrawPane.setVisible(true);
        moneyInInventory.setText(Integer.toString(RootLayoutController.getCredits()));
    }
    
    public void withdrawAccept() {
        int value = -1;
        try {
            value = Integer.parseInt(withdrawArea.getCharacters().toString());
        } catch(Exception e) {
        }
        if (value <= RootLayoutController.getMoneyInBank()&& value > -1) {
            RootLayoutController.setCredits(RootLayoutController.getCredits() + value);
            RootLayoutController.setMoneyInBank(RootLayoutController.getMoneyInBank() - value);
            moneyInBank.setText(Integer.toString(RootLayoutController.getMoneyInBank()));
            moneyInInventory.setText(Integer.toString(RootLayoutController.getCredits()));
        }
    }
    public void loan() {
        if (RootLayoutController.getCurrentLoan() > 0) {
            initialLoan.setVisible(true);
            depositPane.setVisible(false);
            withdrawPane.setVisible(false);
            takeOutLoan.setVisible(false);
            initialNoLoan.setVisible(false);
            payOffPane.setVisible(false);
            initialBank.setVisible(false);
            loanAmount.setText(Integer.toString(RootLayoutController.getCurrentLoan()));
        } else {
            initialLoan.setVisible(false);
            depositPane.setVisible(false);
            withdrawPane.setVisible(false);
            takeOutLoan.setVisible(false);
            initialNoLoan.setVisible(true);
            payOffPane.setVisible(false);
            initialBank.setVisible(false);
            takeOutable.setText(Integer.toString(RootLayoutController.getCreditScore()));
        }
    }
    public void takeOutLoan() {
        takeOutLoan.setVisible(true);
        moneyInInventory4.setText(Integer.toString(RootLayoutController.getCredits()));
    }
    
    public void takeOutLoanAccept() {
       int value = -1;
        try {
            value = Integer.parseInt(takeOutLoanArea.getCharacters().toString());
        } catch(Exception e) {
        }
        if (value <= RootLayoutController.getCreditScore() && value > -1) {
            RootLayoutController.setCredits(RootLayoutController.getCredits() + value);
            RootLayoutController.setCurrentLoan(value);
            RootLayoutController.setLoanAmount(value);
            moneyInInventory4.setText(Integer.toString(RootLayoutController.getCredits()));
            loan();
            
        }
    }
    
    public void payOff() {
        payOffPane.setVisible(true);
        moneyInInventory3.setText(Integer.toString(RootLayoutController.getCredits()));
    }
    
    public void payOffAccept() {
        int value = -1;
        try {
            value = Integer.parseInt(payOffArea.getCharacters().toString());
        } catch(Exception e) {
        }
        if (value <= RootLayoutController.getCredits() && value > -1) {
            if (value > RootLayoutController.getCurrentLoan()) {
                value = RootLayoutController.getCurrentLoan();
            }
            RootLayoutController.setCredits(RootLayoutController.getCredits() - value);
            RootLayoutController.setCurrentLoan(RootLayoutController.getCurrentLoan() - value);
            if (RootLayoutController.getCurrentLoan() == 0) {
                RootLayoutController.setCreditScore(RootLayoutController.getCreditScore() + RootLayoutController.getLoanAmount());
                RootLayoutController.setLoanAmount(0);
                loan();
            }
            moneyInInventory3.setText(Integer.toString(RootLayoutController.getCredits()));
            
        }
    }
    
    
    
    
    
    
    
}