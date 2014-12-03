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
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

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
    
    @FXML
    ImageView shield;
    
    @FXML
    ProgressBar energyBar;
    
    @FXML
    ProgressBar healthBar;
    
    @FXML //fx:id="pirateLaser"
    ImageView pirateLaser;
    
    @FXML //fx:id="pirateShip"
    ImageView pirateShip;
    
    @FXML //fx:id="explosion1"
    ImageView explosion1;
    
    @FXML //fx:id="explosion2"
    ImageView explosion2;
    
    @FXML
    ImageView laserCannon; 
    boolean enemyThere = false;
    boolean left = false;

    
    boolean defeated = false;
    
    int score = 0;
    
    boolean randomEvent = false;

    boolean isDone = false;
    int laserCounter;
    boolean isPirates = false;
    int num = 0;
    static boolean isMoving;
    boolean laserIsMoving;
    static int count;
    static int hits;
    int explosionTimer = 0;
    boolean shieldOn;
    boolean shieldUse;
    Timer enemyTimer;
    int shieldHits;
    boolean shieldBool;
    Timer shieldTimer;
    boolean thing;
    Random rand;
    boolean isMerc;
    MediaPlayer fxPlayer;
    
    @FXML 
    ImageView mercShip;
    
    @FXML
    ImageView mercLaser;

    int mercHits;
    Timer mercTimer;
    Timer mercLaserTimer;
    Random mercRand;
    /**
     * Initializes the controller class.
     */
    @Override
   
    /**
     * Initializes the controller class.
     * This is what happens when the window itself is first initialized
     */
    public void initialize(URL url, ResourceBundle rb) {
        if ( RootLayoutController.getMercLevel() > 0) {
            RootLayoutController.setCredits(RootLayoutController.getCredits() - 100 * RootLayoutController.getMercLevel());
            mercShip.setImage((new Image(this.getClass().getResource("Art/MercShip" + Integer.toString(RootLayoutController.getMercLevel())
        + ".png").toExternalForm())));
            mercShip.setVisible(true);
            mercHits = RootLayoutController.getMercLevel();
            mercTimer = new Timer();
            mercLaserTimer = new Timer();
            mercTimer.schedule(new TimerTask() {
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {
                        if ( enemyThere && mercShip.getLayoutX() > enemyShip.getLayoutX()) {
                            mercShip.setLayoutX(mercShip.getLayoutX() - (RootLayoutController.getMercLevel() *8 ));
                        } else if( enemyThere && mercShip.getLayoutX() < enemyShip.getLayoutX()) {
                            mercShip.setLayoutX(mercShip.getLayoutX() + (RootLayoutController.getMercLevel() *8 ));
                        } else if (thing && mercShip.getLayoutX() > pirateShip.getLayoutX()) {
                            mercShip.setLayoutX(mercShip.getLayoutX() - (RootLayoutController.getMercLevel() *8 ));
                        } else {
                            mercShip.setLayoutX(mercShip.getLayoutX() + (RootLayoutController.getMercLevel() *8 ));

                        }
                  mercLaserTimer = new Timer();
                    mercLaser.setVisible(true);
                    mercLaser.setLayoutX(mercShip.getLayoutX());
                    mercLaser.setLayoutY(mercShip.getLayoutY());
                    if (fxPlayer == null) {
                            fxPlayer = new MediaPlayer(new Media(
                             this.getClass().getResource("Music/laser.wav").toExternalForm()));
                        } else {
                            fxPlayer.stop();
                            fxPlayer = new MediaPlayer(new Media(
                             this.getClass().getResource("Music/laser.wav").toExternalForm()));
                        }
                     mercLaserTimer.schedule(new TimerTask() {
                public void run() {
                    Platform.runLater(new Runnable() {
                        public void run() {
                            mercLaser.setLayoutY(mercLaser.getLayoutY() - 40);
                            if (mercLaser.getLayoutY() <= 0) {
                                mercLaserTimer.cancel();
                                mercLaser.setVisible(false);
                            }
                            if (Math.abs(enemyShip.getLayoutX() - mercLaser.getLayoutX()) < 100 
                                    && Math.abs(enemyShip.getLayoutY() - mercLaser.getLayoutY()) < 50) {
                                enemyThere = false;
                                score += 10;
                                scoreLabel.setText(Integer.toString(score));
                                enemyShip.setVisible(false);
                                enemyShip.setLayoutX(-100);
                                mercLaserTimer.cancel();
                                mercLaser.setVisible(false);
                            }

                            if (Math.abs(pirateShip.getLayoutX() - mercLaser.getLayoutX()) < 200 
                                    && Math.abs(pirateShip.getLayoutY() - mercLaser.getLayoutY()) < 200
                                    && isDone && randomEvent) {
                                    hits++;
                                    mercLaserTimer.cancel();
                                    mercLaser.setVisible(false);

                                }
                            }
                    });
                }
            },0,100);
                        }
                });
            }
        },0,100); 
        
        }
             
        back.setStyle("-fx-background-image: url(" + this.getClass().getResource("Art/starField1.jpg").toExternalForm() +"); -fx-background-size: 2250 100%;");
        shieldOn = false;
        RootLayoutController.setFlyingPoints(0);
        laserCannon.setImage(new Image(this.getClass().getResource("Art/Cannon"
                + Integer.toString(RootLayoutController.getShip().getCurrentLaserLevel())+ ".gif").toExternalForm()));
        shield.setImage(new Image(this.getClass().getResource("Art/Shield"
                + Integer.toString(RootLayoutController.getShip().getCurrentShieldLevel())+ ".png").toExternalForm()));
        spaceShip.setImage(new Image(this.getClass().getResource("Art/PlayerShip" + Integer.toString(RootLayoutController.getShip().getShipLevel())
        + ".gif").toExternalForm()));
        energyBar.setProgress(RootLayoutController.getShip().getCurrentEnergy() / (double) RootLayoutController.getShip().getMaxEnergyBars());
        healthBar.setProgress(RootLayoutController.getShip().getCurrentEnergy() / (double) RootLayoutController.getShip().getMaxEnergyBars());
        RootLayoutController.changeSong(this.getClass().getResource("Music/flying.wav").toExternalForm());
        RandomEncounter checker = new RandomEncounter(RootLayoutController.getPlanet().getName(),RootLayoutController.getToPlanet().getName());
        randomEvent = checker.pirate();
        scoreLabel.setText(Integer.toString(score));
        BorderPane root = MainApp.getRootLayout(); 
        Scene scene = root.getScene();
        rand = new Random();
        Timer gameTimer = new Timer();
            gameTimer.schedule(new TimerTask() {
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {
                        if(randomEvent && thing) {
                            pirates(); 
                            gameTimer.cancel();
                            enemyTimer.cancel();
                            enemyShip.setVisible(false);
                            isDone = true;
                            RootLayoutController.changeSong(this.getClass().getResource("Music/combat.wav").toExternalForm());
                            
                        }
                        if(thing && !randomEvent ) {
                            gameTimer.cancel();
                            enemyTimer.cancel();
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
                            thing = true;
                        
                    
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
                            enemyShip.setLayoutY(-200);
                            enemyShip.setLayoutX(rand.nextInt(1100));
                            enemyShip.setVisible(true);
                            enemyThere = true;
                        }
                        enemyShip.setLayoutY(enemyShip.getLayoutY() + 25);
                        if (enemyThere && shieldOn && Math.abs(enemyShip.getLayoutX() - spaceShip.getLayoutX()) < 150 
                                && Math.abs(enemyShip.getLayoutY() - spaceShip.getLayoutY()) < 50) {
                            shieldHits++;
                            if (shieldHits == RootLayoutController.getShip().getCurrentShieldLevel()) {
                                shieldOn = false; 
                                shield.setVisible(false);
                                shieldTimer.cancel();
                                fxPlayer.stop();
                                fxPlayer = new MediaPlayer(new Media(
                             this.getClass().getResource("Music/shieldbreak.wav").toExternalForm()));
                                fxPlayer.play();
                            }
                            enemyThere = false;
                            enemyShip.setVisible(false);
                        } else if (enemyThere && Math.abs(enemyShip.getLayoutX() - spaceShip.getLayoutX()) < 150 
                                && Math.abs(enemyShip.getLayoutY() - spaceShip.getLayoutY()) < 150) {  
                            RootLayoutController.getShip().setCurrentHealth(RootLayoutController.getShip().getCurrentHealth() - 1);
                            healthBar.setProgress(RootLayoutController.getShip().getCurrentHealth() / (double) RootLayoutController.getShip().getMaxShipHealth());
                            enemyThere = false;
                            enemyShip.setVisible(false);
                            
                            if(RootLayoutController.getShip().getCurrentHealth() == 0) {
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
                        } else if (enemyThere && Math.abs(enemyShip.getLayoutX() - mercShip.getLayoutX()) < 150 
                                && Math.abs(enemyShip.getLayoutY() - mercShip.getLayoutY()) < 150) {
                            mercHits--;
                            enemyThere = false;
                            enemyShip.setVisible(false);
                            if (mercHits == 0) {
                                mercShip.setVisible(false);
                                mercTimer.cancel();
                                
                            }
                        }
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
               if (ke.getCode().equals(KeyCode.O)) {
                   gameTimer.cancel();
                            enemyTimer.cancel();
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
                if (ke.getCode().equals(KeyCode.RIGHT)) {
                    spaceShip.setLayoutX(spaceShip.getLayoutX() + 20);
                    if(shieldOn) {
                        shield.setLayoutX(shield.getLayoutX() + 20);
                    }
                    }
                if (ke.getCode().equals(KeyCode.LEFT)) {
                    spaceShip.setLayoutX(spaceShip.getLayoutX() - 20);
                    if(shieldOn) {
                        shield.setLayoutX(shield.getLayoutX() - 20);
                    }
                    
                }
                if (ke.getCode().equals(KeyCode.C)) {
                   mercLaserTimer = new Timer();
                    mercLaser.setVisible(true);
                    mercLaser.setLayoutX(mercShip.getLayoutX());
                    mercLaser.setLayoutY(mercShip.getLayoutY());
                    if (fxPlayer == null) {
                            fxPlayer = new MediaPlayer(new Media(
                             this.getClass().getResource("Music/laser.wav").toExternalForm()));
                        } else {
                            fxPlayer.stop();
                            fxPlayer = new MediaPlayer(new Media(
                             this.getClass().getResource("Music/laser.wav").toExternalForm()));
                        }
                     mercLaserTimer.schedule(new TimerTask() {
                public void run() {
                    Platform.runLater(new Runnable() {
                        public void run() {
                            mercLaser.setLayoutY(mercLaser.getLayoutY() - 40);
                            if (mercLaser.getLayoutY() <= 0) {
                                mercLaserTimer.cancel();
                                mercLaser.setVisible(false);
                            }
                            if (Math.abs(enemyShip.getLayoutX() - mercLaser.getLayoutX()) < 200 
                                    && Math.abs(enemyShip.getLayoutY() - mercLaser.getLayoutY()) < 200) {
                                enemyThere = false;
                                score += 10;
                                scoreLabel.setText(Integer.toString(score));
                                enemyShip.setVisible(false);
                                enemyShip.setLayoutX(-100);
                                mercLaserTimer.cancel();
                                mercLaser.setVisible(false);
                            }

                            if (Math.abs(pirateShip.getLayoutX() - mercLaser.getLayoutX()) < 200 
                                    && Math.abs(pirateShip.getLayoutY() - mercLaser.getLayoutY()) < 200
                                    && isDone && randomEvent) {
                                    hits++;
                                    mercLaserTimer.cancel();
                                    mercLaser.setVisible(false);

                                }
                            }
                    });
                }
            },0,100);
                }
                if (ke.getCode().equals(KeyCode.Z)) {
                    if (RootLayoutController.getShip().getCurrentEnergy() >= RootLayoutController.getShip().getCurrentShieldLevel()) {
                        RootLayoutController.getShip().setCurrentEnergy(RootLayoutController.getShip().getCurrentEnergy()
                        - RootLayoutController.getShip().getCurrentShieldLevel());
                        energyBar.setProgress(RootLayoutController.getShip().getCurrentEnergy() / (double) RootLayoutController.getShip().getMaxEnergyBars());
                        shield.setVisible(true);
                        shieldBool = false;
                        shield.setLayoutX(spaceShip.getLayoutX());
                        shield.setLayoutY(spaceShip.getLayoutY() + 20);
                        shieldOn = true;
                        shieldHits = 0;
                        shieldTimer = new Timer();
                        if (fxPlayer == null) {
                            fxPlayer = new MediaPlayer(new Media(
                             this.getClass().getResource("Music/shield.wav").toExternalForm()));
                        } else {
                            fxPlayer.stop();
                            fxPlayer = new MediaPlayer(new Media(
                             this.getClass().getResource("Music/shield.wav").toExternalForm()));
                        }
                        fxPlayer.play();
                        shieldTimer.schedule(new TimerTask() {
                            public void run() {
                                    Platform.runLater(new Runnable() {
                                        public void run() {
                                          if (shieldBool) {
                                              shieldOn = false; 
                                              shield.setVisible(false);
                                              shieldTimer.cancel();
                                              fxPlayer.stop();
                            fxPlayer = new MediaPlayer(new Media(
                             this.getClass().getResource("Music/shieldbreak.wav").toExternalForm()));
                            fxPlayer.play();
                                          }
                                          shieldBool = true;

                                        }
                                    });
                                }
                            },0,2000 * RootLayoutController.getShip().getCurrentShieldLevel());
                    }
                }
                if (ke.getCode().equals(KeyCode.X)) {
                    if (RootLayoutController.getShip().getCurrentEnergy() >= RootLayoutController.getShip().getCurrentLaserLevel()) {//*2) {
                        RootLayoutController.getShip().setCurrentEnergy(RootLayoutController.getShip().getCurrentEnergy()
                        - RootLayoutController.getShip().getCurrentLaserLevel());//*2);
                        energyBar.setProgress(RootLayoutController.getShip().getCurrentEnergy() / (double) RootLayoutController.getShip().getMaxEnergyBars());
                        laserCannon.setRotate(-55);
                        laserCannon.setLayoutX(spaceShip.getLayoutX() + 40);
                        left = false;
                        laserCounter = 0;
                        laserCannon.setVisible(true);
                        Timer laserCannonTimer = new Timer();
                        if (fxPlayer == null) {
                            fxPlayer = new MediaPlayer(new Media(
                             this.getClass().getResource("Music/lasercannon.wav").toExternalForm()));
                        } else {
                            fxPlayer.stop();
                            fxPlayer = new MediaPlayer(new Media(
                             this.getClass().getResource("Music/lasercannon.wav").toExternalForm()));
                        }
                        fxPlayer.play();
                        laserCannonTimer.schedule(new TimerTask() {
                            public void run() {
                                    Platform.runLater(new Runnable() {
                                        public void run() {
                                          if(left) {
                                              laserCannon.setRotate(laserCannon.getRotate() -5);
                                              if (laserCannon.getRotate() <= -60) {
                                                  left = false;
                                              }
                                              laserCounter++;
                                        } else {
                                              laserCannon.setRotate(laserCannon.getRotate() + 5);
                                              if ( laserCannon.getRotate() >= 60) {
                                                  left = true;
                                              }
                                              laserCounter++;
                                          }
                                          if (laserCounter >= (24 * RootLayoutController.getShip().getCurrentLaserLevel())) {
                                              laserCannonTimer.cancel();
                                              fxPlayer.stop();
                                              laserCannon.setVisible(false);
                                          }
                                          if (Math.abs(enemyShip.getLayoutX() - laserCannon.getLayoutX() + (41 * laserCannon.getRotate())) < 450 ) {
                                            enemyThere = false;
                                            score += 10;
                                            scoreLabel.setText(Integer.toString(score));
                                            enemyShip.setVisible(false);
                                            enemyShip.setLayoutX(-100);
                                        }
                                        
                                        if (Math.abs(pirateShip.getLayoutX() - laserCannon.getLayoutX()) < 300 
                                                && Math.abs(pirateShip.getLayoutY() - laserCannon.getLayoutY()) < 200
                                                && isDone && randomEvent) {
                                                hits++;
                                            
                                            }
                                        }
                                    });
                                }
                            },0,50);
                    }
                    
                        
                    }
                if (ke.getCode().equals(KeyCode.SPACE)) {
                    Timer laserTimer = new Timer();
                    laser.setLayoutX(spaceShip.getLayoutX() + 70);
                    laser.setLayoutY(spaceShip.getLayoutY());
                    laser.setVisible(true);
                    if (fxPlayer == null) {
                            fxPlayer = new MediaPlayer(new Media(
                             this.getClass().getResource("Music/laser.wav").toExternalForm()));
                        } else {
                            fxPlayer.stop();
                            fxPlayer = new MediaPlayer(new Media(
                             this.getClass().getResource("Music/laser.wav").toExternalForm()));
                        }
                        fxPlayer.play();
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
                            if (laserIsMoving && shieldOn && Math.abs(pirateLaser.getLayoutX() - spaceShip.getLayoutX()) < 150 
                                    && Math.abs(pirateLaser.getLayoutY() - spaceShip.getLayoutY()) < 150) {
                                shieldHits++;
                            if (shieldHits == RootLayoutController.getShip().getCurrentShieldLevel()) {
                                shieldOn = false; 
                                shield.setVisible(false);
                                shieldTimer.cancel();
                                fxPlayer.stop();
                                fxPlayer = new MediaPlayer(new Media(
                             this.getClass().getResource("Music/shieldbreak.wav").toExternalForm()));
                                fxPlayer.play();
                            }
                            laserIsMoving = false;
                                pirateLaser.setVisible(false);
                            
                            }
                            else if (laserIsMoving && Math.abs(pirateLaser.getLayoutX() - spaceShip.getLayoutX()) < 150 
                                    && Math.abs(pirateLaser.getLayoutY() - spaceShip.getLayoutY()) < 150) {
                                
                                RootLayoutController.getShip().setCurrentHealth(RootLayoutController.getShip().getCurrentHealth() - 1);
                                healthBar.setProgress(RootLayoutController.getShip().getCurrentHealth() / (double) RootLayoutController.getShip().getMaxShipHealth());
                                if (RootLayoutController.getShip().getCurrentHealth() == 0) {
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
                                    hits = 0;
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
