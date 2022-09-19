package com.admiralxy.avaj;

import java.util.ArrayList;
import java.util.List;

public abstract class Tower {

    private final List<Flyable> observers = new ArrayList<>();

    public void register(Flyable flyable) {
        observers.add(flyable);
        Logger.getInstance().log("Tower says: " + flyable + " registered to weather tower.");
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
        Logger.getInstance().log(flyable + ": landing. " + flyable.getCoordinates());
        Logger.getInstance().log("Tower says: " + flyable + " unregistered from weather tower.");
    }

    protected void conditionsChanged() {
        for (Flyable flyable : new ArrayList<>(observers)) {
            flyable.updateConditions();
        }
    }

    public int getObserversCount() {
        return observers.size();
    }
}