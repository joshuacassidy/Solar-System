import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {

    private static Map<CelestialBody.Key, CelestialBody> solarSystem = new HashMap<>();
    private static Set<CelestialBody> planets = new HashSet<>();
    private static Set<CelestialBody> moons = new HashSet<>();

    public static void main(String[] args) throws IOException {

        String[] planetNames = {"Mercury","Venus","Earth","Mars","Jupiter","Saturn","Uranus","Neptune","Pluto"};
        int[] planetOrbitalPeriods = {88,225,365,687,4332,10759,30660,165,248};

        String[] moonNames = {"Moon","Deimos","Phobos","Io","Europa","Ganymede","Callisto"};
        double[] moonOrbitalPeriods = {27,1.3,0.3,1.8,3.5,7.1,16.7};
        CelestialBody temp;
        CelestialBody tempMoon;
        
        try(FileWriter planetsFile = new FileWriter("src/Planets.txt");
            FileWriter TransactionsFile = new FileWriter("src/Moon.txt")) {
                for(int i = 0; i< planetNames.length; i++) {
                    planetsFile.write(String.format("%s, %s\n",planetNames[i],planetOrbitalPeriods[i]));
                }
                for(int i = 0; i< moonNames.length; i++) {
                TransactionsFile.write(String.format("%s, %s\n",moonNames[i], moonOrbitalPeriods[i]));
                }
        }

        for(int i = 0; i < planetNames.length; i++){
            temp = new Planet(planetNames[i],planetOrbitalPeriods[i]);
            addValues(temp,planets);
        }

        for(int i = 0; i < moonNames.length; i++){
            tempMoon = new Moon(moonNames[i],moonOrbitalPeriods[i]);
            addValues(tempMoon,moons);
        }

        printCelestialBody(moons,"Moons in this solar system: ");
        printCelestialBody(planets,"\n\nPlanets in this solar system: ");
        printCelestialBody( solarSystem.values(),"\n\nMoons and planets in the solar system: ");


    }

    public static void addValues(CelestialBody temp,  Set<CelestialBody> bodyType){
        solarSystem.put(temp.getKey(),temp);
        bodyType.add(temp);
    }

    public static void printCelestialBody(Collection celestialBodys, String Message){
        System.out.println(Message);
        for(Object celestialBody: celestialBodys){
            System.out.println("\t" + celestialBody);
        }
    }
}
