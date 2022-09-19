package com.admiralxy.avaj;

import java.util.HashMap;

public class AircraftFactory {

    private static final HashMap<String, String> md5Hashes = new HashMap<>() {{
        put("2ab8b43468e8b92b0fc5c81e70e35a2d", "Helicopter");
        put("554cd647d6b135f7e36ab1214c5e816a", "JetPlane");
        put("502dd302b6d8d3c24b20ee49e2d51bd1", "Balloon");
    }};

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        if (md5Hashes.containsKey(type))
            type = md5Hashes.get(type);
        return switch (type) {
            case "Balloon" -> new Balloon(name, coordinates);
            case "JetPlane" -> new JetPlane(name, coordinates);
            case "Helicopter" -> new Helicopter(name, coordinates);
            default -> throw new AircraftNotFoundException("Aircraft type '" + type + "' not supported");
        };
    }
}
