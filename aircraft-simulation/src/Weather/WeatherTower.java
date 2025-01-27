package Weather;

import Flyable.Flyable;
import java.util.ArrayList;
import java.util.List;

public class WeatherTower {
    private List<Flyable> flyables;

    public WeatherTower() {
        this.flyables = new ArrayList<>();
    }

    public void registerFlyable(Flyable flyable) {
        flyables.add(flyable);
    }

    public void checkWeather() {
        for (Flyable flyable : flyables) {
            // Logic to check weather and notify flyable
            // This is a placeholder for actual weather checking logic
            flyable.fly();
        }
    }
}