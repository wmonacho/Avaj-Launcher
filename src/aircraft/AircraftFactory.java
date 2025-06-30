package aircraft;

import flyable.Flyable;

public class AircraftFactory {
    private static long idCounter = 1;

    public static Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
        long id = idCounter++;
        switch (p_type.toLowerCase()) {
            case "baloon": return new Baloon(id, p_name, p_coordinates);
            case "jetplane": return new JetPlane(id, p_name, p_coordinates);
            case "helicopter": return new Helicopter(id, p_name, p_coordinates);
            default: throw new IllegalArgumentException("Unknown type: " + p_type);
        }
    }
}