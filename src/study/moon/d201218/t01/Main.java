package study.moon.d201218.t01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://www.acmicpc.net/problem/15686
public class Main {

    static int arrLength;
    static int[][] arr;

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        arrLength = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        arr = new int[arrLength][arrLength];
        List<Place> chickens = new ArrayList<>();

        for (int i = 0; i < arrLength; i++) {
            String[] s1 = br.readLine().split(" ");
            for (int j = 0; j < arrLength; j++) {
                arr[i][j] = Integer.parseInt(s1[j]);
                if (arr[i][j] == 2) {
                    chickens.add(new Place(i, j));
                }
            }
        }

        int n = chickens.size();
        int r = m;
        boolean[] visited = new boolean[n];
        combination(chickens, visited, 0, n, r);
        bw.write(answer+"");
        bw.flush();
        bw.close();
    }

    static void combination(List<Place> chickens, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            combPrint(chickens, visited, n);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(chickens, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    static void combPrint(List<Place> chickens, boolean[] visited, int n) {
        int sum = 0;
        int[][] distance = new int[arrLength][arrLength];
        for (int i = 0; i < arrLength; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                for (int j = 0; j < arrLength; j++) {
                    for (int k = 0; k < arrLength; k++) {
                        if (arr[j][k] == 1) {
                            int chickenLength = chickens.get(i).getDistanceWith(j, k);
                            if (distance[j][k] > chickenLength) {
                                distance[j][k] = chickenLength;
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < arrLength; i++) {
            for (int j = 0; j < arrLength; j++) {
                if (distance[i][j]!=Integer.MAX_VALUE) {
                    sum += distance[i][j];
                }
            }
        }

        if (answer > sum) {
            answer = sum;
        }
    }
}

class Place {

    int x;
    int y;

    public Place(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getDistanceWith(int x, int y) {
        return Math.abs(this.x - x) + Math.abs(this.y - y);
    }
}



