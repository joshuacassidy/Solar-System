public class Planet extends CelestialBody {
    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyTypes.PLANET);
    }

    @Override
    public boolean addSatellite(CelestialBody moon) {
        if (moon.getKey().getBodyType() == BodyTypes.MOON){
            return super.addSatellite(moon);
        }else{
            return false;
        }
    }
}
