/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Space.controller;

import Space.MainApp;
import Space.POJO.*;
import Space.Player;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
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
    private static int rep = 0;
    private static int xp = 0;
    private static int level = 1;
    private static MediaPlayer mediaPlayer; 
    private static String location = "";
    private static LoadSave load;
    private static Planet toPlanet; 
    private static int flyingPoints;
    private static int orientation;
    private static final int STARTING_BALANCE = 1000;
    private static final int STARTING_FUEL = 500;
    private static final int INVCAP = 10;
    private static Ship playerShip;

    /**
    * @return the score in gotten in the flying mission.
    * Used to calculate reward at end of mission.
    */
    public static int getFlyingPoints() {
        return flyingPoints;
    }

    /**
    * This changes the flying points score. It usually changes it once an
    * enemy ship has been destroyed.
    *
    * @param num the score to change it to.
    */
    public static void setFlyingPoints(int num) {
        flyingPoints = num;
    }

    /**
     *
     * @return the amount of fuel the player has.
     */
    public static int getFuel() {
        return fuel;
    }
    
    public static void setShip(Ship ship) {
        playerShip = ship;
    }
    
    public static Ship getShip() {
        return playerShip;
    }

    /**
     * Loads a previously saved game.
     * It reads a text file previously written by the save method.
     * Then it sets the skills/location according to that info.
     */
    public static void load() {
        String path = "saveFile.txt";
        load = new LoadSave();
        try {
        load.load(path);
        setName(load.getName(path));
        setPilotSkill(load.getPilot(path));
        setEngineeringSkill(load.getEngineering(path));
        setCharismaSkill(load.getCharisma(path));
        setLuckSkill(load.getLuck(path));
        xp = (load.getXP(path));
        level = (load.getLevel(path));
        setCredits(load.getCredits(path));
        rep = (load.getRep(path));
        setRemainingSkillPoints(load.getFreeSkill(path));
        setFuel(load.getFuel(path));
        setPlanetLocation(u.getFromName(load.getLocation(path)));
        setInventory(load.getInventory(path));
        } catch (IOException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }
    /**
     * Writes a text file with all the current points and items the player has.
     */
    public static void save() {
        load = new LoadSave();
        load.setName(getName());
        load.setPilot(getPilotSkill());
        load.setEngineering(getEngineeringSkill());
        load.setCharisma(getCharismaSkill());
        load.setLuck(getLuckSkill());
        load.setXP(xp);
        load.setLevel(level);
        load.setCredits(getCredits());
        load.setRep(rep);
        load.setFreeSkill(getSkillPoints());
        load.setFuel(getFuel());
        load.setLocation(getPlanet().getName());
        load.setInventory(getInventory().quantityCount());
        try {
            load.save("saveFile.txt");
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    /**
     * Sets the fuel variable to the number listed.
     * @param newFuel
     */
    public static void setFuel(int newFuel) {
        fuel = newFuel;
    }

    /**
     * Sets the planet that the player is at.
     * @param p
     */
    public static void setPlanetLocation(Planet p) {
        planet = p;
    }

    /**
     * Determines what side of the screen the player should appear on
     * on screens with multiple portals.
     * @return a 0 or 1 determining what side the player should appear on.
     */
    public static int getOrientation() {
        return orientation;
    }

    /**
     * This sets the location(0 or 1) the player should appear on the screen.
     * @param i
     */
    public static void setOrientation(int i) {
        orientation = i;
    }

    /**
     *
     * @return the player inventory
     */
    public static Inventory getInventory() {
        return inventory;
    }

    /**
     *
     * @return the player's pilot skill.
     */
    public static int getPilotSkill() {
        return player.getPilot();
    }

    /**
     *
     * @return the planet the player is currently on.
     */
    public static Planet getPlanet() {
        return planet;
    }

    /**
     *
     * @return the planet the player would be traversing to.
     */
    public static Planet getToPlanet() {
        return toPlanet;
    }

    /**
     * Set the planet the player is heading towards.
     * @param p
     */
    public static void setToPlanet(Planet p) {
        toPlanet = p;
    }

    /**
     *
     * @return the particular location the player is at.(Such as MarketPlace,
     * port,etc)
     */
    public static String getLocation() {
        return location;
    }

    /**
     * Sets the location that the player is currently at.
     * Such as marketplace or port.
     * @param newLocation
     */
    public static void setLocation(String newLocation) {
        location = newLocation;
    }

    /**
     *
     * @return the player's charisma.
     */
    public static int getCharismaSkill() {
        return player.getCharisma();
    }

    /**
     *
     * @return the player's engineering skill.
     */
    public static int getEngineeringSkill() {
        return player.getEngineering();
    }

    /**
     *
     * @return the player's luck skill.
     */
    public static int getLuckSkill() {
        return player.getLuck();
    }

    /**
     * Changes the BG music in game according to the string put in.
     * @param filename
     */
    public static void changeSong(String filename) {
        /*mediaPlayer.stop();
        mediaPlayer = new MediaPlayer(new Media(
                new File(filename).toURI().toString()));
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();*/
    }


    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    public void initialize(URL url, ResourceBundle rb) {
        player = new Player();
        playerShip = new Ship(5,10,1,1);
        u = new Universe();
        inventory = new Inventory();
        credits = STARTING_BALANCE;
        fuel = STARTING_FUEL;
       // mediaPlayer = new MediaPlayer(new Media(
         //       new File("src/Space/Music/title.wav").toURI().toString()));
       // mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        //mediaPlayer.play();
    }

    /**
     *
     * @return the universe of this game.
     */
    public static Universe getUniverse() {
        return u;
    }
    @FXML
    private void exit() {
        System.exit(0);
    }
    /**
     *
     * @return the amount of credits the player currently has.
     */
    public static int getCredits() {
        return credits;
    }

    /**
     * Sets the amount of credits the player currently has.
     * @param amount
     */
    public static void setCredits(int amount) {
        credits = amount;
    }

    /**
     *
     * @return the amount of remaining skill points the player has.
     */
    public static int getSkillPoints() {
        return player.getSkillPointsRemaining();
    }

    /**
     *
     * @return the player's name.
     */
    public static String getName() {
        return player.getName();
    }

    /**
     * Sets the amount of remaining skill points the player has.
     * @param skillPoints
     */
    public static void setRemainingSkillPoints(int skillPoints) {
        player.setSkillPointsRemaining(skillPoints);
    }

    /**
     * Sets the player's name.
     * @param name
     */
    public static void setName(String name) {
        player.setName(name);
    }

    /**
     * Sets the player's pilot skill.
     * @param pilotSkill
     */
    public static void setPilotSkill(int pilotSkill) {
        player.setPilot(pilotSkill);
    }

    /**
     * Sets the player's charisma skill.
     * @param charismaSkill
     */
    public static void setCharismaSkill(int charismaSkill) {
        player.setCharisma(charismaSkill);
    }

    /**
     * This method is used in order to set the player's inventory
     * only using an integer array.
     * This integer array has the quantity of each item the player can have.
     * @param quantList
     */
    public static void setInventory(int[] quantList) {
        inventory = new Inventory();
        Good.Goods[] planetGoods = Planet.getGoodsList();
        MarketItem[] marketItemList = new MarketItem[10];
        for (int i = 0; i < planetGoods.length; i++) {
            marketItemList[i] = new MarketItem(planetGoods[i], 0, 99);
        }
        for (int i = 0; i < marketItemList.length; i++) {
            inventory.store(marketItemList[i], quantList[i]);
        }
    }

    /**
     * set the player's engineering skill.
     * @param engineeringSkill
     */
    public static void setEngineeringSkill(int engineeringSkill) {
        player.setEngineering(engineeringSkill);
    }

    /**
     * sets the player's luck skill.
     * @param luckSkill
     */
    public static void setLuckSkill(int luckSkill) {
        player.setLuck(luckSkill);
    }
}
