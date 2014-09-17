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
        WATER("Water"),
        FUR("Fur"),
        FOOD("Food"),
        ORE("Ore"),
        GAMES("Games"),
        FIREARMS("Firearms"),
        MEDICINE("Medicine"),
        MACHINES("Machines"),
        NARCOTICS("Narcotics"),
        ROBOTS("Robots");
        
        private final String name;
        
        Good(String n){
            this.name = n;
        }
        
        @Override
        public String toString(){
            return name;
        }
    }
    public enum StarSystem{
        A("Rush Galaxy"),
        B("Bastille System"),
        C("Weezer Cluster"),
        D("Queen Sector"),
        E("Muse Nebula"),
        F("Incubus System"),
        G("Boston Sector"),
        H("Oasis Galaxy"),
        I("AC/DC Quadrant"),
        J("Nirvana Quadrant"),
        K("Silversun System"),
        L("Rolling Stones Cluster"), 
        M("Psy Nebula");
        
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