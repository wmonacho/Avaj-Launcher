package aircraft;

import flyable.Flyable;
import weather.WeatherTower;
import simulator.SimulationLogger;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public Helicopter(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);

        switch (weather) {
            case "SUN":
                coordinates = new Coordinates(
                    coordinates.getLongitude() + 10,
                    coordinates.getLatitude(),
                    Math.min(coordinates.getHeight() + 2, 100)
                );
                SimulationLogger.log(getClass().getSimpleName() + "#" + getName() + "(" + getId() + "): This is hot.");
                break;
            case "RAIN":
                coordinates = new Coordinates(
                    coordinates.getLongitude() + 5,
                    coordinates.getLatitude(),
                    coordinates.getHeight()
                );
                SimulationLogger.log(getClass().getSimpleName() + "#" + getName() + "(" + getId() + "): It's raining. Watch out!");
                break;
            case "FOG":
                coordinates = new Coordinates(
                    coordinates.getLongitude() + 1,
                    coordinates.getLatitude(),
                    coordinates.getHeight()
                );
                SimulationLogger.log(getClass().getSimpleName() + "#" + getName() + "(" + getId() + "): Can't see anything.");
                break;
            case "SNOW":
                coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude(),
                    coordinates.getHeight() - 12
                );
                SimulationLogger.log(getClass().getSimpleName() + "#" + getName() + "(" + getId() + "): My rotor is going to freeze!");
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