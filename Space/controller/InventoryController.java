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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Keanu
 */
public class InventoryController implements Initializable {
    
    @FXML //fx:id="statusPane"
    AnchorPane statusPane;
    
    @FXML //fx:id="healthBar"
    ProgressBar healthBar; 
    
    @FXML //:fx:id="healthLabel"
    Label healthLabel;
    
    @FXML //fx:id="nameLabel"
    Label nameLabel;
    
    @FXML //fx:id="levelLabel"
    Label levelLabel;
    
    @FXML //fx:id="pilSkill"
    Label pilSkill;
    
    @FXML //fx:id="engSkill"
    Label engSkill;
    
    @FXML //fx:id="chaSkill"
    Label chaSkill;
    
    @FXML //fx:id="lukSkill"
    Label lukSkill;
    
    @FXML //fx:id="creditsLabel"
    Label creditsLabel; 
    
    @FXML //fx:id="pilBar"
    ProgressBar pilBar;
           
    @FXML //fx:id="engBar"
    ProgressBar engBar;
    
    @FXML //fx:id="chaBar"
    ProgressBar chaBar;
    
    @FXML //fx:id="lukBar"
    ProgressBar lukBar;
    
    @FXML //fx:id="inventoryPane"
    AnchorPane inventoryPane;
    
    
    @FXML //fx:id="waterLabel"
    Label waterLabel;
    
    @FXML //fx:id="furLabel"
    Label furLabel;
    
    @FXML //fx:id="foodLabel"
    Label foodLabel;
    
    @FXML //fx:id="oreLabel"
    Label oreLabel;
    
    @FXML //fx:id="gamesLabel"
    Label gamesLabel;
    
    @FXML //fx:id="firearmsLabel"
    Label firearmsLabel;
    
    @FXML //fx:id="medicineLabel"
    Label medicineLabel;
    
    @FXML //fx:id="robotsLabel"
    Label robotsLabel;
    
    @FXML //fx:id="machinesLabel"
    Label machinesLabel;
    
    @FXML //fx:id="narcoticsLabel"
    Label narcoticsLabel;
    
    @FXML //fx:id="pilBar2"
    ProgressBar pilBar2;
    
    @FXML //fx:id="engBar2"
    ProgressBar engBar2;
    
    @FXML //fx:id="chaBar2"
    ProgressBar chaBar2;
    
    @FXML //fx:id="lukBar2"
    ProgressBar lukBar2;
    
    @FXML //fx:id="pilLabel2"
    Label pilLabel2;
    
    @FXML //fx:id="engLabel2"
    Label engLabel2;
    
    @FXML //fx:id="chaLabel2"
    Label chaLabel2;
    
    @FXML //fx:id="lukLabel2"
    Label lukLabel2;
    
    @FXML //fx:id="pointsRemaining"
    Label pointsRemaining;
    
    @FXML //fx:id="skillPane"
    AnchorPane skillPane;
    
    @FXML //fx:id="savePane"
    AnchorPane savePane;
    
    @FXML //fx:id="fuelLabel"
    Label fuelLabel;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int[] quantity = RootLayoutController.getInventory().quantityCount();
        nameLabel.setText(RootLayoutController.getName());
        levelLabel.setText(Integer.toString(1));
        healthBar.setProgress(1); 
        healthLabel.setText("100");
        pilSkill.setText(Integer.toString(RootLayoutController.getPilotSkill()));
        pilLabel2.setText(Integer.toString(RootLayoutController.getPilotSkill()));
        engSkill.setText(Integer.toString(RootLayoutController.getEngineeringSkill()));
        engLabel2.setText(Integer.toString(RootLayoutController.getEngineeringSkill()));
        chaSkill.setText(Integer.toString(RootLayoutController.getCharismaSkill()));
        chaLabel2.setText(Integer.toString(RootLayoutController.getCharismaSkill()));
        lukSkill.setText(Integer.toString(RootLayoutController.getLuckSkill()));
        lukLabel2.setText(Integer.toString(RootLayoutController.getLuckSkill()));
        pilBar.setProgress(RootLayoutController.getPilotSkill() / 100.0);
        pilBar2.setProgress(RootLayoutController.getPilotSkill() / 100.0);
        engBar.setProgress(RootLayoutController.getEngineeringSkill() / 100.0);
        engBar2.setProgress(RootLayoutController.getEngineeringSkill() / 100.0);
        chaBar.setProgress(RootLayoutController.getCharismaSkill() / 100.0);
        chaBar2.setProgress(RootLayoutController.getCharismaSkill() / 100.0);
        lukBar.setProgress(RootLayoutController.getLuckSkill() / 100.0);
        lukBar2.setProgress(RootLayoutController.getLuckSkill() / 100.0);
        creditsLabel.setText(Integer.toString(RootLayoutController.getCredits()));
        fuelLabel.setText(Integer.toString(RootLayoutController.getFuel()));
        waterLabel.setText(Integer.toString(quantity[0]));
        furLabel.setText(Integer.toString(quantity[1]));
        foodLabel.setText(Integer.toString(quantity[2]));
        oreLabel.setText(Integer.toString(quantity[3]));
        gamesLabel.setText(Integer.toString(quantity[4]));
        firearmsLabel.setText(Integer.toString(quantity[5]));
        medicineLabel.setText(Integer.toString(quantity[6]));
        machinesLabel.setText(Integer.toString(quantity[7]));
        narcoticsLabel.setText(Integer.toString(quantity[8]));
        robotsLabel.setText(Integer.toString(quantity[9]));
    }    
    
    public void showStatus() {
        statusPane.setVisible(true);
        inventoryPane.setVisible(false);
        skillPane.setVisible(false);
        savePane.setVisible(false);
    }
    
    public void showInventory() {
        statusPane.setVisible(false);
        inventoryPane.setVisible(true);
        skillPane.setVisible(false);
        savePane.setVisible(false);
    }
    
    public void showSkills() {
        statusPane.setVisible(false);
        inventoryPane.setVisible(false);
        skillPane.setVisible(true);
        savePane.setVisible(false);
    }
    
    public void showSave() {
        statusPane.setVisible(false);
        inventoryPane.setVisible(false);
        skillPane.setVisible(false);
        savePane.setVisible(true);
        RootLayoutController.save();
    }
    
    public void exit() {
        try {
            // Load person overview. 
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(RootLayoutController.getLocation()));
            Pane characterCreation = (Pane) loader.load();
            BorderPane rootLayout = MainApp.getRootLayout(); 
            rootLayout.setCenter(characterCreation);

        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
}
