package study.moon.y2021.m02.d07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//https://www.acmicpc.net/problem/14891    [S1]    톱니바퀴
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] gears = new int[4][8];
        for (int i = 0; i < 4; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                gears[i][j] = Character.getNumericValue(s.codePointAt(j));
            }
        }
        int time = Integer.parseInt(br.readLine());
        int[][] order = new int[time][2];
        for (int i = 0; i < time; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < 2; j++) {
                order[i][j] = Integer.parseInt(s[j]);
            }
        }
        Solution solution = new Solution();
        bw.write(solution.solution(gears,order)+"");
        bw.flush();
        bw.close();
        br.close();
    }
}

class Solution {

    public int solution(int[][] gears, int[][] orders) {
        for (int[] order : orders) {
            order(gears, order[0] - 1, order[1]);
        }
        int answer = 0;
        if (gears[0][0]==1) {
            answer+=1;
        }
        if (gears[1][0]==1) {
            answer+=2;
        }
        if (gears[2][0]==1) {
            answer+=4;
        }
        if (gears[3][0]==1) {
            answer+=8;
        }

        return answer;
    }
    private void order(int[][] gears, int target, int direction) {
        boolean[] visit = new boolean[4];
        int[] rotate = new int[4];
        getRotate(gears,visit,rotate,target,direction);
        for (int j = 0; j < rotate.length; j++) {
            if (rotate[j] == 1) {
                rotatePlus(gears, j);
            }
            if (rotate[j] == -1) {
                rotateMinus(gears, j);
            }
        }
    }

    private void getRotate(int[][] gears, boolean[] visit, int[] rotate, int target, int direction) {
        if (visit[target]) {
            return;
        }

        visit[target] = true;

        if (direction == 1) {
            rotate[target] = 1;
        }
        if (direction == -1) {
            rotate[target] = -1;
        }

        if (target - 1 >= 0) {
            if (gears[target][6] != gears[target - 1][2]) {
                getRotate(gears, visit, rotate, target - 1, -direction);
            }
        }
        if (target + 1 < 4) {
            if (gears[target][2] != gears[target + 1][6]) {
                getRotate(gears, visit, rotate, target + 1, -direction);
            }
        }
    }

    private void rotatePlus(int[][] gears, int target) {
        int tmp = gears[target][7];
        gears[target][7] = gears[target][6];
        gears[target][6] = gears[target][5];
        gears[target][5] = gears[target][4];
        gears[target][4] = gears[target][3];
        gears[target][3] = gears[target][2];
        gears[target][2] = gears[target][1];
        gears[target][1] = gears[target][0];
        gears[target][0] = tmp;
    }

    private void rotateMinus(int[][] gears, int target) {
        int tmp = gears[target][0];
        gears[target][0] = gears[target][1];
        gears[target][1] = gears[target][2];
        gears[target][2] = gears[target][3];
        gears[target][3] = gears[target][4];
        gears[target][4] = gears[target][5];
        gears[target][5] = gears[target][6];
        gears[target][6] = gears[target][7];
        gears[target][7] = tmp;
    }
}
