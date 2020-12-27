package study.moon.y2020.m10.d201029.t02;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

// https://www.acmicpc.net/problem/10026
public class Main {
    static int[] moveX = {-1,1,0,0};
    static int[] moveY = {0,0,-1,1};
    static Queue<Place> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int count1 = 0;
        int count2 = 0;
        char[][] arr1 = new char[n][n];
        char[][] arr2 = new char[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr1[i][j] = s.charAt(j);
                arr2[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if( arr2[i][j] == 'G') {
                    arr2[i][j] = 'R';
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr1[i][j] != '0') {
                    queue.offer(new Place(i,j));
                    bfs1(arr1,arr1[i][j]);
                    count1++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr2[i][j] != '0') {
                    queue.offer(new Place(i,j));
                    bfs1(arr2,arr2[i][j]);
                    count2++;
                }
            }
        }
        bw.write(count1+" "+count2);
        bw.flush();
        bw.close();

    }

    public static void bfs1 (char[][] arr, char color) {
        while(!queue.isEmpty()) {
            Place poll = queue.poll();
            if(poll.x < 0 || poll.x >= arr.length || poll.y < 0 || poll.y >= arr.length) {
                continue;
            }
            if(arr[poll.x][poll.y] == '0') {
                continue;
            }
            if(arr[poll.x][poll.y] != color) {
                continue;
            }
            arr[poll.x][poll.y] = '0';
            for (int i = 0; i < 4; i++) {
                queue.offer(new Place(poll.x+moveX[i],poll.y+ moveY[i]));
            }
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

    @Override
    public String toString() {
        return "Place{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
