package study.moon.y2021.m02.d10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

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
        bw.write(solution.solution(n, arr)+"");
        bw.flush();
        bw.close();
        br.close();
    }
}

class Solution {

    int[][] office;
    int[][] check;

    boolean[][] visit;
    int n;
    int m;
    int count = 0;
    int answer = Integer.MAX_VALUE;

    List<Place> places = new ArrayList<>();

    public int solution(int n, int[][] office) {
        this.office = office;
        this.n = n;
        this.m = office[0].length;
        check = new int[n][m];
        visit = new boolean[n][m];
        checkInit(n, office);
        dfs(0);
        return answer;
    }

    private void dfs(int level) {
        if (level == count) {
            answer = Math.min(answer, getMinArea());
            return;
        }
        Place place = places.get(level);
        int i = place.n;
        int j = place.m;

        if (!visit[i][j] && office[i][j] != 0 && office[i][j] != 6) {
            if (office[i][j] == 1) {
                for (int k = 0; k < 4; k++) {
                    show1(i, j, k);
                    visit[i][j] = true;
                    dfs(level + 1);
                    visit[i][j] = false;
                    show1Rollback(i, j, k);
                }
            }
            if (office[i][j] == 2) {
                for (int k = 0; k < 2; k++) {
                    show2(i, j, k);
                    visit[i][j] = true;
                    dfs(level + 1);
                    visit[i][j] = false;
                    show2Rollback(i, j, k);
                }
            }
            if (office[i][j] == 3) {
                for (int k = 0; k < 4; k++) {
                    show3(i, j, k);
                    visit[i][j] = true;
                    dfs(level + 1);
                    visit[i][j] = false;
                    show3Rollback(i, j, k);
                }
            }
            if (office[i][j] == 4) {
                for (int k = 0; k < 4; k++) {
                    show4(i, j, k);
                    visit[i][j] = true;
                    dfs(level + 1);
                    visit[i][j] = false;
                    show4Rollback(i, j, k);
                }
            }
            if (office[i][j] == 5) {
                show5(i, j);
                visit[i][j] = true;
                dfs(level + 1);
                visit[i][j] = false;
                show5Rollback(i, j);
            }
        }
    }

    private void checkInit(int n, int[][] office) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (office[i][j] == 6) {
                    check[i][j] = -1;
                }
                if (office[i][j] != 0 && office[i][j] != 6) {
                    places.add(new Place(i, j, office[i][j]));
                    count++;
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

    private void show1(int n, int m, int direction) {
        check[n][m]++;
        if (direction == 0) {
            showUp(n, m);
        }
        if (direction == 1) {
            showRight(n, m);
        }
        if (direction == 2) {
            showDown(n, m);
        }
        if (direction == 3) {
            showLeft(n, m);
        }
    }

    private void show1Rollback(int n, int m, int direction) {
        check[n][m]--;
        if (direction == 0) {
            upRollback(n, m);
        }
        if (direction == 1) {
            rightRollback(n, m);
        }
        if (direction == 2) {
            downRollback(n, m);
        }
        if (direction == 3) {
            leftRollback(n, m);
        }
    }

    private void show2(int n, int m, int direction) {
        check[n][m]++;
        if (direction == 0) {
            showUp(n, m);
            showDown(n, m);
        }
        if (direction == 1) {
            showRight(n, m);
            showLeft(n, m);
        }
    }

    private void show2Rollback(int n, int m, int direction) {
        check[n][m]--;
        if (direction == 0) {
            upRollback(n, m);
            downRollback(n, m);
        }
        if (direction == 1) {
            rightRollback(n, m);
            leftRollback(n, m);
        }
    }

    private void show3(int n, int m, int direction) {
        check[n][m]++;
        if (direction == 0) {
            showUp(n, m);
            showRight(n, m);
        }
        if (direction == 1) {
            showRight(n, m);
            showDown(n, m);
        }
        if (direction == 2) {
            showDown(n, m);
            showLeft(n, m);
        }
        if (direction == 3) {
            showLeft(n, m);
            showUp(n, m);
        }
    }

    private void show3Rollback(int n, int m, int direction) {
        check[n][m]--;
        if (direction == 0) {
            upRollback(n, m);
            rightRollback(n, m);
        }
        if (direction == 1) {
            rightRollback(n, m);
            downRollback(n, m);
        }
        if (direction == 2) {
            downRollback(n, m);
            leftRollback(n, m);
        }
        if (direction == 3) {
            leftRollback(n, m);
            upRollback(n, m);
        }
    }

    private void show4(int n, int m, int direction) {
        check[n][m]++;
        if (direction == 0) {
            showUp(n, m);
            showRight(n, m);
            showDown(n, m);
        }
        if (direction == 1) {
            showRight(n, m);
            showDown(n, m);
            showLeft(n, m);
        }
        if (direction == 2) {
            showDown(n, m);
            showLeft(n, m);
            showUp(n, m);
        }
        if (direction == 3) {
            showLeft(n, m);
            showUp(n, m);
            showRight(n, m);
        }
    }

    private void show4Rollback(int n, int m, int direction) {
        check[n][m]--;
        if (direction == 0) {
            upRollback(n, m);
            rightRollback(n, m);
            downRollback(n, m);
        }
        if (direction == 1) {
            rightRollback(n, m);
            downRollback(n, m);
            leftRollback(n, m);
        }
        if (direction == 2) {
            downRollback(n, m);
            leftRollback(n, m);
            upRollback(n, m);
        }
        if (direction == 3) {
            leftRollback(n, m);
            upRollback(n, m);
            rightRollback(n, m);
        }
    }

    private void show5(int n, int m) {
        check[n][m]++;
        showUp(n, m);
        showRight(n, m);
        showDown(n, m);
        showLeft(n, m);
    }

    private void show5Rollback(int n, int m) {
        check[n][m]--;
        upRollback(n, m);
        rightRollback(n, m);
        downRollback(n, m);
        leftRollback(n, m);
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
            target++;
        }
    }

    private void downRollback(int n, int m) {
        int target = n;
        while (!isDownEnd(target, m)) {
            check[target + 1][m]--;
            target++;
        }
    }

    private boolean isLeftEnd(int n, int target) {
        return target <= 0 || office[n][target - 1] == 6;
    }

    private boolean isRightEnd(int n, int target) {
        return target >= this.m - 1 || office[n][target + 1] == 6;
    }

    private boolean isUpEnd(int target, int m) {
        return target <= 0 || office[target - 1][m] == 6;
    }

    private boolean isDownEnd(int target, int m) {
        return target >= this.n - 1 || office[target + 1][m] == 6;
    }
}

class Place {

    int n;
    int m;
    int camera;

    public Place(int n, int m, int camera) {
        this.n = n;
        this.m = m;
        this.camera = camera;
    }
}


