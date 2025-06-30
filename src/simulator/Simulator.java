package simulator;

import weather.WeatherTower;
import weather.WeatherProvider;
import aircraft.Baloon;
import aircraft.JetPlane;
import aircraft.Helicopter;
import aircraft.Coordinates;
import flyable.Flyable;
import java.io.*;
import java.util.*;

public class Simulator {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java simulator.Simulator scenario.txt");
            return;
        }

        String scenarioFile = args[0];
        List<Flyable> flyables = new ArrayList<>();
        WeatherTower weatherTower = new WeatherTower();

        try (BufferedReader br = new BufferedReader(new FileReader(scenarioFile))) {
            String line = br.readLine();
            if (line == null) throw new Exception("Scenario file is empty.");
            int cycles = Integer.parseInt(line.trim());
            long id = 1;

            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("//")) continue;
                String[] parts = line.split("\\s+");
                if (parts.length != 5) throw new Exception("Invalid scenario line: " + line);

                String type = parts[0];
                String name = parts[1];
                int longitude = Integer.parseInt(parts[2]);
                int latitude = Integer.parseInt(parts[3]);
                int height = Integer.parseInt(parts[4]);
                if (longitude < 0 || latitude < 0 || height < 0) {
                    System.out.println("Error: Coordinates must be positive.");
                    return;
                }
                if (height > 100) height = 100;
                Coordinates coords = new Coordinates(longitude, latitude, height);

                Flyable flyable;
                switch (type.toLowerCase()) {
                    case "baloon":
                        flyable = new Baloon(id, name, coords);
                        break;
                    case "jetplane":
                        flyable = new JetPlane(id, name, coords);
                        break;
                    case "helicopter":
                        flyable = new Helicopter(id, name, coords);
                        break;
                    default:
                        throw new Exception("Unknown aircraft type: " + type);
                }
                flyables.add(flyable);
                weatherTower.register(flyable);
                flyable.registerTower(weatherTower);
                id++;
            }

            for (int i = 0; i < cycles; i++) {
                weatherTower.changeWeather();
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format in scenario file.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}