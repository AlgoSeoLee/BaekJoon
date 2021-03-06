package study.moon.test;

public class Apple{
    private Color color;
    private int weight;
    private static final String name = "사과";

    public Apple(Color color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public static String getName() {
        return Apple.name;
    }


}
