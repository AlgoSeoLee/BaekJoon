package study.moon.test;

public class Animal {
    String name;
    Place place;

    public Animal() {
        this("animal",new Place(0,0,0));
    }

    public Animal(String name) {
        this(name,new Place(0,0,0));
    }

    public Animal(String name, Place place) {
        this.name = name;
        this.place = place;
    }

    public void move(int latitude, int longitude, int altitude) {
        place.changePlace(latitude,longitude,altitude);
    }

}
