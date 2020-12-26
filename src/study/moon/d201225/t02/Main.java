package study.moon.d201225.t02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+1][3];
        for (int i = 1; i <= n; i++) {
            String[] s = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(s[0]);
            arr[i][1] = Integer.parseInt(s[1]);
            arr[i][2] = Integer.parseInt(s[2]);
        }
        int[][] dp1 = new int[n+1][3];
        for (int i = 1; i <= n; i++) {
            dp1[i][0] = Math.min(dp1[i-1][0],dp1[i-1][1]) + arr[i][0];
            dp1[i][1] = Math.min(Math.min(dp1[i-1][0],dp1[i-1][1]),dp1[i-1][2])+arr[i][1];
            dp1[i][2] = Math.min(dp1[i-1][1],dp1[i-1][2]) + arr[i][2];
        }
        int answer = Math.min(Math.min(dp1[n][0],dp1[n][1]),dp1[n][2]);

        int[][] dp2 = new int[n+1][3];
        for (int i = 1; i <= n; i++) {
            dp2[i][0] = Math.max(dp2[i-1][0],dp2[i-1][1]) + arr[i][0];
            dp2[i][1] = Math.max(Math.max(dp2[i-1][0],dp2[i-1][1]),dp2[i-1][2])+arr[i][1];
            dp2[i][2] = Math.max(dp2[i-1][1],dp2[i-1][2]) + arr[i][2];
        }
        int answer2 = Math.max(Math.max(dp2[n][0],dp2[n][1]),dp2[n][2]);
        bw.write(answer2+" "+answer);
        bw.flush();
        bw.close();

    }

}
