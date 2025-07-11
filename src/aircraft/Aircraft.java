package aircraft;

public abstract class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;

    public Aircraft(long p_id, String p_name, Coordinates p_coordinate) {
        this.id = p_id;
        this.name = p_name;
        this.coordinates = p_coordinate;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
