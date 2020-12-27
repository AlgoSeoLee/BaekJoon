package study.moon.y2020.m11.d201112.t01;

import java.io.*;

//https://www.acmicpc.net/problem/14503
public class Main {
    static int nowDirection = 0;
    static int r;
    static int c;
    static int answer;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        arr = new int[n][m];

        String[] split1 = br.readLine().split(" ");
        r = Integer.parseInt(split1[0]);
        c = Integer.parseInt(split1[1]);
        nowDirection = Integer.parseInt(split1[2]);
        answer = 0;

        for (int i = 0; i < arr.length; i++) {
            String[] split2 = br.readLine().split(" ");
            for (int j = 0; j < split2.length; j++) {
                arr[i][j] = Integer.parseInt(split2[j]);
            }
        }
        start();
        System.out.println(answer);

    }

    private static void start() {
        a:while (true) {
            //1
            if(arr[r][c] != 2) {
                arr[r][c] = 2;
                answer++;
            }
            //2
            while(true) {
                if(isAllDone()) {
                    if(isBackBlocked()) {
                        break a;
                    } else {
                        moveBack();
                        continue;
                    }
                }

                if(isLeftDirty()) {
                    turnLeft();
                    moveFront();
                    break;
                } else {
                    turnLeft();
                }
            }
        }
    }

    private static void turnLeft() {
        if(nowDirection - 1 < 0) {
            nowDirection+=4;
        }
        nowDirection = (nowDirection - 1) % 4;
    }

    private static void moveFront() {
        if(nowDirection==0) {
            r--;
        }else if(nowDirection==1) {
            c++;
        }else if(nowDirection==2) {
            r++;
        }else if(nowDirection==3) {
            c--;
        }
    }

    private static void moveBack() {
        if(nowDirection==0) {
            r++;
        }else if(nowDirection==1) {
            c--;
        }else if(nowDirection==2) {
            r--;
        }else if(nowDirection==3) {
            c++;
        }
    }

    private static boolean isAllDone() {
        return arr[r - 1][c] != 0 && arr[r + 1][c] != 0 && arr[r][c + 1] != 0 && arr[r][c - 1] != 0;
    }

    private static boolean isBackBlocked() {
        if(nowDirection==0) {
            return arr[r + 1][c] == 1;
        }else if(nowDirection==1) {
            return arr[r][c - 1] == 1;
        }else if(nowDirection==2) {
            return arr[r - 1][c] == 1;
        }else if(nowDirection==3) {
            return arr[r][c + 1] == 1;
        }
        return false;
    }

    private static boolean isLeftDirty() {
        if(nowDirection==0) {
            return arr[r][c - 1] == 0;
        }else if(nowDirection==1) {
            return arr[r - 1][c] == 0;
        }else if(nowDirection==2) {
            return arr[r][c + 1] == 0;
        }else if(nowDirection==3) {
            return arr[r + 1][c] == 0;
        }
        return false;
    }
}
