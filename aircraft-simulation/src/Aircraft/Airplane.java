package Aircraft;

public class Airplane extends Aircraft {
    private double wingSpan;

    public Airplane(String name, double currentAltitude, double wingSpan) {
        super(name, currentAltitude);
        this.wingSpan = wingSpan;
    }

    @Override
    public void fly() {
        // Implementation for airplane flying
        currentAltitude += 1000; // Example altitude increase
    }

    @Override
    public void land() {
        // Implementation for airplane landing
        currentAltitude = 0; // Example landing
    }

    @Override
    public String getStatus() {
        return "Airplane " + name + " is at altitude " + currentAltitude + " with wingspan " + wingSpan;
    }

    public double getWingSpan() {
        return wingSpan;
    }

    public void setWingSpan(double wingSpan) {
        this.wingSpan = wingSpan;
    }
}