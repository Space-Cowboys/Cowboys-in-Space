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
import java.net.URL;
import java.util.ResourceBundle;
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

/**
 * FXML Controller class
 *
 * @author Keanu
 */
public class ZonessMarketController implements Initializable {
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
    PriceModel zonessModel;
    MarketItem buyable; 
    MarketItem sellable;
    Goods[] genericList;
    Inventory pInventory;
    int sellablePrice;
    int buyablePrice;
    Label[] labels = new Label[10];
    GoodTracker[] goods;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        shop.setX(500);
        creditsLabel.setText(Integer.toString(RootLayoutController.getCredits()));
        Planet p = RootLayoutController.getUniverse().getFromName("Zoness");
        pInventory = RootLayoutController.getInventory();
        Label[] listO = {PQInv1,PQInv2,PQInv3,PQInv4,PQInv5,PQInv6,PQInv7,PQInv8,PQInv9,PQInv10};
        for(int i=0;i <labels.length;i++) {
            labels[i] = listO[i]; 
        }
        RootLayoutController.setPlanetLocation(p);
        goods = RootLayoutController.getPlanet().getGT();
        genericList = RootLayoutController.getPlanet().getGoodsList();
        updatePInv();
        zonessModel = new PriceModel(p);
        BorderPane root = MainApp.getRootLayout(); 
        Scene scene = root.getScene(); 

        
        shopLabel1.setText(goods[0].getType().toString());
        shopLabel2.setText(goods[1].getType().toString());
        shopLabel3.setText(goods[2].getType().toString());
        shopLabel4.setText(goods[3].getType().toString());
        price1 = zonessModel.showPrice(goods[0].getType());
        price2 = zonessModel.showPrice(goods[1].getType());
        price3 = zonessModel.showPrice(goods[2].getType());
        price4 = zonessModel.showPrice(goods[3].getType());
        priceLabel1.setText(Integer.toString(price1));
        priceLabel2.setText(Integer.toString(price2));
        priceLabel3.setText(Integer.toString(price3));
        priceLabel4.setText(Integer.toString(price4));

         scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (ke.getCode().equals(KeyCode.DOWN)) {
                    protag.setY(protag.getY()+5);
                    System.out.println(protag.getX());
                    System.out.println(shop.getX());
                }
                if (ke.getCode().equals(KeyCode.RIGHT)) {
                    protag.setX(protag.getX() +5);
                }
                if (ke.getCode().equals(KeyCode.LEFT)) {
                    protag.setX(protag.getX() - 5);
                }
                if (ke.getCode().equals(KeyCode.UP)) {
                    protag.setY(protag.getY() - 5);
                } 
                if(ke.getCode().equals(KeyCode.SPACE) && Math.abs(shop.getX() - protag.getX()) < 80) {
                    System.out.println("this was reached");
                    shopWindowAnchor.setVisible(true);
                    shopWindowAnchor2.setVisible(true);
                    inventory.setVisible(true);
                    inventory1.setVisible(true);
                    messageWindow.setVisible(true);

                }
            }
        });
         
    }
    private void updatePInv() {
        MarketItem[] marketItemList = new MarketItem[10];
        for(int i = 0; i < genericList.length;i++) {
            marketItemList[i] = new MarketItem(genericList[i],0,99); 
        }
        for(int i = 0; i < labels.length;i++) {
            labels[i].setText(Integer.toString(pInventory.totalItemCount(marketItemList[i])));
        }
    }
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
        }
    }    
    public void exitShop() {
        shopWindowAnchor.setVisible(false);
        shopWindowAnchor2.setVisible(false);
        inventory.setVisible(false);
        inventory1.setVisible(false);
        buyWindow.setVisible(false);
        sellWindow.setVisible(false);
        messageWindow.setVisible(false);
    }
    
        public void quatDown(){
            if (quantity > 1) {
                quantity--;
                sellWindowQuantityLabel.setText(Integer.toString(quantity));
                buyWindowQuantityLabel.setText(Integer.toString(quantity));
                sellWindowPriceLabel.setText(Integer.toString(preMultiplier * quantity)); 
                buyWindowPriceLabel.setText(Integer.toString(preMultiplier * quantity));    


            }
        }
        public void quatUp() {
            quantity++;
            sellWindowQuantityLabel.setText(Integer.toString(quantity));
            buyWindowQuantityLabel.setText(Integer.toString(quantity));
            sellWindowPriceLabel.setText(Integer.toString(preMultiplier * quantity));
            buyWindowPriceLabel.setText(Integer.toString(preMultiplier * quantity));    




        }
        public void sell1() {
        messageWindow.setVisible(false);
        buyWindow.setVisible(false);
        sellWindow.setVisible(true);
        sellWindowTitleLabel.setText(genericList[0].toString());
        sellWindowQuantityLabel.setText(Integer.toString(quantity));
        preMultiplier = zonessModel.showSalePrice(genericList[0]);
        sellWindowPriceLabel.setText(Integer.toString(preMultiplier));    
        sellable = new MarketItem(genericList[0],quantity,99); 
    }
   
        public void sell2() {
        messageWindow.setVisible(false);
        sellWindow.setVisible(true);
        buyWindow.setVisible(false);
        sellWindowTitleLabel.setText(genericList[1].toString());
        sellWindowQuantityLabel.setText(Integer.toString(quantity));
        preMultiplier= zonessModel.showSalePrice(genericList[1]);
        sellWindowPriceLabel.setText(Integer.toString(preMultiplier));    
        sellable = new MarketItem(genericList[1],quantity,99); 
    }
     
        public void sell3() {
        messageWindow.setVisible(false);
        sellWindow.setVisible(true);
        buyWindow.setVisible(false);
        sellWindowTitleLabel.setText(genericList[2].toString());
        sellWindowQuantityLabel.setText(Integer.toString(quantity));
        preMultiplier= zonessModel.showSalePrice(genericList[2]);
        sellWindowPriceLabel.setText(Integer.toString(preMultiplier));    
        sellable = new MarketItem(genericList[2],quantity,99); 
    }
     
        public void sell4() {
        messageWindow.setVisible(false);
        sellWindow.setVisible(true);
        buyWindow.setVisible(false);
        sellWindowTitleLabel.setText(genericList[3].toString());
        sellWindowQuantityLabel.setText(Integer.toString(quantity));
        preMultiplier=zonessModel.showSalePrice(genericList[3]);
        sellWindowPriceLabel.setText(Integer.toString(preMultiplier));    
        sellable = new MarketItem(genericList[3],quantity,99); 
    }
        
        public void sell5() {
        messageWindow.setVisible(false);
        sellWindow.setVisible(true);
        buyWindow.setVisible(false);
        sellWindowTitleLabel.setText(genericList[4].toString());
        sellWindowQuantityLabel.setText(Integer.toString(quantity));
        preMultiplier= zonessModel.showSalePrice(genericList[4]);
        sellWindowPriceLabel.setText(Integer.toString(preMultiplier));    
        sellable = new MarketItem(genericList[4],quantity,99); 
    }
    
        public void sell6() {
        messageWindow.setVisible(false);
        sellWindow.setVisible(true);
        buyWindow.setVisible(false);
        sellWindowTitleLabel.setText(genericList[5].toString());
        sellWindowQuantityLabel.setText(Integer.toString(quantity));
        preMultiplier= zonessModel.showSalePrice(genericList[5]);
        sellWindowPriceLabel.setText(Integer.toString(preMultiplier));    
        sellable = new MarketItem(genericList[5],quantity,99); 
    }
        
        public void sell7() {
        messageWindow.setVisible(false);
        sellWindow.setVisible(true);
        buyWindow.setVisible(false);
        sellWindowTitleLabel.setText(genericList[6].toString());
        sellWindowQuantityLabel.setText(Integer.toString(quantity));
        preMultiplier= zonessModel.showSalePrice(genericList[6]);
        sellWindowPriceLabel.setText(Integer.toString(preMultiplier));    
        sellable = new MarketItem(genericList[6],quantity,99); 
    }
     
        public void sell8() {
        messageWindow.setVisible(false);
        sellWindow.setVisible(true);
        buyWindow.setVisible(false);
        sellWindowTitleLabel.setText(genericList[7].toString());
        sellWindowQuantityLabel.setText(Integer.toString(quantity));
        preMultiplier= zonessModel.showSalePrice(genericList[7]);
        sellWindowPriceLabel.setText(Integer.toString(preMultiplier));    
        sellable = new MarketItem(genericList[7],quantity,99); 
    }
        
        public void sell9() {
        messageWindow.setVisible(false);
        sellWindow.setVisible(true);
        buyWindow.setVisible(false);
        sellWindowTitleLabel.setText(genericList[8].toString());
        sellWindowQuantityLabel.setText(Integer.toString(quantity));
        preMultiplier= zonessModel.showSalePrice(genericList[8]);
        sellWindowPriceLabel.setText(Integer.toString(preMultiplier));    
        sellable = new MarketItem(genericList[8],quantity,99); 
    }
        
        public void sell10() {
        messageWindow.setVisible(false);
        sellWindow.setVisible(true);
        buyWindow.setVisible(false);
        sellWindowTitleLabel.setText(genericList[9].toString());
        sellWindowQuantityLabel.setText(Integer.toString(quantity));
        preMultiplier= zonessModel.showSalePrice(genericList[9]);
        sellWindowPriceLabel.setText(Integer.toString(preMultiplier));    
        sellable = new MarketItem(genericList[9],quantity,99); 
    }
        
    public void sellButton() {
        if(pInventory.totalItemCount(sellable) >= quantity) {
            sellablePrice = preMultiplier * quantity;
            pInventory.remove(sellable,quantity);
            quantity = 1;
            RootLayoutController.setCredits(RootLayoutController.getCredits() + sellablePrice);
            creditsLabel.setText(Integer.toString(RootLayoutController.getCredits()));
            updatePInv();
        }
    }
    
}
