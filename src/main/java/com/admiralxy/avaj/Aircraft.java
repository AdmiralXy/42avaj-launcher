package com.admiralxy.avaj;

import java.util.HashMap;

public class Aircraft {
    protected final long id;
    protected final String name;
    protected final Coordinates coordinates;
    private static long idCounter = 0;

    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        this.id = nextId();
    }

    private long nextId() {
        return ++idCounter;
    }

    protected void updateCoordinates(String weather, HashMap<String, Coordinates> weatherChanges) {
        Coordinates change = weatherChanges.get(weather);
        coordinates.setLongitude(coordinates.getLongitude() + change.getLongitude());
        coordinates.setLatitude(coordinates.getLatitude() + change.getLatitude());
        coordinates.setHeight(coordinates.getHeight() + change.getHeight());
    }
}
