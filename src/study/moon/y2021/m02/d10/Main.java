package study.moon.y2021.m02.d10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//https://www.acmicpc.net/problem/15683    [G5]    감시
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        Solution solution = new Solution();
        System.out.println(solution.solution(n, arr));
    }
}

class Solution {

    int[][] office;
    int[][] check;

    boolean[][] visit;
    int n;
    int m;

    public int solution(int n, int[][] office) {
        this.office = office;
        this.n = n;
        this.m = office[0].length;
        check = new int[n][m];
        visit = new boolean[n][m];
        checkInit(n, office);
        dfs();

        return 0;
    }

    private void dfs() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j]) {
                    if (office[i][j]==1) {
                        showLeft(i,j);
                        dfs();

                    }
                }
            }
        }
    }

    private void checkInit(int n, int[][] office) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (office[i][j] == 6) {
                    check[i][j] = -1;
                }
            }
        }
    }

    private int getMinArea() {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (check[i][j] == 0) {
                    answer++;
                }
            }
        }
        return answer;
    }

    private void showLeft(int n, int m) {
        int target = m;
        while (!isLeftEnd(n, target)) {
            check[n][target - 1]++;
            target--;
        }
    }

    private void leftRollback(int n, int m) {
        int target = m;
        while (!isLeftEnd(n, target)) {
            check[n][target - 1]--;
            target--;
        }
    }

    private void showRight(int n, int m) {
        int target = m;
        while (!isRightEnd(n, target)) {
            check[n][target + 1]++;
            target++;
        }
    }

    private void rightRollback(int n, int m) {
        int target = m;
        while (!isRightEnd(n, target)) {
            check[n][target + 1]--;
            target++;
        }
    }

    private void showUp(int n, int m) {
        int target = n;
        while (!isUpEnd(target, m)) {
            check[target - 1][m]++;
            target--;
        }
    }

    private void upRollback(int n, int m) {
        int target = n;
        while (!isUpEnd(target, m)) {
            check[target - 1][m]--;
            target--;
        }
    }

    private void showDown(int n, int m) {
        int target = n;
        while (!isDownEnd(target, m)) {
            check[target + 1][m]++;
            target--;
        }
    }

    private void downRollback(int n, int m) {
        int target = n;
        while (!isDownEnd(target, m)) {
            check[target + 1][m]--;
            target--;
        }
    }

    private boolean isLeftEnd(int n, int target) {
        return target <= 0 || office[n][target - 1] == 6;
    }

    private boolean isRightEnd(int n, int target) {
        return target >= this.n - 1 || office[n][target + 1] == 6;
    }

    private boolean isUpEnd(int target, int m) {
        return target <= 0 || office[target - 1][m] == 6;
    }

    private boolean isDownEnd(int target, int m) {
        return target >= this.m - 1 || office[target + 1][m] == 6;
    }
}


