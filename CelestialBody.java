import java.util.HashSet;
import java.util.Set;

public abstract class CelestialBody {
    private final Key key;
    private final double orbitalPeriod;
    private final Set<CelestialBody> satellites;


    public enum BodyTypes {
        STAR,
        PLANET,
        DWARF_PLANET,
        MOON,
        COMET,
        ASTEROID
    }

    public CelestialBody(String name, double orbitalPeriod, BodyTypes bodyType) {
        this.key = new Key(name, bodyType);
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }


    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Key getKey() {
        return key;
    }


    public boolean addSatellite(CelestialBody moon) {
        return this.satellites.add(moon);
    }


    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof CelestialBody) {
            CelestialBody theObject = (CelestialBody) obj;
            return this.key.equals(theObject.getKey());
        }
        return false;

    }

    @Override
    public final int hashCode() {
        return this.key.hashCode();
    }


    @Override
    public String toString() {
        return String.format("Name: %s \n\tBodyType: %s\n\tOrbital Period: %s\n",this.key.name, this.key.bodyType, this.orbitalPeriod);
    }

    public static final class Key {
        private String name;
        private BodyTypes bodyType;

        private Key(String name, BodyTypes bodyType) {
            this.name = name;
            this.bodyType = bodyType;
        }


        public String getName() {
            return name;
        }

        public BodyTypes getBodyType() {
            return bodyType;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + 57 + this.bodyType.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            Key key = (Key) obj;
            return this.name.equals(key.getName()) && this.bodyType == key.getBodyType();

        }

        @Override
        public String toString() {
            return this.name + ": " + this.bodyType;
        }
    }
}