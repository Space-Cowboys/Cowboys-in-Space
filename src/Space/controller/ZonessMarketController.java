/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Space.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Keanu
 */
public class ZonessMarketController extends EmptyMarketController implements Initializable  {
   
    /**
     * Initializes the controller class.
     * This is what happens when the window itself is first initialized
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        init("Zoness");
    }
}