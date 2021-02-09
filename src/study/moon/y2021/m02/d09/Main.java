package study.moon.y2021.m02.d09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

//https://www.acmicpc.net/problem/12100    [G2]    2048(Easy)
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(s[j]);
            }
        }

        Solution solution = new Solution();
        bw.write(solution.solution(N, board) + "");

        bw.flush();
        bw.close();
        br.close();
    }
}

class Solution {

    int[][] board;
    boolean[][] check;

    public int solution(int n, int[][] board) {
        int answer = Integer.MIN_VALUE;
        this.board = board;
        check = new boolean[n][n];
        LinkedList<Data> queue = new LinkedList<>();
        queue.add(new Data(board, 0));
        while (!queue.isEmpty()) {
            Data poll = queue.poll();
            if (poll.count > 5) {
                continue;
            }
            int number = findBiggestNumber(poll.board);
            if (number > answer) {
                answer = number;
            }
            queue.add(new Data(upBoard(poll.board), poll.count + 1));
            queue.add(new Data(rightBoard(poll.board), poll.count + 1));
            queue.add(new Data(downBoard(poll.board), poll.count + 1));
            queue.add(new Data(leftBoard(poll.board), poll.count + 1));
        }

        return answer;
    }

    private int[][] upBoard(int[][] board) {
        int[][] clone = clone(board);
        for (int i = 0; i < board.length; i++) {
            upBoard(i, clone);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                check[i][j] = false;
            }
        }
        return clone;
    }

    private void upBoard(int target, int[][] clone) {
        for (int i = 0; i < clone.length; i++) {
            if (clone[i][target] != 0) {
                int count = i;
                while (!isUpEnd(count, target, clone)) {
                    clone[count - 1][target] = clone[count][target];
                    clone[count][target] = 0;
                    count--;
                }
                if (count > 0) {
                    if (clone[count][target] == clone[count - 1][target] && !check[count-1][target]) {
                        clone[count - 1][target] *= 2;
                        clone[count][target] = 0;
                        check[count - 1][target] = true;
                    }
                }
            }
        }
    }

    private boolean isUpEnd(int i, int target, int[][] clone) {
        return i <= 0 || clone[i - 1][target] != 0;
    }

    private int[][] downBoard(int[][] board) {
        int[][] clone = clone(board);
        for (int i = 0; i < board.length; i++) {
            downBoard(i, clone);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                check[i][j] = false;
            }
        }
        return clone;
    }

    private void downBoard(int target, int[][] clone) {
        for (int i = clone.length - 1; i >= 0; i--) {
            if (clone[i][target] != 0) {
                int count = i;
                while (!isDownEnd(count, target, clone)) {
                    clone[count + 1][target] = clone[count][target];
                    clone[count][target] = 0;
                    count++;
                }
                if (count < clone.length - 1) {
                    if (clone[count][target] == clone[count + 1][target]  && !check[count+1][target]) {
                        clone[count + 1][target] *= 2;
                        clone[count][target] = 0;
                        check[count + 1][target] = true;
                    }
                }
            }
        }
    }

    private boolean isDownEnd(int i, int target, int[][] clone) {
        return i >= clone.length - 1 || clone[i + 1][target] != 0;
    }

    private int[][] rightBoard(int[][] board) {
        int[][] clone = clone(board);
        for (int i = 0; i < board.length; i++) {
            rightBoard(i, clone);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                check[i][j] = false;
            }
        }
        return clone;
    }

    private void rightBoard(int target, int[][] clone) {
        for (int i = clone.length - 1; i >= 0; i--) {
            if (clone[target][i] != 0) {
                int count = i;
                while (!isRightEnd(count, target, clone)) {
                    clone[target][count + 1] = clone[target][count];
                    clone[target][count] = 0;
                    count++;
                }
                if (count < clone.length - 1) {
                    if (clone[target][count] == clone[target][count + 1]  && !check[target][count+1]) {
                        clone[target][count + 1] *= 2;
                        clone[target][count] = 0;
                        check[target][count + 1] = true;
                    }
                }
            }
        }
    }

    private boolean isRightEnd(int i, int target, int[][] clone) {
        return i >= clone.length - 1 || clone[target][i + 1] != 0;
    }

    private int[][] leftBoard(int[][] board) {
        int[][] clone = clone(board);
        for (int i = 0; i < board.length; i++) {
            leftBoard(i, clone);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                check[i][j] = false;
            }
        }
        return clone;
    }

    private void leftBoard(int target, int[][] clone) {
        for (int i = 0; i < clone.length; i++) {
            if (clone[target][i] != 0) {
                int count = i;
                while (!isLeftEnd(count, target, clone)) {
                    clone[target][count - 1] = clone[target][count];
                    clone[target][count] = 0;
                    count--;
                }
                if (count > 0) {
                    if (clone[target][count] == clone[target][count - 1] && !check[target][count-1]) {
                        clone[target][count - 1] *= 2;
                        clone[target][count] = 0;
                        check[target][count - 1] = true;
                    }
                }
            }
        }
    }

    private boolean isLeftEnd(int i, int target, int[][] clone) {
        return i <= 0 || clone[target][i - 1] != 0;
    }


    private int findBiggestNumber(int[][] board) {
        int max = Integer.MIN_VALUE;
        for (int[] ints : board) {
            for (int j = 0; j < board.length; j++) {
                if (ints[j] > max) {
                    max = ints[j];
                }
            }
        }
        return max;
    }

    private int[][] clone(int[][] board) {
        int[][] copy = new int[board.length][board.length];
        for (int i = 0; i < board.length; i++) {
            System.arraycopy(board[i], 0, copy[i], 0, board.length);
        }
        return copy;
    }
}

class Data {

    int[][] board;
    int count;

    public Data(int[][] board, int count) {
        this.board = board;
        this.count = count;
    }
}
