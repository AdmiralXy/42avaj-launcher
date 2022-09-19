package com.admiralxy.avaj;

import java.util.HashMap;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    private static final HashMap<String, String> weatherMessages = new HashMap<>() {{
        put("SUN", "Sunny day.");
        put("RAIN", "Rain rain go away.");
        put("FOG", "Smells like fog.");
        put("SNOW", "Winter is coming. We need more dragons.");
    }};

    private static final HashMap<String, Coordinates> weatherChanges = new HashMap<>() {{
        put("SUN", new Coordinates(10, 0, 2));
        put("RAIN", new Coordinates(5, 0, 0));
        put("FOG", new Coordinates(1, 0, 0));
        put("SNOW", new Coordinates(0, 0, -12));
    }};

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        updateCoordinates(weather, weatherChanges);
        if (coordinates.getHeight() < 1) {
            weatherTower.unregister(this);
        } else {
            Logger.getInstance().log(String.format("%s: %s", this, weatherMessages.get(weather)));
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
    }

    @Override
    public Coordinates getCoordinates() {
        return coordinates;
    }

    @Override
    public String toString() {
        return String.format("Helicopter#%s(%d)", name, id);
    }
}
