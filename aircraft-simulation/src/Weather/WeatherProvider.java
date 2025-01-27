package Weather;

import java.util.Random;

public class WeatherProvider {
    private static final String[] WEATHER_CONDITIONS = {
        "Sunny", "Rainy", "Foggy", "Snowy"
    };
    
    private Random random;

    public WeatherProvider() {
        this.random = new Random();
    }

    public String getWeather() {
        return WEATHER_CONDITIONS[random.nextInt(WEATHER_CONDITIONS.length)];
    }
}