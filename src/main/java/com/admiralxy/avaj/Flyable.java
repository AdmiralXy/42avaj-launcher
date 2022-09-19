package com.admiralxy.avaj;

public interface Flyable {
    void updateConditions();
    void registerTower(WeatherTower weatherTower);
    Coordinates getCoordinates();
}
