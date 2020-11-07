package study.moon.woowabros.t04;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    int answer;
    int x;
    int y;
    public int solution(int n, int[][] board) {
        answer = 0;
        x = 0;
        y = 0;
        Map<Integer,Place> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map.put(board[i][j],new Place(i,j));
            }
        }
        for (int i = 1; i <= n * n; i++) {
            Place place = map.get(i);
            answer += getGaroMove(place,n);
            answer += getSeroMove(place,n);
            System.out.println("garo:"+getGaroMove(place,n)+", sero:"+getSeroMove(place,n));
            answer++;
            x = place.x;
            y = place.y;
        }

        return answer;
    }

    public int getGaroMove(Place target,int n) {
        if(target.x > x) {
            return Math.min(Math.abs(n+x-target.x),Math.abs(target.x-x));
        }else if(target.x < x) {
            return Math.min(Math.abs(x-target.x),Math.abs(target.x+n-x));
        }else {
            return 0;
        }
    }

    public int getSeroMove(Place target, int n) {
        if(target.y > y) {
            return Math.min(Math.abs(n+y-target.y),Math.abs(target.y-y));
        }else if(target.y < y) {
            return Math.min(Math.abs(y-target.y),Math.abs(target.y+n-y));
        }else {
            return 0;
        }
    }
}

class Place {
    int x;
    int y;

    public Place(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Place{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
