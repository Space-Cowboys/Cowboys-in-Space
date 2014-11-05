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
    
  
    public Player() {
        charisma = 5;
        engineering = 5;
        pilot = 5;
        luck = 5;
        skillPointsRemaining = 5;
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
