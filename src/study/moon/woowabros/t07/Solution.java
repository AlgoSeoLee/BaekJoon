package study.moon.woowabros.t07;

import java.util.Arrays;

/*           n = 4           순서
        0  1  8  9      1   2   6   7
        3  6  11 20     3   5   8   13
        4  13 18 21     4   9   12  14
        15 16 23 24     10  11  15  16

        가로로 움직일 때는 1을 움직인다.
        사선으로 움직일 때는 2를 움직인다.

 */

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.solution(4, true)));
        System.out.println(Arrays.deepToString(solution.solution(5, false)));
    }
    int count;
    public int[][] solution(int n, boolean horizontal) {
        count = 0;
        int[][] answer = new int[n][n];
        move(answer,0,0,horizontal,n);
        return answer;
    }
    public void move(int[][] arr,int x, int y, boolean horizontal, int n) {
        while(true) {
            arr[x][y] = count;
            if(x == n-1 && y == n-1) {
                break;
            }
            if(horizontal) {
                if(x == 0) {
                    if(y == n-1) {
                        x++;
                    } else {
                        y++;
                    }
                    horizontal = false;
                    count++;
                } else if(y == n-1) {
                    x++;
                    horizontal = false;
                    count++;
                } else {
                    y++;
                    x--;
                    count+=2;
                }
            } else {
                if(y == 0) {
                    if(x == n-1) {
                        y++;
                    } else {
                        x++;
                    }
                    horizontal = true;
                    count++;
                } else if(x == n-1) {
                    y++;
                    horizontal = true;
                    count++;
                } else {
                    x++;
                    y--;
                    count+=2;
                }
            }
        }
    }
}
