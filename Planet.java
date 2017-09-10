public class Planet extends CelestialBody {
    private String name;
    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyTypes.PLANET);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean addSatellite(CelestialBody moon) {
        return moon.getKey().getBodyType() == BodyTypes.MOON && super.addSatellite(moon);
    }

}
