package study.moon.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        List<Apple> apples = new ArrayList<>(List.of(
            new Apple(Color.RED, 100),
            new Apple(Color.RED, 130),
            new Apple(Color.RED, 180),
            new Apple(Color.GREEN, 190),
            new Apple(Color.GREEN, 150),
            new Apple(Color.GREEN, 140),
            new Apple(Color.RED, 110),
            new Apple(Color.YELLOW, 120),
            new Apple(Color.YELLOW, 160),
            new Apple(Color.RED, 230)
        ));

        Integer[] integers = apples.stream().map(Apple::getWeight).toArray(Integer[]::new);

    }

    private static List<Apple> filterApples(List<Apple> apples, ApplePredicate predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}

