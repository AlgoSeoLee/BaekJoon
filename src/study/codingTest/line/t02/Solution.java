package study.codingTest.line.t02;

import java.util.HashSet;

public class Solution {
    public String[] solution(int[][] line) {
        String[] answer = {};
        HashSet<Place> set = new HashSet<>();
        for (int i = 0; i < line[0].length - 1; i++) {
            for (int j = i; j < line[0].length - 1; j++) {
                Place place = getPlace(line[j][0], line[j][1], line[j][2], line[j + 1][0],
                    line[j + 1][1], line[j + 1][2]);
                if (place!= null) {
                    set.add(getPlace(line[j][0],line[j][1],line[j][2],line[j+1][0],line[j+1][1],line[j+1][2]));
                }
            }
        }
        System.out.println(set);
        return answer;
    }

    private Place getPlace(double a, double b, double e, double c, double d, double f) {
        if (a*d - b*c == 0) {
            return null;
        }
        double x = (b*f - e*d) / (a*d - b*c);
        double y = (e*c - a*f) / (a*d - b*c);
        if (x!=(int)x) {
            return null;
        }
        if (y!=(int)y) {
            return null;
        }
        return new Place((int)x,(int)y);
    }
}
class Place {
    int x;
    int y;

    public Place(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Place{" +
            "x=" + x +
            ", y=" + y +
            '}';
    }
}
