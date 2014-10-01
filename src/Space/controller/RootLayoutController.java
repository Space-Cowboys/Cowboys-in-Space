/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Space.controller;

import Space.Player;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import Space.POJO.*;
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
    
    
    public static void setPlanetLocation(Planet p) {
        planet = p;
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


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        player = new Player();
        u = new Universe();
        inventory = new Inventory(10);
        credits = 1000;
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
