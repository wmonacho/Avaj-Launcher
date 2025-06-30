package weather;

import flyable.Flyable;
import java.util.ArrayList;
import java.util.List;
import simulator.SimulationLogger;

public abstract class Tower {
    private List<Flyable> observers = new ArrayList<>();

    public void register(Flyable p_flyable) {
        observers.add(p_flyable);
        SimulationLogger.log(
            "Tower says: " + p_flyable.getClass().getSimpleName() + "#" +
            p_flyable.getName() + "(" + p_flyable.getId() + ") registered to weather tower."
        );
    }

    public void unregister(Flyable p_flyable) {
        observers.remove(p_flyable);
        SimulationLogger.log(
            "Tower says: " + p_flyable.getClass().getSimpleName() + "#" +
            p_flyable.getName() + "(" + p_flyable.getId() + ") unregistered from weather tower."
        );
    }

    protected void conditionChanged() {
        for (Flyable flyable : new ArrayList<>(observers)) {
            flyable.updateConditions();
        }
    }
}