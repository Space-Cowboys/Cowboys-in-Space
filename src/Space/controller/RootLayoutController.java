/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Space.controller;

import Space.POJO.*;
import Space.Player;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
/**
 * 
 * FXML Controller class
 *
 * @author Keanu
 */
public class RootLayoutController implements Initializable {
    private static Player player; 
    private static Universe u;
    private static Planet planet;
    private static Inventory inventory;
    private static int credits;
    private static int fuel;
    private static MediaPlayer mediaPlayer; 
    private static int orientation; // must be either 0 or 1
    //0 for left side of screen/1 for right
    
    public static int getFuel() {
        return fuel;
    }
    
    public static void setFuel(int newFuel) {
        fuel = newFuel;
    }
    
    public static void setPlanetLocation(Planet p) {
        planet = p;
    }
    
    public static int getOrientation() {
        return orientation;
    }
    
    public static void setOrientation(int i) {
        orientation = i; 
    }
    public static Inventory getInventory() {
        return inventory;
    }

    
    public static int getPilotSkill() {
        return player.getPilot();
    }

    public static Planet getPlanet() {
        return planet;
    }
    
    @FXML private void exit() {
        System.exit(0);
    }

    public static int getCharismaSkill() {
        return player.getCharisma();
    }

    public static int getEngineeringSkill() {
        return player.getEngineering();
    }

    public static int getLuckSkill() {
        return player.getLuck();
    }
    
    
    public static void changeSong(String filename) {
        mediaPlayer.stop();
        mediaPlayer = new MediaPlayer(new Media(new File(filename).toURI().toString()));
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        player = new Player();
        u = new Universe();
        inventory = new Inventory(10);
        credits = 1000;
        fuel = 400;
        mediaPlayer = new MediaPlayer(new Media(new File("src/Space/Music/title.wav").toURI().toString()));
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }    

    public static Universe getUniverse() {
        return u;
    } 
    public static int getCredits() {
        return credits;
    }
    public static void setCredits(int amount) {
        credits = amount;
    }
    
    public static int getSkillPoints() {
        return player.getSkillPointsRemaining();
    }

    public static String getName() {
        return player.getName();
    }

    public static void setRemainingSkillPoints(int skillPoints) {
        player.setSkillPointsRemaining(skillPoints);
    }

    public static void setName(String name) {
        player.setName(name);
    }

    public static void setPilotSkill(int pilotSkill) {
        player.setPilot(pilotSkill);
    }

    public static void setCharismaSkill(int charismaSkill) {
        player.setCharisma(charismaSkill);
    }

    public static void setEngineeringSkill(int engineeringSkill) {
        player.setEngineering(engineeringSkill);
    }

    public static void setLuckSkill(int luckSkill) {
        player.setLuck(luckSkill);
    }
    
        
    
}
