/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Space.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Keanu
 */
public class RootLayoutController implements Initializable {
    private static int pilotSkill;
    private static int charismaSkill;
    private static int engineeringSkill;
    private static int luckSkill;
    private static int skillPoints; 
    private static String name; 

    public static int getPilotSkill() {
        return pilotSkill;
    }
    
    @FXML private void exit() {
        System.exit(0);
    }

    public static int getCharismaSkill() {
        return charismaSkill;
    }

    public static int getEngineeringSkill() {
        return engineeringSkill;
    }

    public static int getLuckSkill() {
        return luckSkill;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pilotSkill = 5;
        charismaSkill = 5;
        engineeringSkill = 5;
        luckSkill = 5;
        skillPoints = 5;
        name = "";
    }    

    public static int getSkillPoints() {
        return skillPoints;
    }

    public static String getName() {
        return name;
    }

    public static void setRemainingSkillPoints(int skillPoints) {
        RootLayoutController.skillPoints = skillPoints;
    }

    public static void setName(String name) {
        RootLayoutController.name = name;
    }

    public static void setPilotSkill(int pilotSkill) {
        RootLayoutController.pilotSkill = pilotSkill;
    }

    public static void setCharismaSkill(int charismaSkill) {
        RootLayoutController.charismaSkill = charismaSkill;
    }

    public static void setEngineeringSkill(int engineeringSkill) {
        RootLayoutController.engineeringSkill = engineeringSkill;
    }

    public static void setLuckSkill(int luckSkill) {
        RootLayoutController.luckSkill = luckSkill;
    }
    
        
    
}
