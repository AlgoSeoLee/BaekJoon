package study.moon.y2021.m01.d18;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//https://www.acmicpc.net/problem/2239    [G4]    스도쿠
public class Main {

    static boolean[][] visited;
    static int[][] sudoku;
    static ArrayList<Point> arr = new ArrayList<>();
    static boolean isEnd = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sudoku = new int[9][9];
        visited = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            String str = br.readLine();
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = str.charAt(j) - '0';
                if (sudoku[i][j] == 0) {
                    arr.add(new Point(i, j));
                }
            }
        }
        dfs(0);
    }

    public static void dfs(int index) {
        if (index >= arr.size()) {
            isEnd = true;
            print();
            return;
        }

        if (isEnd) {
            return;
        }

        Point cur = arr.get(index);
        int r = cur.x;
        int c = cur.y;
        for (int i = 1; i < 10; i++) {
            int tmp = sudoku[r][c];
            if (!checkSero(r, i) || !checkGaro(c, i) || !checkSquare(r, c, i)) {
                continue;
            }
            sudoku[r][c] = i;
            dfs(index + 1);
            sudoku[r][c] = tmp;
        }
    }

    private static boolean checkSquare(int r, int c, int value) {
        int SR = r / 3 * 3;
        int SC = c / 3 * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (sudoku[SR + i][SC + j] == value) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkGaro(int c, int value) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][c] == value) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkSero(int r, int value) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[r][i] == value) {
                return false;
            }
        }
        return true;
    }

    private static void print() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j]);
            }
            System.out.println();
        }
    }
}
