import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    private static Map<CelestialBody.Key, CelestialBody> solarSystem = new HashMap<>();
    private static Set<CelestialBody> planets = new HashSet<>();
    private static Set<CelestialBody> moons = new HashSet<>();

    public static void main(String[] args) {

        String[] planetNames = {"Mercury","Venus","Earth","Mars","Jupiter","Saturn","Uranus","Neptune","Pluto"};
        int[] planetOrbitalPeriods = {88,225,365,687,4332,10759,30660,165,248};

        String[] moonNames = {"Moon","Deimos","Phobos","Io","Europa","Ganymede","Callisto"};
        double[] moonOrbitalPeriods = {27,1.3,0.3,1.8,3.5,7.1,16.7};
        CelestialBody temp;
        CelestialBody tempMoon;

        for(int i = 0; i < moonNames.length; i++){
            temp = new Planet(planetNames[i],planetOrbitalPeriods[i]);
            solarSystem.put(temp.getKey(),temp);
            planets.add(temp);

        }

        for(int j = 0; j < moonNames.length; j++){
            tempMoon = new Moon(moonNames[j],moonOrbitalPeriods[j]);
            solarSystem.put(tempMoon.getKey(),tempMoon);
            moons.add(tempMoon);
        }


        System.out.println("All moons");
        for(CelestialBody moon: moons){
            System.out.println("\t" + moon);
        }

        System.out.println("Planets");
        for (CelestialBody planet: planets){
            System.out.println("\t" + planet);
        }

        System.out.println("Contents of the solar system: ");
        for (CelestialBody s: solarSystem.values()){
            System.out.println("\t" + s);
        }



    }
}
