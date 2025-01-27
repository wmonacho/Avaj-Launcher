package Aircraft;

public class Helicopter extends Aircraft {
    private int rotorCount;

    public Helicopter(String name, int currentAltitude, int rotorCount) {
        super(name, currentAltitude);
        this.rotorCount = rotorCount;
    }

    @Override
    public void fly() {
        // Implement helicopter-specific flying behavior
        System.out.println(getName() + " is flying with " + rotorCount + " rotors.");
    }

    @Override
    public void land() {
        // Implement helicopter-specific landing behavior
        System.out.println(getName() + " is landing.");
    }

    @Override
    public String getStatus() {
        return "Helicopter " + getName() + " at altitude " + getCurrentAltitude() + " with " + rotorCount + " rotors.";
    }
}