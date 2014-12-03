package Space; 
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Keanu
 */
public class Player {
    private String name;
    private int charisma;
    private int engineering;
    private int pilot;
    private int luck;
    private int skillPointsRemaining;
    private int experiencePoints;
    private int level;
    private int moneyinBank;
    private int loanAmount;
    private int creditScore;
    private int currentLoan;

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public int getMoneyinBank() {
        return moneyinBank;
    }

    public int getCurrentLoan() {
        return currentLoan;
    }

    public void setCurrentLoan(int currentLoan) {
        this.currentLoan = currentLoan;
    }

    public void setMoneyinBank(int moneyinBank) {
        this.moneyinBank = moneyinBank;
    }

    public int getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }
    
  
    public Player() {
        charisma = 5;
        engineering = 5;
        pilot = 5;
        luck = 5;
        skillPointsRemaining = 5;
        experiencePoints = 0;
        level = 1;
        creditScore = 5000;
        moneyinBank = 0;
        loanAmount = 0;
        currentLoan = 0;
    }

    public int getSkillPointsRemaining() {
        return skillPointsRemaining;
    }

    public void setSkillPointsRemaining(int skillPointsRemaining) {
        this.skillPointsRemaining = skillPointsRemaining;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getEngineering() {
        return engineering;
    }

    public void setEngineering(int engineering) {
        this.engineering = engineering;
    }

    public int getPilot() {
        return pilot;
    }

    public void setPilot(int pilot) {
        this.pilot = pilot;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }
}
