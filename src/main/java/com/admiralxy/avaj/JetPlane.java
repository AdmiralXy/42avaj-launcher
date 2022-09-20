package com.admiralxy.avaj;

import java.util.HashMap;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    private static final HashMap<String, String> weatherMessages = new HashMap<>() {{
        put("SUN", "The sun is always good.");
        put("RAIN", "Rain will reduce our efficiency.");
        put("FOG", "The fog is not good. We need to watch out.");
        put("SNOW", "It's cold in here, something needs to be done about it.");
    }};

    private static final HashMap<String, Coordinates> weatherChanges = new HashMap<>() {{
        put("SUN", new Coordinates(10, 0, 2));
        put("RAIN", new Coordinates(5, 0, 0));
        put("FOG", new Coordinates(1, 0, 0));
        put("SNOW", new Coordinates(0, 0, -7));
    }};

    JetPlane(String name, Coordinates coordinates) {
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
        return String.format("JetPlane#%s(%d)", name, id);
    }
}
