package flyable;

import weather.WeatherTower;

public interface Flyable {
    void updateConditions();
    void registerTower(WeatherTower p_tower);
    String getName();
    long getId();
}