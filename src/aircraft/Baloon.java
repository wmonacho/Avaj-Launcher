package aircraft;

import flyable.Flyable;
import weather.WeatherTower;
import simulator.SimulationLogger;

public class Baloon extends Aircraft implements Flyable {
    protected WeatherTower weatherTower;

    public Baloon(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);

        switch (weather) {
            case "SUN":
                coordinates = new Coordinates(
                    coordinates.getLongitude() + 2,
                    coordinates.getLatitude(),
                    Math.min(coordinates.getHeight() + 4, 100)
                );
                SimulationLogger.log(getClass().getSimpleName() + "#" + getName() + "(" + getId() + "): Let's enjoy the good weather and take some pics.");
                break;
            case "RAIN":
                coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude(),
                    coordinates.getHeight() - 5
                );
                SimulationLogger.log(getClass().getSimpleName() + "#" + getName() + "(" + getId() + "): Damn you rain! You messed up my baloon.");
                break;
            case "FOG":
                coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude(),
                    coordinates.getHeight() - 3
                );
                SimulationLogger.log(getClass().getSimpleName() + "#" + getName() + "(" + getId() + "): I can't see anything!");
                break;
            case "SNOW":
                coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude(),
                    coordinates.getHeight() - 15
                );
                SimulationLogger.log(getClass().getSimpleName() + "#" + getName() + "(" + getId() + "): It's snowing. We're gonna crash.");
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