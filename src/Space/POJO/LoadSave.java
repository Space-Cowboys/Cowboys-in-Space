package Space.POJO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class LoadSave{
    private String charName;
    private int pilot;
    private int engineering;
    private int charisma;
    private int luck;
    private int xp;
    private int level;
    private int credits;
    private int rep;
    private int skillPoints;
    private int fuel;
    private String location;
    private int[] inventory;
    
    public LoadSave(String name, int pilot, int engineer,
            int charisma, int luck, int xp, int level, int credits, int rep,
            int skillpoints, int fuel, String location, int[] inventory){
        this.charName = name;
        this.pilot = pilot;
        this.engineering = engineer;
        this.charisma = charisma;
        this.luck = luck;
        this.xp = xp;
        this.level = level;
        this.credits = credits;
        this.rep = rep;
        this.skillPoints = skillpoints;
        this.fuel = fuel;
        this.location = location;
        this.inventory = inventory;
    }
    public void save(String filename) throws IOException{
        File savefile = new File(filename);
        try (FileWriter saver = new FileWriter(savefile, false)) {
            saver.write(charName + "\n");
            saver.write(pilot + "\n");
            saver.write(engineering + "\n");
            saver.write(charisma + "\n");
            saver.write(luck + "\n");
            saver.write(xp + "\n");
            saver.write(level + "\n");
            saver.write(credits + "\n");
            saver.write(rep + "\n");
            saver.write(skillPoints + "\n");
            saver.write(location + "\n");
            saver.write(fuel + "\n");
            saver.write(this.invToString());
        }
    }
    
    private String invToString(){
        String str = new String();
        for (int i: inventory){
            str += inventory[i];
            str += "\n";
        }
        return str;
    }
    
    public ArrayList<String> load(String f) throws FileNotFoundException, IOException{
        ArrayList<String> lines = new ArrayList<>();
        File file = new File(f);
        try (FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }
    
    public String getName(String path) throws IOException{
        return this.load(path).get(0);
    }
    
    public void setName(String n){
        this.charName = n;
    }
    
    public int getPilot(String path) throws IOException{
        return Integer.parseInt(this.load(path).get(1));
    }
    
    public void setPilot(int n){
        this.pilot = n;
    }
    
    public int getEngineering(String path) throws IOException{
        return Integer.parseInt(this.load(path).get(2));
    }
    
    public void setEngineering(int n){
        this.engineering = n;
    }
    
    public int getCharisma(String path) throws IOException{
        return Integer.parseInt(this.load(path).get(3));
    }
    
    public void setCharisma(int n){
        this.charisma = n;
    }
    
    public int getLuck(String path) throws IOException{
        return Integer.parseInt(this.load(path).get(4));
    }
    
    public void setLuck(int n){
        this.luck = n;
    }
    
    public int getXP(String path) throws IOException{
        return Integer.parseInt(this.load(path).get(5));
    }
    
    public void setXP(int n){
        this.xp = n;
    }
    
    public int getLevel(String path) throws IOException{
        return Integer.parseInt(this.load(path).get(6));
    }
    
    public void setLevel(int n){
        this.level = n;
    }
    
    public int getCredits(String path) throws IOException{
        return Integer.parseInt(this.load(path).get(7));
    }
    
    public void setCredits(int n){
        this.credits = n;
    }
    
    public int getRep(String path) throws IOException{
        return Integer.parseInt(this.load(path).get(8));
    }
    
    public void setRep(int n){
        this.rep = n;
    }
    
    public int getFreeSkill(String path) throws IOException{
        return Integer.parseInt(this.load(path).get(9));
    }
    
    public void setFreeSkill(int n){
        this.skillPoints = n;
    }
    
    public int getFuel(String path) throws IOException{
        return Integer.parseInt(this.load(path).get(10));
    }
    
    public void setFuel(int n){
        this.fuel = n;
    }
    
    public String getLocation(String path) throws IOException{
        return this.load(path).get(10);
    }
    
    public void setLocation(String n){
        this.location = n;
    }
    
    public int[] getInventory(String path) throws IOException{
        int[] items = new int[10];
        for (int i = 0; i < 10; i++){
            items[i] = Integer.parseInt(this.load(path).get(i+11));
        }
        return items;
    }
    
    public void setInventory(int[] n){
        this.inventory = n;
    }
}
    