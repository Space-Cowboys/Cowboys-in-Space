/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Space.POJO;

/**
 *
 * @author Keanu
 */
public class Ship {
    
    int maxShieldLevel;
    int maxLaserLevel;
    int currentShieldLevel;
    int currentLaserLevel;
    int wepSocketsFilled;
    int maxCapacity; 
    int shipLevel; 
    int maxEnergyBars;
    int maxShipHealth;
    int currentHealth;
    int currentEnergy;
    
    
    public Ship(int maxEnergyBars, int maxCapacity, int shipLevel, int maxShipHealth) {
        this.maxEnergyBars = maxEnergyBars;
        this.maxCapacity = maxCapacity;
        this.shipLevel = shipLevel; 
        this.maxShipHealth = maxShipHealth;
        maxShieldLevel = 1;
        maxLaserLevel = 1;
        currentShieldLevel = 1;
        currentLaserLevel = 1;
        currentHealth = maxShipHealth;
        currentEnergy = maxEnergyBars;
    }

    public int getCurrentShieldLevel() {
        return currentShieldLevel;
    }

    public void setCurrentShieldLevel(int currentShieldLevel) {
        this.currentShieldLevel = currentShieldLevel;
    }

    public int getCurrentLaserLevel() {
        return currentLaserLevel;
    }

    public void setCurrentLaserLevel(int currentLaserLevel) {
        this.currentLaserLevel = currentLaserLevel;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getCurrentEnergy() {
        return currentEnergy;
    }

    public void setCurrentEnergy(int currentEnergy) {
        this.currentEnergy = currentEnergy;
    }

    public int getMaxShipHealth() {
        return maxShipHealth;
    }

    public void setMaxShipHealth(int shipHealth) {
        this.maxShipHealth = shipHealth;
    }

    public int getShipLevel() {
        return shipLevel;
    }

    public int getMaxEnergyBars() {
        return maxEnergyBars;
    }
    
    public void setMaxEnergyBars(int maxEnergyBars) {
        this.maxEnergyBars = maxEnergyBars; 
    }
    public void setShipLevel(int shipLevel) {
        this.shipLevel = shipLevel;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getMaxShieldLevel() {
        return maxShieldLevel;
    }

    public void setMaxShieldLevel(int maxShieldLevel) {
        this.maxShieldLevel = maxShieldLevel;
    }

    public int getMaxLaserLevel() {
        return maxLaserLevel;
    }

    public void setMaxLaserLevel(int maxLaserLevel) {
        this.maxLaserLevel = maxLaserLevel;
    }
}