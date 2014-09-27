package spacecowboys;

public class ConstantData{
    public enum Resource{
        NORESOURCES("No resources"),
        MINERALRICH("Mineral Rich"),
        MINERALPOOR("Mineral Poor"),
        DESERT("Desert"),
        LOTSOFWATER("Lots of Water"),
        RICHSOIL("Rich Soil"),
        POORSOIL("Poor Soil"),
        RICHFAUNA("Rich Fauna"),
        LIFELESS("Lifeless"),
        WEIRDMUSHROOMS("Weird Mushrooms"),
        LOTSOFHERBS("Lots of Herbs"),
        ARTISTIC("Artistic"),
        WARLIKE("Warlike");
        
        private final String id;
        private final Good[] goods;
        private final double[] mults;
        
        Resource(String i, Object ... args){
            this.id = i;
            int half = args.length / 2;
            this.goods = new Good[half];
            this.mults = new double[half];
            for (int j = 0; j < half; j++){
                this.goods[j] = (Good)args[j];
                this.mults[j] = (double)args[j+half];
            }
        }
        
        @Override
        public String toString(){
            return id;
        }
        
        double getGood(Good good){
            for (int i = 0; i < goods.length; i++){
                if (goods[i] == good){
                    return mults[i];
                }
            }
            return 1;
        }
    }

    public enum TechLevel{
        PREAGRICULTURE("Pre-Agriculture"),
        AGRICULTURE("Agriculture"),
        MEDIEVAL("Medieval"),
        RENAISSANCE("Renaissance"),
        EARLYINDUSTRIAL("Early Industrial"),
        INDUSTRIAL("Industrial"),
        POSTINDUSTRIAL("Post-Industrial"),
        HITECH("Hi-Tech");
        
        private final String id;
        private final Good[] goods;
        private final double[] mults;
        
        TechLevel(String i, Object ... args){
            this.id = i;
            int half = args.length / 2;
            this.goods = new Good[half];
            this.mults = new double[half];
            for (int j = 0; j < half; j++){
                this.goods[j] = (Good)args[j];
                this.mults[j] = (double)args[j+half];
            }
        }
        
        @Override
        public String toString(){
            return id;
        }
        
        double getGood(Good good){
            for (int i = 0; i < goods.length; i++){
                if (goods[i] == good){
                    return mults[i];
                }
            }
            return 1;
        }
    }
    
    public enum Government{
        ANARCHY("Anarchy"),
        CAPITALIST("Capitalist"),
        COMMUNIST("Communist"),
        CONFEDERATE("Confederate"),
        CORPORATE("Corporate"),
        CYBERNETIC("Cybernetic"),
        DEMOCRACY("Democracy"),
        DICTATORSHIP("Dictatorship"),
        FASCIST("Fascist"),
        FEUDAL("Feudal"),
        MILITARY("Military"),
        MONARCHY("Monarchy"),
        PACIFIST("Pacifist"),
        SOCIALIST("Socialist"),
        SATORI("State of Satori"),
        TECHNO("Technocracy"),
        THEO("Theocracy");
        
        private final String id;
        private final Good[] goods;
        private final double[] mults;
        
        Government(String i, Object ... args){
            this.id = i;
            int half = args.length / 2;
            this.goods = new Good[half];
            this.mults = new double[half];
            for (int j = 0; j < half; j++){
                this.goods[j] = (Good)args[j];
                this.mults[j] = (double)args[j+half];
            }
        }
        
        @Override
        public String toString(){
            return id;
        }
        
        double getGood(Good good){
            for (int i = 0; i < goods.length; i++){
                if (goods[i] == good){
                    return mults[i];
                }
            }
            return 1;
        }
    }
    
    public enum Moon{
        UNUSED("Unused Moon"),
        NOMOON("No Moon"),
        MOONBASE("Moon Base"),
        GOVSATELLITE("Government Satellite");
        
        private final String name;
        
        Moon(String n){
            this.name = n;
        }
        
        @Override
        public String toString(){
            return name;
        }
    }
    
    public enum Good{
        WATER("Water", 10, 20),
        FUR("Fur", 25, 45),
        FOOD("Food", 30, 50),
        ORE("Ore", 150, 800),
        GAMES("Games", 50, 200),
        FIREARMS("Firearms", 1500, 3000),
        MEDICINE("Medicine", 500, 2500),
        MACHINES("Machines", 900, 4000),
        NARCOTICS("Narcotics", 2000, 5000),
        ROBOTS("Robots", 1500, 6000);
        
        private final String name;
        private final int min;
        private final int max;
        
        Good(String n, int min, int max){
            this.name = n;
            this.min = min;
            this.max = max;
        }
        
        @Override
        public String toString(){
            return name;
        }
        
        public int getMin(){
        	return min;
        }
        
        public int getMax(){
        	return max;
        }
    }
    public enum Value{
    	N(0,0),
    	S(5,0),
    	R(3,1),
    	C(1,3);
    	
    	private final int value;
    	private final int available;
    	
    	Value(int v, int a){
    		this.value = v;
    		this.available = a;
    	}
    	
    	public int getV(){
    		return value;
    	}
    	
    	public int getQ(){
    		return available;
    	}
    }
    public enum StarSystem{
        RUSH("Rush Galaxy"),
        BASTILLE("Bastille System"),
        WEEZER("Weezer Cluster"),
        QUEEN("Queen Sector"),
        MUSE("Muse Nebula"),
        INCUBUS("Incubus System"),
        BOSTON("Boston Sector"),
        OASIS("Oasis Galaxy"),
        ACDC("AC/DC Quadrant"),
        NIRVANA("Nirvana Quadrant"),
        SILVERSUN("Silversun System"),
        ROLLINGSTONES("Rolling Stones Cluster"), 
        PSY("Psy Nebula");
        
        private final String name;
        
        StarSystem(String n){
            this.name = n;
        }
        
        @Override
        public String toString(){
            return name;
        }
    }
}