package study.yoo.m2101.d210121.t02;

class Solution {
    public int solution(int[] a) {
		int answer = 2;
		int [][] map = new int [a.length][2];
		int l = a[0], r = a[a.length-1];
		for (int i = 1; i < a.length-1; i++) {
			if(l > a[i]) l = a[i];
			map[i][0] = l;
		}
		for (int i = a.length-2; i > 0; i--) {
			if(r > a[i]) r = a[i];
			map[i][1] = r;
		}
		for (int i = 1; i < a.length-1; i++) {
			if(a[i] <= map[i][0] || a[i] <= map[i][1]) answer++;
		}
        return answer;
    }
}