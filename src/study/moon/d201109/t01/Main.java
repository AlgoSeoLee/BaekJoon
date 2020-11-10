package study.moon.d201109.t01;

import java.io.*;

public class Main {
    static int nowDirection = 0;
    static int r;
    static int c;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int[][] arr = new int[n][m];

        String[] split1 = br.readLine().split(" ");
        r = Integer.parseInt(split1[0]);
        c = Integer.parseInt(split1[1]);
        nowDirection = Integer.parseInt(split1[2]);
        answer = 0;



    }

    private void start(int[][] arr) {
        if(arr[r][c])
    }

    private void turnLeft() {
        nowDirection = (nowDirection - 1) % 4;
    }

    private void turnRight() {
        nowDirection = (nowDirection + 1) % 4;
    }

    private void move(int direction) {
        if(direction==0) {
            r--;
        }else if(direction==1) {
            c++;
        }else if(direction==2) {
            r++;
        }else if(direction==3) {
            c--;
        }
    }
}
