public class RandomEncounter {
    
    private String startPlanet;
    private String endPlanet;
    public final Random rand = new Random();
    
    public RandomEncounter(String startPlanet, String endPlanet) {
        this.startPlanet = startPlanet;
        this.endPlanet = endPlanet
        
    }
    
    public boolean pirate() {
    
        int occurPercent = Universe.getUniverse().getFromName(startPlanet).getPirates()
                         + Universe.getUniverse().getFromName(endPlanet).getPirates();
        
        int randNum = (int)(rand.nextDouble()*100);
        
        if (occurPercent <= randNum){
            return true;
            
        else{
            return false;
        }
    }

    public boolean trader() {
        int occurPercent = Universe.getUniverse().getFromName(startPlanet).getTraders()
                         + Universe.getUniverse().getFromName(endPlanet).getTraders();
        
        int randNum = (int)(rand.nextDouble()*100);
        
        if (occurPercent <= randNum){
            return true;
            
        else{
            return false;
        }
    }
    
    public boolean police() {
        int occurPercent = Universe.getUniverse().getFromName(startPlanet).getPolice()
                         + Universe.getUniverse().getFromName(endPlanet).getPolice();
        
        int randNum = (int)(rand.nextDouble()*100);
        
        if (occurPercent <= randNum){
            return true;
            
        else{
            return false;
        }
    }
}
