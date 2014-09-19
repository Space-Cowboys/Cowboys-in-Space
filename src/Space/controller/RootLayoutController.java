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
import spacecowboys.Universe;
/**
 * 
 * FXML Controller class
 *
 * @author Keanu
 */
public class RootLayoutController implements Initializable {
    private static Player player; 
 

    public static int getPilotSkill() {
        return player.getPilot();
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
        Universe u = new Universe(26);
        for (int i = 0; i < u.getPlanets().length; i++){
            System.out.println(u.getPlanets()[i]);
        }
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
