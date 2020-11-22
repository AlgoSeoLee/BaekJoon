package study.moon.test;

public class Truck extends Car {
    String engine;

    public Truck(String name) {
        super(name);
    }

    public Truck(String name, String engine) {
        super(name);
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "engine='" + engine + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
