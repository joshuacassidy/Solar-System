import java.io.*;
import java.util.*;

public class Main {

    private static Map<CelestialBody.Key, CelestialBody> solarSystem = new HashMap<>();
    private static Set<CelestialBody> planets = new HashSet<>();
    private static Set<CelestialBody> moons = new HashSet<>();

    public static void main(String[] args) throws IOException,ClassNotFoundException {
        //No longer needed to run program
//        String[] planetNames = {"Mercury","Venus","Earth","Mars","Jupiter","Saturn","Uranus","Neptune","Pluto"};
//        int[] planetOrbitalPeriods = {88,225,365,687,4332,10759,30660,165,248};
//
//        String[] moonNames = {"Moon","Deimos","Phobos","Io","Europa","Ganymede","Callisto"};
//        double[] moonOrbitalPeriods = {27,1.3,0.3,1.8,3.5,7.1,16.7};
        CelestialBody temp;
        CelestialBody tempMoon;

        //For writing data to the file
//        try(FileWriter planetsFile = new FileWriter("src/Planets.txt");
//            FileWriter moonsFile = new FileWriter("src/Moons.txt")) {
//                for(int i = 0; i< planetNames.length; i++) {
//                    planetsFile.write(String.format("%s, %s\n",planetNames[i],planetOrbitalPeriods[i]));
//                }
//                for(int i = 0; i< moonNames.length; i++) {
//                moonsFile.write(String.format("%s, %s\n",moonNames[i], moonOrbitalPeriods[i]));
//                }
//        }

//        try(BufferedReader planetsFile = new BufferedReader(new FileReader("src/Planets.txt"));
//            BufferedReader moonsFile = new BufferedReader(new FileReader("src/Moons.txt"))) {
//
//
//            String planetData = planetsFile.readLine();
//            String moonsData = moonsFile.readLine();
//
//            while (planetData != null || moonsData != null ) {
//                if(planetData != null){
//                    String[] data = planetData.split(",");
//                    temp = new Planet(data[0],Double.parseDouble(data[1]));
//                    addValues(temp,planets);
//                    planetData = planetsFile.readLine();
//                } else{
//                    String[] data = moonsData.split(",");
//                    tempMoon = new Moon(data[0],Double.parseDouble(data[1]));
//                    addValues(tempMoon,moons);
//                    moonsData = moonsFile.readLine();
//                }
//
//            }
//        }

//        try (ObjectOutputStream planetsFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("Planets.dat"))); ObjectOutputStream moonsFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("Moons.dat")))) {
//
//            for(int i = 0; i < planetNames.length; i++) {
//                    planetsFile.writeObject(String.format("%s, %s\n",planetNames[i],planetOrbitalPeriods[i]));
//                }
//                for(int i = 0; i< moonNames.length; i++) {
//                    moonsFile.writeObject(String.format("%s, %s\n",moonNames[i], moonOrbitalPeriods[i]));
//                }
//        }

        try(ObjectInputStream planetsFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("src/Planets.dat"))); ObjectInputStream moonsFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("src/Moons.dat")))) {
            boolean planetEof = false;

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


                boolean moonsEof = false;
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
