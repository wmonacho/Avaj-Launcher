public abstract class Aircraft {
    protected String name;
    protected int currentAltitude;

    public Aircraft(String name) {
        this.name = name;
        this.currentAltitude = 0;
    }

    public abstract void fly();

    public void land() {
        currentAltitude = 0;
        System.out.println(name + " has landed.");
    }

    public String getStatus() {
        return name + " is currently at an altitude of " + currentAltitude + " meters.";
    }

    public String getName() {
        return name;
    }

    public int getCurrentAltitude() {
        return currentAltitude;
    }

    protected void setCurrentAltitude(int altitude) {
        this.currentAltitude = altitude;
    }
}