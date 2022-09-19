package com.admiralxy.avaj;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    Coordinates(int longitude, int latitude, int height) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public void setHeight(int height) {
        this.height = height;
        if (this.height < 0)
            this.height = 0;
        if (this.height > 100)
            this.height = 100;
    }

    @Override
    public String toString() {
        return String.format("Coordinates: longitude=%d, latitude=%d, height=%d", longitude, latitude, height);
    }
}
