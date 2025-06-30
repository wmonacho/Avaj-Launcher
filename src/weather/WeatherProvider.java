package weather;

import aircraft.Coordinates;

public class WeatherProvider {
    private static WeatherProvider provider = new WeatherProvider();
    private String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};

    private WeatherProvider() {}

    public static WeatherProvider getProvider() {
        return provider;
    }

    public String getCurrentWeather(Coordinates p_coordinates) {
        int seed = (p_coordinates.getLongitude() + p_coordinates.getLatitude() + p_coordinates.getHeight()) % 4;
        return weather[seed];
    }
}