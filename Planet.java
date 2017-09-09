public class Planet extends CelestialBody {
    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyTypes.PLANET);
    }

    @Override
    public boolean addSatellite(CelestialBody moon) {
        return moon.getKey().getBodyType() == BodyTypes.MOON ? super.addSatellite(moon) : false;
    }
}
