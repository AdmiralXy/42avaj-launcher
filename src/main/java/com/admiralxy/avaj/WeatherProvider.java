package com.admiralxy.avaj;

public class WeatherProvider {
    private static final WeatherProvider weatherProvider = new WeatherProvider();

    private static final String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider() {
    }

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int sum = coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight();
        return weather[sum % 4];
    }
}
