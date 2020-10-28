package study.moon.d201029.t01;

import java.io.*;

//https://www.acmicpc.net/problem/10026
public class Main {
    static int[] moveX = {-1,1,0,0};
    static int[] moveY = {0,0,-1,1};
    static int MAX = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int answer = 1;
        String[] s = br.readLine().split(" ");
        int R = Integer.parseInt(s[0]);
        int C = Integer.parseInt(s[1]);

        char [][] arr = new char[R][C];
        boolean[] visit = new boolean[26];
        for (int i = 0; i < R; i++) {
            String s1 = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = s1.charAt(j);
            }
        }
        //logic
        dfs(visit,arr,0,0,answer);
        bw.write(Integer.toString(MAX));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(boolean[] visit, char[][] arr, int x, int y, int answer) {
        if(x < 0 || x >= arr.length || y < 0 || y >= arr[0].length) {
            return;
        }
        if(visit[arr[x][y] - 65]) {
            return;
        }
        if(answer > MAX) {
            MAX = answer;
        }

        for (int i = 0; i < 4; i++) {
            visit[arr[x][y] - 65] = true;
            dfs(visit,arr,x+moveX[i],y+moveY[i],answer+1);
            visit[arr[x][y] - 65] = false;
        }
    }
}
