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
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import java.util.Random;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Keanu
 */
public class MissionController implements Initializable {
    @FXML
    private AnchorPane back;
    @FXML
    private ImageView spaceShip;
    @FXML
    private ImageView laser;
    @FXML
    private ImageView enemyShip;
    @FXML
    private Label scoreLabel;
    Timer timer;
    
    boolean enemyThere = false;
    
    int score = 0;

    boolean isDone = false;


    /**
     * Initializes the controller class.
     */
    @Override
   
    /**
     * Initializes the controller class.
     * This is what happens when the window itself is first initialized
     */
    public void initialize(URL url, ResourceBundle rb) { 
        scoreLabel.setText(Integer.toString(score));
        BorderPane root = MainApp.getRootLayout(); 
        Scene scene = root.getScene();
        Random rand = new Random();
        
        Timer gameTimer = new Timer();
            gameTimer.schedule(new TimerTask() {
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {
                        if(isDone) {
                            try {
                                // Load person overview. 
                                FXMLLoader loader = new FXMLLoader();
                                loader.setLocation(MainApp.class.getResource("view/CharacterCreation.fxml"));
                                Pane characterCreation = (Pane) loader.load();
                                BorderPane rootLayout = MainApp.getRootLayout(); 
                                rootLayout.setCenter(characterCreation);

                            } catch (IOException e) {
                                e.printStackTrace();
                            } 
                        }
                        isDone = true;
                       
                    
                    }
                });
            }
        },0,30000); 
        
        Timer enemyTimer = new Timer();
        enemyTimer.schedule(new TimerTask() {
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {
                        if(!enemyThere) {
                            enemyShip.setLayoutY(0);
                            enemyShip.setLayoutX(rand.nextInt(1300));
                            enemyShip.setVisible(true);
                            enemyThere = true;
                        }
                        enemyShip.setLayoutY(enemyShip.getLayoutY() + 15);
                        if (Math.abs(enemyShip.getLayoutX() - spaceShip.getLayoutX()) < 200 
                                && Math.abs(enemyShip.getLayoutY() - spaceShip.getLayoutY()) < 200) {
                            
                            try {
                                // Load person overview. 
                                FXMLLoader loader = new FXMLLoader();
                                loader.setLocation(MainApp.class.getResource("view/CharacterCreation.fxml"));
                                Pane characterCreation = (Pane) loader.load();
                                BorderPane rootLayout = MainApp.getRootLayout(); 
                                rootLayout.setCenter(characterCreation);

                            } catch (IOException e) {
                                e.printStackTrace();
                            } 
                        }
                           System.out.println(enemyShip.getLayoutY());

                        if (enemyShip.getLayoutY() > 800) {
                            enemyThere = false;
                            enemyShip.setVisible(false);
                        }
                    
                    }
                });
            }
        },0,100); 
        // Key event handling
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
               
                if (ke.getCode().equals(KeyCode.RIGHT)) {
                    spaceShip.setLayoutX(spaceShip.getLayoutX() + 15);

                    }
                if (ke.getCode().equals(KeyCode.LEFT)) {
                    spaceShip.setLayoutX(spaceShip.getLayoutX() - 15);
                    
                }
                if (ke.getCode().equals(KeyCode.SPACE)) {
                    Timer laserTimer = new Timer();
                    laser.setLayoutX(spaceShip.getLayoutX() + 100);
                    laser.setLayoutY(spaceShip.getLayoutY());
                    laser.setVisible(true);
                    laserTimer.schedule(new TimerTask() {
                            public void run() {
                                Platform.runLater(new Runnable() {
                                    public void run() {
                                        laser.setLayoutY(laser.getLayoutY() - 30);
                                        if (laser.getLayoutY() <= 0) {
                                            laserTimer.cancel();
                                            laser.setVisible(false);
                                        }
                                        if (Math.abs(enemyShip.getLayoutX() - laser.getLayoutX()) < 200 
                                                && Math.abs(enemyShip.getLayoutY() - laser.getLayoutY()) < 200) {
                                            enemyThere = false;
                                            score += 10;
                                            scoreLabel.setText(Integer.toString(score));
                                            enemyShip.setVisible(false);
                                            laserTimer.cancel();
                                            laser.setVisible(false);
                                        }
                                    }
                                });
                            }
                        },0,100);
                }
            }
        });
    }


}
