package com.admiralxy.avaj;

import java.util.HashMap;

public class Balloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    private static final HashMap<String, String> weatherMessages = new HashMap<>() {{
        put("SUN", "Sun, I feel warm and comfortable.");
        put("RAIN", "It's raining.");
        put("FOG", "Fog around us.");
        put("SNOW", "Cold, -12 degrees Celsius.");
    }};

    private static final HashMap<String, Coordinates> weatherChanges = new HashMap<>() {{
        put("SUN", new Coordinates(2, 0, 4));
        put("RAIN", new Coordinates(0, 0, -5));
        put("FOG", new Coordinates(0, 0, -3));
        put("SNOW", new Coordinates(0, 0, -15));
    }};

    Balloon(String name, Coordinates coordinates) {
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
        return String.format("Balloon#%s(%d)", name, id);
    }
}
