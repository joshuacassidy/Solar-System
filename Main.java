import java.io.*;
import java.util.*;

public class Main {

    private static Map<CelestialBody.Key, CelestialBody> solarSystem = new HashMap<>();
    private static Set<CelestialBody> planets = new HashSet<>();
    private static Set<CelestialBody> moons = new HashSet<>();

    public static void main(String[] args) throws IOException,ClassNotFoundException {
        CelestialBody temp;
        CelestialBody tempMoon;

        try(ObjectInputStream planetsFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("src/Planets.dat"))); ObjectInputStream moonsFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("src/Moons.dat")))) {
            boolean planetEof = false;
            boolean moonsEof = false;

            while(!planetEof) {
                try {
                    Object planetData = planetsFile.readObject();
                    String[] data = planetData.toString().split(",");
                    temp = new Planet(data[0], Double.parseDouble(data[1]));
                    addValues(temp, planets);
                } catch (EOFException e) {
                    planetEof = true;
                }
            }

            while(!moonsEof) {
                try {
                    Object moonData = moonsFile.readObject();
                    String[] data = moonData.toString().split(",");
                    tempMoon = new Moon(data[0], Double.parseDouble(data[1]));
                    addValues(tempMoon, moons);
                } catch (EOFException e) {
                    moonsEof = true;
                }
            }
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
