package Aircraft;

public class Balloon extends Aircraft {
    private String balloonSize;

    public Balloon(String name, int currentAltitude, String balloonSize) {
        super(name, currentAltitude);
        this.balloonSize = balloonSize;
    }

    @Override
    public void fly() {
        // Implement the flying logic for the balloon
        System.out.println(getName() + " is floating in the sky at " + getCurrentAltitude() + " meters.");
    }

    @Override
    public void land() {
        // Implement the landing logic for the balloon
        System.out.println(getName() + " is landing.");
    }

    @Override
    public String getStatus() {
        return "Balloon: " + getName() + ", Altitude: " + getCurrentAltitude() + " meters, Size: " + balloonSize;
    }
}