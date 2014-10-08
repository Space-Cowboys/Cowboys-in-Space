/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Space.controller;

import Space.MainApp;
import Space.POJO.Good;
import Space.POJO.Good.Goods;
import Space.POJO.Inventory;
import Space.POJO.MarketItem;
import Space.POJO.Planet;
import Space.POJO.Planet.GoodTracker;
import Space.POJO.PriceModel;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import java.util.Timer;

/**
 * FXML Controller class
 *
 * @author Keanu
 */
public class AurumMarketController implements Initializable {
    @FXML //fx:id="protag"
    ImageView protag; 
    
    @FXML //fx:id="shop"
    ImageView shop;
    
    @FXML //fx:id="shopWindow"
    SplitPane shopWindow;
    
    @FXML //fx:id="shopWindowAnchor"
    AnchorPane shopWindowAnchor;
    
    @FXML //fx:id="shopWindowAnchor2"
    AnchorPane shopWindowAnchor2;
   
    @FXML //fx:id="shopLabel1"
    Label shopLabel1;
    
    @FXML //fx:id="shopLabel2"
    Label shopLabel2;
    
    @FXML //fx:id="shopLabel3"
    Label shopLabel3;
    
    @FXML //fx:id="shopLabel4"
    Label shopLabel4;
    
    @FXML //fx:id="shopLabel5"
    Label shopLabel5;
    
    @FXML //fx:id="shopLabel6"
    Label shopLabel6;
    
    @FXML //fx:id="priceLabel1"
    Label priceLabel1;
    
    @FXML //fx:id="priceLabel2"
    Label priceLabel2;
    
    @FXML //fx:id="priceLabel3"
    Label priceLabel3;

    @FXML //fx:id="priceLabel4"
    Label priceLabel4;
    
    @FXML //fx:id="priceLabel5"
    Label priceLabel5;

    @FXML //fx:id="priceLabel6"
    Label priceLabel6;
    
    @FXML //fx:id="inventory"
    ScrollPane inventory; 
    
    @FXML //fx:id="inventory1"
    AnchorPane inventory1; 
    
    @FXML //fx:id="buyWindowTitleLabel"
    Label buyWindowTitleLabel;
    
    @FXML //fx:id="buyWindowQuantityLabel"
    Label buyWindowQuantityLabel;
    
    @FXML //fx:id="buyWindowPriceLabel"
    Label buyWindowPriceLabel; 
    
    @FXML //fx:id="sellWindowTitleLabel"
    Label sellWindowTitleLabel;
    
    @FXML //fx:id="sellWindowQuantityLabel"
    Label sellWindowQuantityLabel;
    
    @FXML //fx:id="sellWindowPriceLabel"
    Label sellWindowPriceLabel; 
    
    @FXML //fx:id="creditsAmount"
    Label creditsAmount;
    
    @FXML //fx:id="PInv1"
    Label PInv1;
    
    @FXML //fx:id="PInv2"
    Label PInv2;
    
    @FXML //fx:id="PInv3"
    Label PInv3;
    
    @FXML //fx:id="PInv4"
    Label PInv4;
    
    @FXML //fx:id="PInv5"
    Label PInv5;
    
    @FXML //fx:id="PInv6"
    Label PInv6;
    
    @FXML //fx:id="PInv7"
    Label PInv7;
    
    @FXML //fx:id="PInv8"
    Label PInv8;
    
    @FXML //fx:id="PInv9"
    Label PInv9;
    
    @FXML //fx:id="PInv10"
    Label PInv10;

    @FXML //fx:id="PQInv1"
    Label PQInv1;
    
    @FXML //fx:id="PQInv2"
    Label PQInv2;
    
    @FXML //fx:id="PQInv3"
    Label PQInv3;
    
    @FXML //fx:id="PQInv4"
    Label PQInv4;
    
    @FXML //fx:id="PQInv5"
    Label PQInv5;
    
    @FXML //fx:id="PQInv6"
    Label PQInv6;
    
    @FXML //fx:id="PQInv7"
    Label PQInv7;
    
    @FXML //fx:id="PQInv8"
    Label PQInv8;
    
    @FXML //fx:id="PQInv9"
    Label PQInv9;
    
    @FXML //fx:id="PQInv10"
    Label PQInv10;
    
    @FXML //fx:id="creditsLabel"
    Label creditsLabel;
    
    @FXML //fx:id="buyWindow"
    AnchorPane buyWindow;
    
    @FXML //fx:id="sellWindow"
    AnchorPane sellWindow;
    
    @FXML //fx:id="messageWindow"
    AnchorPane messageWindow;
    
    int quantity = 1;
    int price1;
    int price2;
    int price3;
    int price4;
    /* price of good before quantity */
    int preMultiplier;
    PriceModel aurumModel;
    MarketItem buyable; 
    MarketItem sellable;
    Goods[] genericList;
    Inventory pInventory;
    int sellablePrice;
    int buyablePrice;
    Label[] labels = new Label[10];
    GoodTracker[] goods;
    GoodTracker[] playerGoods;
    Timer timer;
    @FXML //fx:id="back"
    AnchorPane back;
    
    Boolean isJumping = false;
    
    @FXML //fx:id="protagL"
    ImageView protagL;
    
    @FXML //fx:id="protagR"
    ImageView protagR;
    
    @FXML //fx:id="shopContainer"
    AnchorPane shopContainer;
    
    @FXML //fx:id="spacePortal"
    ImageView spacePortal;
    
    int salePrice1;
    int salePrice2;
    int salePrice3;
    int salePrice4;
    int salePrice5;
    int salePrice6;
    int salePrice7;
    int salePrice8;
    int salePrice9;
    int salePrice10;

    /**
     * Initializes the controller class.
     * This is what happens when the window itself is first initialized
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        timer = new Timer(); 
        creditsLabel.setText(Integer.toString(RootLayoutController.getCredits()));
        Planet p = RootLayoutController.getUniverse().getFromName("Aurum");
        pInventory = RootLayoutController.getInventory();
        playerGoods = p.getPlayerGT();
        Label[] listO = {PQInv1,PQInv2,PQInv3,PQInv4,PQInv5,PQInv6,PQInv7,PQInv8,PQInv9,PQInv10};
        for(int i=0;i <labels.length;i++) {
            labels[i] = listO[i]; 
        }
        RootLayoutController.setPlanetLocation(p);
        goods = RootLayoutController.getPlanet().getGT();
        genericList = RootLayoutController.getPlanet().getGoodsList();
        updatePInv();
        aurumModel = new PriceModel(p);
        BorderPane root = MainApp.getRootLayout(); 
        Scene scene = root.getScene();
        //Shop inventory set
        shopLabel1.setText(goods[0].getType().toString());
        shopLabel2.setText(goods[1].getType().toString());
        shopLabel3.setText(goods[2].getType().toString());
        shopLabel4.setText(goods[3].getType().toString());
        //Prices for shop inventory set
        price1 = aurumModel.showPrice(goods[0].getType());
        price2 = aurumModel.showPrice(goods[1].getType());
        price3 = aurumModel.showPrice(goods[2].getType());
        price4 = aurumModel.showPrice(goods[3].getType());
        priceLabel1.setText(Integer.toString(price1));
        priceLabel2.setText(Integer.toString(price2));
        priceLabel3.setText(Integer.toString(price3));
        priceLabel4.setText(Integer.toString(price4));
         // sale prices
        salePrice1 = aurumModel.showSalePrice(genericList[0]);
        salePrice2 = aurumModel.showSalePrice(genericList[1]);
        salePrice3 = aurumModel.showSalePrice(genericList[2]);
        salePrice4 = aurumModel.showSalePrice(genericList[3]);
        salePrice5 = aurumModel.showSalePrice(genericList[4]);
        salePrice6 = aurumModel.showSalePrice(genericList[5]);
        salePrice7 = aurumModel.showSalePrice(genericList[6]);
        salePrice8 = aurumModel.showSalePrice(genericList[7]);
        salePrice9 = aurumModel.showSalePrice(genericList[8]);
        salePrice10 = aurumModel.showSalePrice(genericList[9]);

        // Key event handling
scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (ke.getCode().equals(KeyCode.DOWN)) {
                    protag.setLayoutY(protag.getLayoutY()+5);
                    System.out.println(protag.getLayoutX());
                    
                }
                if (ke.getCode().equals(KeyCode.RIGHT)) {
                    protag.setImage(protagR.getImage());
                    protag.setLayoutX(protag.getLayoutX() +8);
                    if(protag.getLayoutX() > 500 && protag.getLayoutX() < 1300) {
                        back.setTranslateX(back.getTranslateX() - 8);
                    }
                    }
                if (ke.getCode().equals(KeyCode.LEFT)) {
                    protag.setImage(protagL.getImage());
                    protag.setLayoutX(protag.getLayoutX() - 8);
                    if(protag.getLayoutX() > 500 && protag.getLayoutX() < 1300) {
                        back.setTranslateX(back.getTranslateX() + 8);
                    }
                    
                }
                if (ke.getCode().equals(KeyCode.UP)) {
                    if (isJumping == false) {
                        protag.setLayoutY(protag.getLayoutY() - 50);
                        isJumping = true;
                    
                   timer.schedule(new TimerTask() {
                    public void run() {
                    Platform.runLater(new Runnable() {
                    public void run() {
                        protag.setLayoutY(protag.getLayoutY() + 50);
                        isJumping = false;

                    }
                });
            }
        }, 750);}
               }
               if (ke.getCode().equals(KeyCode.SPACE) && Math.abs(shop.getLayoutX() - protag.getLayoutX()) < 80) {
                    shopWindowAnchor.setVisible(true);
                    shopWindowAnchor2.setVisible(true);
                    inventory.setVisible(true);
                    inventory1.setVisible(true);
                    messageWindow.setVisible(true);
                    shopContainer.setVisible(true);

                } 
               if (ke.getCode().equals(KeyCode.SPACE) && Math.abs(spacePortal.getLayoutX() - protag.getLayoutX()) < 80) {
                   try {
	        // Load person overview. 
                RootLayoutController.setOrientation(1);
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(MainApp.class.getResource("view/AurumShipyard.fxml"));
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
    /*
    * This updates all the player labels
    */
    private void updatePInv() {
        MarketItem[] marketItemList = new MarketItem[10];
        for(int i = 0; i < genericList.length;i++) {
            marketItemList[i] = new MarketItem(genericList[i],0,99); 
        }
        
        for(int i = 0; i < labels.length;i++) {
            boolean a = false;
            labels[i].setText(Integer.toString(pInventory.totalItemCount(marketItemList[i])));
            for(int j = 0; j < 6; j++) {
                if(marketItemList[i].equals(new Good(playerGoods[j].getType(),0,99))) {
                    a = true;
                }
                if(a) {
                    labels[i].setTextFill(Color.BLACK);
                }
            
            }
        }
    }
    //The next four methods set their respective buy windows
    public void buy1() {
        messageWindow.setVisible(false);
        sellWindow.setVisible(false);
        buyWindow.setVisible(true);
        buyWindowTitleLabel.setText(shopLabel1.getText());
        buyWindowQuantityLabel.setText(Integer.toString(quantity));
        preMultiplier =  price1;
        buyWindowPriceLabel.setText(Integer.toString(preMultiplier));    
        buyable = new MarketItem(goods[0].getType(),quantity,99); 
        
    }
    
    public void buy2() {
        messageWindow.setVisible(false);
        sellWindow.setVisible(false);
        buyWindow.setVisible(true);
        buyWindowTitleLabel.setText(shopLabel2.getText());
        buyWindowQuantityLabel.setText(Integer.toString(quantity));
        preMultiplier = price2;
        buyWindowPriceLabel.setText(Integer.toString(preMultiplier)); 
        buyable = new MarketItem(goods[1].getType(),quantity,99);

    }
    public void buy3() {
        messageWindow.setVisible(false);
        sellWindow.setVisible(false);
        buyWindow.setVisible(true);
        buyWindowTitleLabel.setText(shopLabel3.getText());
        buyWindowQuantityLabel.setText(Integer.toString(quantity));
        preMultiplier = price3;
        buyWindowPriceLabel.setText(Integer.toString(preMultiplier)); 
        buyable = new MarketItem(goods[2].getType(),quantity,99);

    }
    public void buy4() {
        messageWindow.setVisible(false);
        sellWindow.setVisible(false);
        buyWindow.setVisible(true);
        buyWindowTitleLabel.setText(shopLabel4.getText());
        buyWindowQuantityLabel.setText(Integer.toString(quantity));
        preMultiplier= price4;
        buyWindowPriceLabel.setText(Integer.toString(preMultiplier));
        buyable = new MarketItem(goods[3].getType(),quantity,99);

    }
    
    public void buyButton() {
        buyablePrice = preMultiplier * quantity;
        if(RootLayoutController.getCredits() >= buyablePrice) {
            pInventory.store(buyable,quantity);
            quantity = 1;
            RootLayoutController.setCredits(RootLayoutController.getCredits() - buyablePrice);
            creditsLabel.setText(Integer.toString(RootLayoutController.getCredits()));
            updatePInv();
            buyWindowQuantityLabel.setText(Integer.toString(quantity));
            buyWindowPriceLabel.setText(Integer.toString(preMultiplier * quantity));    

        }
    }    
    //This is what happens when the user presses the exit label
    public void exitShop() {
        shopWindowAnchor.setVisible(false);
        shopWindowAnchor2.setVisible(false);
        inventory.setVisible(false);
        inventory1.setVisible(false);
        buyWindow.setVisible(false);
        sellWindow.setVisible(false);
        messageWindow.setVisible(false);
    }
        // Lowers the quantity of an item sold or bought
        public void quatDown(){
            if (quantity > 1) {
                quantity--;
                sellWindowQuantityLabel.setText(Integer.toString(quantity));
                buyWindowQuantityLabel.setText(Integer.toString(quantity));
                sellWindowPriceLabel.setText(Integer.toString(preMultiplier * quantity)); 
                buyWindowPriceLabel.setText(Integer.toString(preMultiplier * quantity));    


            }
        }
        //increases the amount of an item to be bought or sold
        public void quatUp() {
            quantity++;
            sellWindowQuantityLabel.setText(Integer.toString(quantity));
            buyWindowQuantityLabel.setText(Integer.toString(quantity));
            sellWindowPriceLabel.setText(Integer.toString(preMultiplier * quantity));
            buyWindowPriceLabel.setText(Integer.toString(preMultiplier * quantity));    
        }
  public void sell1() {
        messageWindow.setVisible(false);
        sellWindow.setVisible(true);
        buyWindow.setVisible(false);
        boolean a = false;
        for(int i = 0; i < 6; i++) {
            if(playerGoods[i].getType().equals(genericList[0])) {
                a = true;
            }
        }
        if(a) {
            sellWindowTitleLabel.setText(genericList[0].toString());
            sellWindowQuantityLabel.setText(Integer.toString(quantity));
            preMultiplier= salePrice1;
            sellWindowPriceLabel.setText(Integer.toString(preMultiplier));    
            sellable = new MarketItem(genericList[0],quantity,99); 
        }
    }
   
        public void sell2() {
        messageWindow.setVisible(false);
        sellWindow.setVisible(true);
        buyWindow.setVisible(false);
        boolean a = false;
        for(int i = 0; i < 6; i++) {
            if(playerGoods[i].getType().equals(genericList[1])) {
                a = true;
            }
        }
        if(a) {
            sellWindowTitleLabel.setText(genericList[1].toString());
            sellWindowQuantityLabel.setText(Integer.toString(quantity));
            preMultiplier= salePrice2;
            sellWindowPriceLabel.setText(Integer.toString(preMultiplier));    
            sellable = new MarketItem(genericList[1],quantity,99); 
        }
    }
     
        public void sell3() {
        messageWindow.setVisible(false);
        sellWindow.setVisible(true);
        buyWindow.setVisible(false);
        boolean a = false;
        for(int i = 0; i < 6; i++) {
            if(playerGoods[i].getType().equals(genericList[2])) {
                a = true;
            }
        }
        if(a) {
            sellWindowTitleLabel.setText(genericList[2].toString());
            sellWindowQuantityLabel.setText(Integer.toString(quantity));
            preMultiplier= salePrice3;
            sellWindowPriceLabel.setText(Integer.toString(preMultiplier));    
            sellable = new MarketItem(genericList[2],quantity,99); 
        }
    }
     
        public void sell4() {
        messageWindow.setVisible(false);
        sellWindow.setVisible(true);
        buyWindow.setVisible(false);
        boolean a = false;
        for(int i = 0; i < 6; i++) {
            if(playerGoods[i].getType().equals(genericList[3])) {
                a = true;
            }
        }
        if(a) {
            sellWindowTitleLabel.setText(genericList[3].toString());
            sellWindowQuantityLabel.setText(Integer.toString(quantity));
            preMultiplier=salePrice4;
            sellWindowPriceLabel.setText(Integer.toString(preMultiplier));    
            sellable = new MarketItem(genericList[3],quantity,99); 
        }
    }
        
        public void sell5() {
        messageWindow.setVisible(false);
        sellWindow.setVisible(true);
        buyWindow.setVisible(false);
        boolean a = false;
        for(int i = 0; i < 6; i++) {
            if(playerGoods[i].getType().equals(genericList[4])) {
                a = true;
            }
        }
        if(a) {
            sellWindowTitleLabel.setText(genericList[4].toString());
            sellWindowQuantityLabel.setText(Integer.toString(quantity));
            preMultiplier= salePrice5;
            sellWindowPriceLabel.setText(Integer.toString(preMultiplier));    
            sellable = new MarketItem(genericList[4],quantity,99); 
        }
    }
    
        public void sell6() {
        messageWindow.setVisible(false);
        sellWindow.setVisible(true);
        buyWindow.setVisible(false);
        boolean a = false;
        for(int i = 0; i < 6; i++) {
            if(playerGoods[i].getType().equals(genericList[5])) {
                a = true;
            }
        }
        if(a) {
            sellWindowTitleLabel.setText(genericList[5].toString());
            sellWindowQuantityLabel.setText(Integer.toString(quantity));
            preMultiplier= salePrice6;
            sellWindowPriceLabel.setText(Integer.toString(preMultiplier));    
            sellable = new MarketItem(genericList[5],quantity,99);
        }
    }
        
        public void sell7() {
        messageWindow.setVisible(false);
        sellWindow.setVisible(true);
        buyWindow.setVisible(false);
        boolean a = false;
        for(int i = 0; i < 6; i++) {
            if(playerGoods[i].getType().equals(genericList[6])) {
                a = true;
            }
        }
        if(a) {
            sellWindowTitleLabel.setText(genericList[6].toString());
            sellWindowQuantityLabel.setText(Integer.toString(quantity));
            preMultiplier= salePrice7;
            sellWindowPriceLabel.setText(Integer.toString(preMultiplier));    
            sellable = new MarketItem(genericList[6],quantity,99);
        }
    }
     
        public void sell8() {
        messageWindow.setVisible(false);
        sellWindow.setVisible(true);
        buyWindow.setVisible(false);
        boolean a = false;
        for(int i = 0; i < 6; i++) {
            if(playerGoods[i].getType().equals(genericList[7])) {
                a = true;
            }
        }
        if(a) {
            sellWindowTitleLabel.setText(genericList[7].toString());
            sellWindowQuantityLabel.setText(Integer.toString(quantity));
            preMultiplier= salePrice8;
            sellWindowPriceLabel.setText(Integer.toString(preMultiplier));    
            sellable = new MarketItem(genericList[7],quantity,99); 
        }
    }
        
        public void sell9() {
        messageWindow.setVisible(false);
        sellWindow.setVisible(true);
        buyWindow.setVisible(false);
        boolean a = false;
        for(int i = 0; i < 6; i++) {
            if(playerGoods[i].getType().equals(genericList[8])) {
                a = true;
            }
        }
        if(a) {
            sellWindowTitleLabel.setText(genericList[8].toString());
            sellWindowQuantityLabel.setText(Integer.toString(quantity));
            preMultiplier= salePrice9;
            sellWindowPriceLabel.setText(Integer.toString(preMultiplier));    
            sellable = new MarketItem(genericList[8],quantity,99);
        }
    }
        
        public void sell10() {
        messageWindow.setVisible(false);
        sellWindow.setVisible(true);
        buyWindow.setVisible(false);
        boolean a = false;
        for(int i = 0; i < 6; i++) {
            if(playerGoods[i].getType().equals(genericList[9])) {
                a = true;
            }
        }
        if(a) {
            sellWindowTitleLabel.setText(genericList[9].toString());
            sellWindowQuantityLabel.setText(Integer.toString(quantity));
            preMultiplier= salePrice10;
            sellWindowPriceLabel.setText(Integer.toString(preMultiplier));    
            sellable = new MarketItem(genericList[9],quantity,99); 
        }
    }
    // dictates what the button in the sell window does.
    // updates the inventory the windows
    public void sellButton() {
        if(pInventory.totalItemCount(sellable) >= quantity) {
            sellablePrice = preMultiplier * quantity;
            pInventory.remove(sellable,quantity);
            quantity = 1;
            RootLayoutController.setCredits(RootLayoutController.getCredits() + sellablePrice);
            creditsLabel.setText(Integer.toString(RootLayoutController.getCredits()));
            updatePInv();
            sellWindowPriceLabel.setText(Integer.toString(preMultiplier * quantity)); 
            sellWindowQuantityLabel.setText(Integer.toString(quantity));
        }
    }
    
    public void mouseOverShop1() {
        shopLabel1.setTextFill(Color.GREEN);
    }
    
    public void mouseOverShop2() {
        shopLabel2.setTextFill(Color.GREEN);
    }

    public void mouseOverShop3() {
        shopLabel3.setTextFill(Color.GREEN);
    }
    
    public void mouseOverShop4() {
        shopLabel4.setTextFill(Color.GREEN);
    }
    public void mouseGoneShop1() {
        shopLabel1.setTextFill(Color.WHITE);
    }
    public void mouseGoneShop2() {
        shopLabel2.setTextFill(Color.WHITE);
    }
    public void mouseGoneShop3() {
        shopLabel3.setTextFill(Color.WHITE);
    }
    public void mouseGoneShop4() {
        shopLabel4.setTextFill(Color.WHITE);
    }
    
    
}