/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Space.controller;

import Space.MainApp;
import Space.POJO.RandomEncounter;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
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
    
    @FXML //fx:id="pirateLaser"
    ImageView pirateLaser;
    
    @FXML //fx:id="pirateShip"
    ImageView pirateShip;
    
    @FXML //fx:id="explosion1"
    ImageView explosion1;
    
    @FXML //fx:id="explosion2"
    ImageView explosion2;
    boolean enemyThere = false;
    
    boolean defeated = false;
    
    int score = 0;
    
    boolean randomEvent = false;

    boolean isDone = false;
    
    boolean isPirates = false;
    int num = 0;
    static boolean isMoving;
    boolean laserIsMoving;
    static int count;
    static int hits;
    int explosionTimer = 0;
    Timer enemyTimer;


    /**
     * Initializes the controller class.
     */
    @Override
   
    /**
     * Initializes the controller class.
     * This is what happens when the window itself is first initialized
     */
    public void initialize(URL url, ResourceBundle rb) {
        RootLayoutController.setFlyingPoints(0);
        RandomEncounter checker = new RandomEncounter(RootLayoutController.getPlanet().getName(),RootLayoutController.getToPlanet().getName());
        randomEvent = checker.pirate();
        scoreLabel.setText(Integer.toString(score));
        BorderPane root = MainApp.getRootLayout(); 
        Scene scene = root.getScene();
        Random rand = new Random();
        
        Timer gameTimer = new Timer();
            gameTimer.schedule(new TimerTask() {
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {
                        if(randomEvent && isDone) {
                            pirates(); 
                            gameTimer.cancel();
                            enemyTimer.cancel();
                            enemyShip.setVisible(false);
                            
                        }
                        if(isDone && !randomEvent ) {
                            try {
                                // Load person overview. 
                                RootLayoutController.setFlyingPoints(score);
                                FXMLLoader loader = new FXMLLoader();
                                loader.setLocation(MainApp.class.getResource("view/MissionComplete.fxml"));
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
        
         enemyTimer = new Timer();
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
                        if (Math.abs(enemyShip.getLayoutX() - spaceShip.getLayoutX()) < 150 
                                && Math.abs(enemyShip.getLayoutY() - spaceShip.getLayoutY()) < 150) {                            
                            enemyTimer.cancel();
                            gameTimer.cancel(); 
                            
                            try {
                                // Load person overview. 
                                FXMLLoader loader = new FXMLLoader();
                                loader.setLocation(MainApp.class.getResource("view/ShipDeath.fxml"));
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
                    laser.setLayoutX(spaceShip.getLayoutX() + 70);
                    laser.setLayoutY(spaceShip.getLayoutY());
                    laser.setVisible(true);
                    laserTimer.schedule(new TimerTask() {
                            public void run() {
                                Platform.runLater(new Runnable() {
                                    public void run() {
                                        laser.setLayoutY(laser.getLayoutY() - 40);
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
                                            enemyShip.setLayoutX(-100);
                                            laserTimer.cancel();
                                            laser.setVisible(false);
                                        }
                                        
                                        if (Math.abs(pirateShip.getLayoutX() - laser.getLayoutX()) < 200 
                                                && Math.abs(pirateShip.getLayoutY() - laser.getLayoutY()) < 200
                                                && isDone && randomEvent) {
                                                hits++;
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
    
    public void pirates() {
        pirateShip.setVisible(true);
        Random rand = new Random();
        Timer pirateTimer = new Timer();
        pirateTimer.schedule(new TimerTask() {
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {
                        if(!defeated) {
                            if (!isMoving) {
                                num = rand.nextInt(2);
                                count = 0;
                                isMoving = true;
                            }
                            if (num == 0) {
                                if(pirateShip.getLayoutX() > 50) {
                                    pirateShip.setLayoutX(pirateShip.getLayoutX() - 8);
                                }
                                count++;
                            } else {
                                if (pirateShip.getLayoutX() < 1000) {
                                    pirateShip.setLayoutX(pirateShip.getLayoutX() + 8);
                                }
                                count++;
                            }
                            if (count > 5) {
                                isMoving = false;
                                if (!laserIsMoving) {
                                    pirateLaser.setVisible(true);
                                    pirateLaser.setLayoutX(pirateShip.getLayoutX() + 100);
                                    pirateLaser.setLayoutY(100);
                                    laserIsMoving = true;
                                }
                            }
                            pirateLaser.setLayoutY(pirateLaser.getLayoutY() + 12);

                            if (pirateLaser.getLayoutY() > 800) {
                                laserIsMoving = false;
                                pirateLaser.setVisible(false);
                            }
                            if (Math.abs(pirateLaser.getLayoutX() - spaceShip.getLayoutX()) < 150 
                                    && Math.abs(pirateLaser.getLayoutY() - spaceShip.getLayoutY()) < 150) {
                                pirateTimer.cancel();
                                try {
                                    // Load person overview. 
                                    FXMLLoader loader = new FXMLLoader();
                                    loader.setLocation(MainApp.class.getResource("view/ShipDeath.fxml"));
                                    Pane characterCreation = (Pane) loader.load();
                                    BorderPane rootLayout = MainApp.getRootLayout(); 
                                    rootLayout.setCenter(characterCreation);

                                } catch (IOException e) {
                                    e.printStackTrace();
                                } 
                            }
                        }
                            if (hits > 6) {
                                defeated = true; 
                                explosion1.setVisible(true);
                                explosion1.setLayoutX(pirateShip.getLayoutX() + 10);
                                explosion1.setLayoutY(pirateShip.getLayoutY() + 10);
                                explosion2.setVisible(true);
                                explosion2.setLayoutX(pirateShip.getLayoutX() + 200);
                                explosion2.setLayoutY(pirateShip.getLayoutY() + 10);
                                explosionTimer++;
                                if(explosionTimer > 15) {
                                    pirateTimer.cancel();
                                    score += 200;
                                    try {
                                        // Load person overview. 
                                        RootLayoutController.setFlyingPoints(score);
                                        FXMLLoader loader = new FXMLLoader();
                                        loader.setLocation(MainApp.class.getResource("view/MissionComplete.fxml"));
                                        Pane characterCreation = (Pane) loader.load();
                                        BorderPane rootLayout = MainApp.getRootLayout(); 
                                        rootLayout.setCenter(characterCreation);

                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    } 
                                }
                            }
                    
                }
                });
            }
        },0,100);
        
        
    }


}
