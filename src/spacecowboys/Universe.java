package spacecowboys;

import spacecowboys.ConstantData.Government;
import spacecowboys.ConstantData.Resource;
import spacecowboys.ConstantData.TechLevel;
import spacecowboys.ConstantData.Moon;
import spacecowboys.ConstantData.StarSystem;
import economy.Good.Value;

public class Universe{
	
    private final Planet Zoness;
    private final Planet Aurum;
    private final Planet Ferox;
    private final Planet Kohilint;
    private final Planet Mayonaka;
    private final Planet Reploid;
    private final Planet Kracko;
    private final Planet Tanooki;
    private final Planet Mechonis;
    private final Planet Hadouken;
    private final Planet Heihachi;
    private final Planet Arkham;
    private final Planet Chiliad;
    private final Planet Haken;
    private final Planet Foxhound;
    private final Planet Rogueport;
    private final Planet Umbrella;
    private final Planet Hocotate;
    private final Planet Gaia;
    private final Planet Zebes;
    private final Planet Evershade;
    private final Planet Tortimer;
    private final Planet Belmont;
    private final Planet Kanto;
    private final Planet Wisp;
    private final Planet Megami;
    
    public Universe(){
        
        this.Zoness = new Planet("Zoness", Resource.LOTSOFWATER, TechLevel.RENAISSANCE, Government.COMMUNIST, Moon.UNUSED, 8, 5, 8, StarSystem.RUSH, 56, 111, new Value[]{Value.C, Value.N, Value.C, Value.S, Value.R, Value.R, Value.S, Value.N, Value.N, Value.N});        
        this.Aurum = new Planet("Aurum", Resource.MINERALPOOR, TechLevel.PREAGRICULTURE, Government.CYBERNETIC, Moon.UNUSED, 0, 3, 3, StarSystem.RUSH, 84, 129, new Value[] {Value.N, Value.S, Value.N, Value.S, Value.R, Value.N, Value.N, Value.C, Value.R, Value.C});        
        this.Ferox = new Planet("Ferox", Resource.DESERT, TechLevel.POSTINDUSTRIAL, Government.DEMOCRACY, Moon.NOMOON, 9, 4, 1, StarSystem.BASTILLE, 71, 182, new Value[] {Value.S, Value.N, Value.R, Value.C, Value.N, Value.C, Value.N, Value.R, Value.S, Value.N});        
        this.Kohilint = new Planet("Koholint", Resource.WEIRDMUSHROOMS, TechLevel.MEDIEVAL, Government.SATORI, Moon.UNUSED, 9, 6, 2, StarSystem.BASTILLE, 84, 53, new Value[] {Value.R, Value.N, Value.R, Value.S, Value.S, Value.N, Value.C, Value.N, Value.C, Value.N});        
        this.Mayonaka = new Planet("Mayonaka", Resource.NORESOURCES, TechLevel.MEDIEVAL, Government.THEO, Moon.MOONBASE, 9, 7, 6, StarSystem.WEEZER, 66, 180, new Value[] {Value.C, Value.C, Value.N, Value.S, Value.N, Value.R, Value.S, Value.N, Value.R, Value.N});        
        this.Reploid = new Planet("Reploid", Resource.DESERT, TechLevel.HITECH, Government.CONFEDERATE, Moon.MOONBASE, 2, 5, 5, StarSystem.WEEZER, 185, 103, new Value[] {Value.S, Value.N, Value.R, Value.N, Value.S, Value.R, Value.C, Value.N, Value.N, Value.N});
        this.Kracko = new Planet("Kracko", Resource.POORSOIL, TechLevel.HITECH, Government.DEMOCRACY, Moon.UNUSED, 1, 4, 8, StarSystem.QUEEN, 54, 32, new Value[] {Value.N, Value.R, Value.S, Value.C, Value.N, Value.N, Value.R, Value.S, Value.N, Value.C});
        this.Tanooki = new Planet("Tanooki", Resource.WEIRDMUSHROOMS, TechLevel.AGRICULTURE, Government.PACIFIST, Moon.MOONBASE, 4, 5, 7, StarSystem.QUEEN, 20, 121, new Value[] {Value.S, Value.C, Value.S, Value.N, Value.R, Value.N, Value.R, Value.N, Value.C, Value.N});
        this.Mechonis = new Planet("Mechonis", Resource.RICHSOIL, TechLevel.RENAISSANCE, Government.CYBERNETIC, Moon.NOMOON, 1, 7, 0, StarSystem.MUSE, 109, 167, new Value[] {Value.S, Value.N, Value.R, Value.R, Value.N, Value.C, Value.N, Value.S, Value.N, Value.C});
        this.Hadouken = new Planet("Hadouken", Resource.NORESOURCES, TechLevel.PREAGRICULTURE, Government.DICTATORSHIP, Moon.MOONBASE, 6, 2, 2, StarSystem.MUSE, 83, 58, new Value[] {Value.R, Value.C, Value.C, Value.N, Value.S, Value.N, Value.S, Value.N, Value.R, Value.N});
        this.Heihachi = new Planet("Heihachi", Resource.DESERT, TechLevel.RENAISSANCE, Government.COMMUNIST, Moon.GOVSATELLITE, 6, 7, 7, StarSystem.INCUBUS, 123, 141, new Value[] {Value.S, Value.R, Value.R, Value.N, Value.S, Value.C, Value.N, Value.C, Value.N, Value.N});
        this.Arkham = new Planet("Arkham", Resource.NORESOURCES, TechLevel.POSTINDUSTRIAL, Government.MILITARY, Moon.MOONBASE, 3, 0, 0, StarSystem.INCUBUS, 85, 6, new Value[] {Value.S, Value.N, Value.S, Value.R, Value.N, Value.C, Value.R, Value.C, Value.N, Value.N});
        this.Chiliad = new Planet("Chiliad", Resource.POORSOIL, TechLevel.INDUSTRIAL, Government.SOCIALIST, Moon.UNUSED, 7, 9, 5, StarSystem.BOSTON, 16, 80, new Value[] {Value.N, Value.R, Value.S, Value.S, Value.C, Value.N, Value.N, Value.C, Value.R, Value.N});
        this.Haken = new Planet("Haken", Resource.MINERALPOOR, TechLevel.INDUSTRIAL, Government.PACIFIST, Moon.NOMOON, 9, 4, 5, StarSystem.BOSTON, 34, 111, new Value[] {Value.N, Value.C, Value.N, Value.S, Value.S, Value.N, Value.C, Value.R, Value.N, Value.R});
        this.Foxhound = new Planet("Foxhound", Resource.MINERALRICH, TechLevel.RENAISSANCE, Government.FASCIST, Moon.MOONBASE, 3, 5, 1, StarSystem.OASIS, 112, 183, new Value[] {Value.N, Value.C, Value.N, Value.C, Value.R, Value.R, Value.S, Value.S, Value.N, Value.N});
        this.Rogueport = new Planet("Rogueport", Resource.WARLIKE, TechLevel.HITECH, Government.ANARCHY, Moon.NOMOON, 6, 3, 3, StarSystem.OASIS, 179, 112, new Value[] {Value.N, Value.C, Value.N, Value.N, Value.C, Value.S, Value.R, Value.R, Value.N, Value.S});
        this.Umbrella = new Planet("Umbrella", Resource.DESERT, TechLevel.HITECH, Government.COMMUNIST, Moon.NOMOON, 2, 1, 0, StarSystem.ACDC, 83, 183, new Value[] {Value.S, Value.R, Value.R, Value.N, Value.S, Value.N, Value.N, Value.C, Value.N, Value.C});
        this.Hocotate = new Planet("Hocotate", Resource.NORESOURCES, TechLevel.POSTINDUSTRIAL, Government.CORPORATE, Moon.MOONBASE, 0, 4, 3, StarSystem.ACDC, 22, 162, new Value[] {Value.N, Value.N, Value.C, Value.S, Value.N, Value.C, Value.N, Value.R, Value.R, Value.S});
        this.Gaia = new Planet("Gaia", Resource.DESERT, TechLevel.EARLYINDUSTRIAL, Government.THEO, Moon.MOONBASE, 6, 3, 8, StarSystem.NIRVANA, 136, 96, new Value[] {Value.S, Value.N, Value.N, Value.C, Value.N, Value.R, Value.C, Value.S, Value.R, Value.N});
        this.Zebes = new Planet("Zebes", Resource.LIFELESS, TechLevel.MEDIEVAL, Government.SOCIALIST, Moon.GOVSATELLITE, 0, 1, 6, StarSystem.NIRVANA, 101, 17, new Value[] {Value.N, Value.R, Value.R, Value.C, Value.N, Value.S, Value.S, Value.N, Value.N, Value.C});
        this.Evershade = new Planet("Evershade", Resource.LIFELESS, TechLevel.MEDIEVAL, Government.PACIFIST, Moon.MOONBASE, 9, 0, 4, StarSystem.SILVERSUN, 98, 176, new Value[] {Value.S, Value.S, Value.N, Value.C, Value.C, Value.N, Value.R, Value.N, Value.R, Value.N});
        this.Tortimer = new Planet("Tortimer", Resource.MINERALPOOR, TechLevel.MEDIEVAL, Government.COMMUNIST, Moon.MOONBASE, 5, 0, 9, StarSystem.SILVERSUN, 61, 135, new Value[] {Value.C, Value.N, Value.R, Value.R, Value.N, Value.C, Value.S, Value.S, Value.N, Value.N});
        this.Belmont = new Planet("Belmont", Resource.POORSOIL, TechLevel.EARLYINDUSTRIAL, Government.MONARCHY, Moon.UNUSED, 4, 6, 4, StarSystem.ROLLINGSTONES, 100, 96, new Value[] {Value.C, Value.S, Value.R, Value.N, Value.N, Value.C, Value.N, Value.R, Value.S, Value.N});
        this.Kanto = new Planet("Kanto", Resource.RICHFAUNA, TechLevel.HITECH, Government.CONFEDERATE, Moon.UNUSED, 6, 8, 4, StarSystem.ROLLINGSTONES, 133, 118, new Value[] {Value.C, Value.C, Value.N, Value.S, Value.N, Value.C, Value.S, Value.R, Value.S, Value.R});
        this.Wisp = new Planet("Wisp", Resource.WARLIKE, TechLevel.MEDIEVAL, Government.DEMOCRACY, Moon.GOVSATELLITE, 3, 4, 1, StarSystem.PSY, 185, 11, new Value[] {Value.C, Value.N, Value.R, Value.N, Value.N, Value.C, Value.S, Value.S, Value.R, Value.N});
        this.Megami = new Planet("Megami", Resource.MINERALRICH, TechLevel.EARLYINDUSTRIAL, Government.SOCIALIST, Moon.GOVSATELLITE, 9, 0, 8, StarSystem.PSY, 31, 75, new Value[] {Value.C, Value.R, Value.N, Value.C, Value.R, Value.N, Value.N, Value.S, Value.N, Value.S});
    }
    
    
    public Planet[] getPlanets(){
        Planet[] universe = new Planet[26];
        universe[0] = Zoness;
        universe[1] = Aurum;
        universe[2] = Ferox;
        universe[3] = Kohilint;
        universe[4] = Mayonaka;
        universe[5] = Reploid;
        universe[6] = Kracko;
        universe[7] = Tanooki;
        universe[8] = Mechonis;
        universe[9] = Hadouken;
        universe[10] = Heihachi;
        universe[11] = Arkham;
        universe[12] = Chiliad;
        universe[13] = Haken;
        universe[14] = Foxhound;
        universe[15] = Rogueport;
        universe[16] = Umbrella;
        universe[17] = Hocotate;
        universe[18] = Gaia;
        universe[19] = Zebes;
        universe[20] = Evershade;
        universe[21] = Tortimer;
        universe[22] = Belmont;
        universe[23] = Kanto;
        universe[24] = Wisp;
        universe[25] = Megami;
        return universe;
    }
    
    public Planet getFromName(String name){
    	for (int i = 0; i < 26; i++){
    		if (name.equals(getPlanets()[i].getName())){
    			return getPlanets()[i];
    		}	
    	}
    	return null;
    }
    
    private static final Universe u = new Universe();
    
    public static Universe getUniverse(){
        return u;
    }
}