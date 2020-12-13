package study.moon.test;

class Place {
    int latitude;
    int longitude;
    int altitude;

    public Place(int latitude, int longitude, int altitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
    }

    public void changePlace(int latitude, int longitude, int altitude) {
        this.latitude += latitude;
        this.longitude += longitude;
        this.altitude += altitude;
    }

}
