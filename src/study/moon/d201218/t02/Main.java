package study.moon.d201218.t02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
//https://www.acmicpc.net/problem/16232
public class Main {

    static int[] moveX = {-1, 0, 0, 1};
    static int[] moveY = {0, -1, 1, 0};
    static int[][] arr;
    static int n;
    static boolean[][] visit;
    static Shark shark = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visit = new boolean[n][n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
                if (arr[i][j] == 9) {
                    shark = new Shark(new Place(i, j, 0));
                }
            }
        }

        LinkedList<Place> queue = new LinkedList<>();
        while (true) {
            int time = findFish(shark, queue);
            if (time == 0) {
                break;
            }
            answer += time;
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();


    }

    private static int findFish(Shark shark, LinkedList<Place> queue) {
        List<Place> target = new ArrayList<>();
        visit = new boolean[n][n];
        int time = 100;
        queue.offer(new Place(shark.place.x, shark.place.y, 0));
        while (!queue.isEmpty()) {
            Place poll = queue.poll();
            if (!shark.canMove(poll)) {
                continue;
            }
            if (time!=100) {
                if (poll.time != time) {
                    continue;
                }
            }
            if (shark.canEat(poll)) {
                time = poll.time;
                target.add(poll);
            }
            visit[poll.x][poll.y] = true;
            for (int i = 0; i < 4; i++) {
                queue.offer(new Place(poll.x + moveX[i], poll.y + moveY[i], poll.time + 1));
            }
        }
        List<Place> collect = target.stream().sorted().collect(Collectors.toList());
        if (collect.size()==0) {
            return 0;
        }
        shark.eat(collect.get(0));
        return collect.get(0).time;
    }

    static class Shark {

        int size;
        int count;

        Place place;

        public Shark(Place place) {
            this.size = 2;
            this.place = place;
        }

        public void eat(Place place) {
            arr[place.x][place.y] = 0;
            this.place.x = place.x;
            this.place.y = place.y;
            count++;
            if (count == size) {
                size++;
                count = 0;
            }
        }

        public boolean canEat(Place place) {
            return size > arr[place.x][place.y] && arr[place.x][place.y] != 0 && arr[place.x][place.y] != 9;
        }

        public boolean canMove(Place place) {
            if (place.x < 0 || place.x >= n || place.y < 0 || place.y >= n) {
                return false;
            }
            if (visit[place.x][place.y]) {
                return false;
            }
            if (arr[place.x][place.y] == 9) {
                return true;
            }
            if (arr[place.x][place.y] > size) {
                return false;
            }
            return true;
        }
    }

    static class Place implements Comparable<Place> {

        @Override
        public int compareTo(Place o) {
            if (Math.abs(shark.place.x - x) + Math.abs(shark.place.y - y) >
                Math.abs(shark.place.x - o.x) + Math.abs(shark.place.y - o.y)
            ) {
                return 1;
            } else if (Math.abs(shark.place.x - x) + Math.abs(shark.place.y - y) <
                Math.abs(shark.place.x - o.x) + Math.abs(shark.place.y - o.y)
            ) {
                return -1;
            } else {
                if (x > o.x) {
                    return 1;
                } else if (x < o.x) {
                    return -1;
                } else {
                    if (y > o.y) {
                        return 1;
                    } else if (y < o.y) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            }
        }

        int x;
        int y;

        int time;

        public Place(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}
