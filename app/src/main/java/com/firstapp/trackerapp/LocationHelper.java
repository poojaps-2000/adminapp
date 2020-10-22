package com.firstapp.trackerapp;

public class LocationHelper {
    private double Longitude;
    private double Latitude;
    private  String busId;

    public LocationHelper(double longitude, double latitude,String busId,String password) {
        Longitude = longitude;
        Latitude = latitude;

    }

        public LocationHelper(double longitude, double latitude) {
        Longitude = longitude;
        Latitude = latitude;
    }

    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(double longitude) {
        Longitude = longitude;
    }

    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double latitude) {
        Latitude = latitude;
    }
}
