/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Space.controller;

import Space.MainApp;
import Space.POJO.Planet;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Keanu
 */
public class FeroxShipyardController extends playerAreaController implements Initializable {

    @FXML
    Pane background;
    
    @FXML //fx:="portal1"
    ImageView portal1;

    @FXML //fx:id="portal2"
    ImageView portal2;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         init();
        background.setStyle("-fx-background-image: url(" +this.getClass().getResource("Art/.png").toExternalForm() +"); -fx-background-size: 100% 100%;");
        if (RootLayoutController.getOrientation() == 0) {
                    RootLayoutController.changeSong(this.getClass().getResource("Music/cowboy ground.wav").toExternalForm());

        }
        Planet p = RootLayoutController.getUniverse().getFromName("Zoness");
        RootLayoutController.setPlanetLocation(p);
        BorderPane root = MainApp.getRootLayout();
        Scene scene = root.getScene();
        // Key event handling
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (ke.getCode().equals(KeyCode.RIGHT)) {
                    protag.setImage(new Image(this.getClass().getResource("Art/YuRight.png").toExternalForm()));
                    protag.setLayoutX(protag.getLayoutX() +8);

                    }
                if (ke.getCode().equals(KeyCode.LEFT)) {
                    protag.setImage(new Image(this.getClass().getResource("Art/YuLeft.png").toExternalForm()));
                    protag.setLayoutX(protag.getLayoutX() - 8);
                }
                if (ke.getCode().equals(KeyCode.SPACE) && Math.abs(protag.getLayoutX() - portal1.getLayoutX()) < 50 ) {
                    try {
                    // Load person overview.
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(MainApp.class.getResource(
                            "view/ZonessMarket.fxml"));
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
                            "view/ZonessShipyard.fxml");
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
    }    
        });
                }
}
    

