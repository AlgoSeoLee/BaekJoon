package study.moon.d201102.t05.v1;

import java.util.Scanner;

//https://www.acmicpc.net/problem/9663
public class Main {
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[][] arr = new boolean[n][n];
        dfs(arr,n,0);
        System.out.println(answer);
    }

    public static void dfs(boolean[][] arr, int n, int level) {
        if(level == n) {
            if (isNQueen(arr)){
                answer++;
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            arr[level][i] = true;
            dfs(arr,n,level+1);
            arr[level][i] = false;
        }
    }

    public static boolean isNQueen(boolean[][] arr) {
        int n = arr.length;
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < n; b++) {
                if (arr[a][b]) {
                    //해당 말과 가로에 겹치는 말이 없는지
                    for (int i = 0; i < n; i++) {
                        if(i==b){
                            continue;
                        }
                        if(arr[a][i]) {
                            return false;
                        }
                    }
                    //해당 말과 세로에 겹치는 말이 없는지
                    for (int i = 0; i < n; i++) {
                        if(i==a){
                            continue;
                        }
                        if(arr[i][b]) {
                            return false;
                        }
                    }
                    //해당 말과 사선에 겹치는지
                    int i = 1;
                    while(!(a - i < 0 || b - i < 0)) {
                        if(arr[a-i][b-i]){
                            return false;
                        }
                        i++;
                    }
                    i = 1;
                    while(!(a + i >= n || b - i < 0)) {
                        if(arr[a+i][b-i]){
                            return false;
                        }
                        i++;
                    }
                    i = 1;
                    while(!(a - i < 0 || b + i >= n)) {
                        if(arr[a-i][b+i]){
                            return false;
                        }
                        i++;
                    }
                    i = 1;
                    while(!(a + i >= n || b + i >= n)) {
                        if(arr[a+i][b+i]){
                            return false;
                        }
                        i++;
                    }
                }
            }
        }
        return true;
    }
}
