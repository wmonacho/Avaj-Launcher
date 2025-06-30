package aircraft;

import flyable.Flyable;
import weather.WeatherTower;
import simulator.SimulationLogger;

public class JetPlane extends Aircraft implements Flyable {
    protected WeatherTower weatherTower;

    public JetPlane(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);

        switch (weather) {
            case "SUN":
                coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude() + 10,
                    Math.min(coordinates.getHeight() + 2, 100)
                );
                SimulationLogger.log(getClass().getSimpleName() + "#" + getName() + "(" + getId() + "): It's sunny. Let's fly fast!");
                break;
            case "RAIN":
                coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude() + 5,
                    coordinates.getHeight()
                );
                SimulationLogger.log(getClass().getSimpleName() + "#" + getName() + "(" + getId() + "): It's raining. Better watch out for lightings.");
                break;
            case "FOG":
                coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude() + 1,
                    coordinates.getHeight()
                );
                SimulationLogger.log(getClass().getSimpleName() + "#" + getName() + "(" + getId() + "): Can't see much in this fog.");
                break;
            case "SNOW":
                coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude(),
                    coordinates.getHeight() - 7
                );
                SimulationLogger.log(getClass().getSimpleName() + "#" + getName() + "(" + getId() + "): OMG! Winter is coming!");
                break;
        }
        if (coordinates.getHeight() <= 0) {
            SimulationLogger.log(getClass().getSimpleName() + "#" + getName() + "(" + getId() + ") landing.");
            weatherTower.unregister(this);
        }
    }

    @Override
    public void registerTower(weather.WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
    }
}