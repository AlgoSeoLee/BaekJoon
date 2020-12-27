package study.moon.y2020.m10.d201022.t01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://www.acmicpc.net/problem/7576
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            String[] s1 = br.readLine().split(" ");
            int[] ints = new int[n];
            for (int j = 0; j < s1.length; j++) {
                ints[j] = Integer.parseInt(s1[j]);
            }
            arr[i] = ints;
        }
        bw.write(Integer.toString(solution(m,n,arr)));
        bw.flush();
        bw.close();
        br.close();
    }

    static Queue<Place> queue;
    static int size;
    static List<Integer> answer;
    static int[] X = {-1,1,0,0};
    static int[] Y = {0,0,-1,1};



    private static int solution(int m, int n, int[][] matrix) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    size++;
                }
            }
        }
        queue = new LinkedList<>();
        answer = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 1) {
                    queue.offer(new Place(i,j,0));
                }
            }
        }
        return bfs(matrix);
    }

    public static int bfs(int[][] matrix) {
        int answer = 0;
        while(!queue.isEmpty()) {
            Place poll = queue.poll();
            if(poll.x < 0 || poll.x >= matrix.length || poll.y < 0 || poll.y >= matrix[0].length) {
                continue;
            }
            if(matrix[poll.x][poll.y] == 2 || matrix[poll.x][poll.y] == -1) {
                continue;
            }
            if(matrix[poll.x][poll.y] == 0) {
                size--;
            }
            matrix[poll.x][poll.y] = 2;
            if(poll.day > answer) {
                answer = poll.day;
            }
            for (int i = 0; i < 4; i++) {
                queue.offer(new Place(poll.x + X[i],poll.y + Y[i], poll.day + 1));
            }
        }
        if(size != 0) {
            return -1;
        }
        return answer;
    }
}

class Place {
    int x;
    int y;
    int day;
    public Place(int x, int y, int day) {
        this.x = x;
        this.y = y;
        this.day = day;
    }
}

