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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Keanu
 */
public class RushGalaxyController implements Initializable {

    @FXML //fx:id="Aurum"
    ImageView Aurum;
    
    @FXML //fx:id="Zoness"
    ImageView Zoness; 
    
    @FXML //fx:id="wormhole"
    ImageView wormhole;
    
    @FXML //fx:id="wormLabel1"
    Text wormLabel1;
    
    @FXML //fx:id="wormLabel2"
    Text wormLabel2;
    
    @FXML //fx:id="AurumInfo"
    AnchorPane AurumInfo;
    
    @FXML //fx:id="ZonessInfo"
    AnchorPane ZonessInfo;
    
    @FXML //fx:id="zonessArrow"
    ImageView zonessArrow;
    
    @FXML //fx:id="aurumArrow"
    ImageView aurumArrow;
    
    @FXML //fx:id="fuelRem"
    Label fuelRem;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fuelRem.setText(Integer.toString(RootLayoutController.getFuel()));
        RootLayoutController.changeSong("src/Space/Music/planetSelection.wav");
        if (RootLayoutController.getPlanet().getName().equals("Aurum")) {
            zonessArrow.setVisible(false);
            aurumArrow.setVisible(true);
        }
        if (RootLayoutController.getPlanet().getName().equals("Zoness")) {
            zonessArrow.setVisible(true);
            aurumArrow.setVisible(false);
        }
    }    
    
    public void mouseOverAurum() {
        AurumInfo.setVisible(true); 
    }
    
    public void mouseLeaveAurum() {
        AurumInfo.setVisible(false);
    }
    
    public void mouseOverZoness() {
        ZonessInfo.setVisible(true); 
    }
    
    public void mouseLeaveZoness() {
        ZonessInfo.setVisible(false);
    }
    
    public void mouseOverWorm() {
        wormLabel1.setVisible(true);
        wormLabel2.setVisible(true);
    }
    
    public void mouseLeaveWorm() {
        wormLabel1.setVisible(false);
        wormLabel2.setVisible(false);   
    }
    public void goToAurum() {
        if (RootLayoutController.getPlanet() != null && RootLayoutController.getPlanet().getName().equals("Aurum")) {
            try {
	        // Load person overview. 
                RootLayoutController.setOrientation(0);
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(MainApp.class.getResource("view/AurumShipyard.fxml"));
                Pane characterCreation = (Pane) loader.load();
                BorderPane rootLayout = MainApp.getRootLayout(); 
                rootLayout.setCenter(characterCreation);
                
	    } catch (IOException e) {
	        e.printStackTrace();
	    } 
        } else if (RootLayoutController.getFuel() > 130) {
            try {
	        // Load person overview. 
                RootLayoutController.setOrientation(0);
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(MainApp.class.getResource("view/AurumShipyard.fxml"));
                Pane characterCreation = (Pane) loader.load();
                BorderPane rootLayout = MainApp.getRootLayout(); 
                rootLayout.setCenter(characterCreation);
                RootLayoutController.setFuel(RootLayoutController.getFuel() - 130);
                
	    } catch (IOException e) {
	        e.printStackTrace();
	    } 
	} else {
            System.out.println("Whoops, can't do that");
        }
    }
    
    public void goToZoness() {
        if (RootLayoutController.getPlanet() != null && RootLayoutController.getPlanet().getName().equals("Zoness")) {
            try {
	        // Load person overview. 
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(MainApp.class.getResource("view/ZonessMarket.fxml"));
                Pane characterCreation = (Pane) loader.load();
                BorderPane rootLayout = MainApp.getRootLayout(); 
                rootLayout.setCenter(characterCreation);
                
	    } catch (IOException e) {
	        e.printStackTrace();
	    } 
	} else if (RootLayoutController.getFuel() > 130) {
            try {
	        // Load person overview. 
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(MainApp.class.getResource("view/ZonessMarket.fxml"));
                Pane characterCreation = (Pane) loader.load();
                BorderPane rootLayout = MainApp.getRootLayout(); 
                rootLayout.setCenter(characterCreation);
                RootLayoutController.setFuel(RootLayoutController.getFuel() - 130);
                
	    } catch (IOException e) {
	        e.printStackTrace();
	    } 
	} else {
            System.out.println("Whoops, can't do that");
        }
    }
}
    

