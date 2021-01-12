package study.yoo.m2012.d201228.t03;

//체육복
//https://programmers.co.kr/learn/courses/30/lessons/42862
class Solution {
	public int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;

		int[] student = new int[n];

		for (int i : reserve)
			student[i - 1]++;

		for (int i : lost)
			student[i - 1]--;

		for (int i = 0; i < student.length; i++)
			if (student[i] < 0)
				//맨 뒷번호 아니고, 바로 뒷번호가 여벌이 있으면 뒤에서 빌림
				if (i != student.length - 1 && student[i + 1] > 0) {
					student[i]++;
					student[i + 1]--;
				} 
					// 맨 앞번호가 아니고, 앞번호가 여벌있으면 앞번호한테 빌림
					else if (i != 0 && student[i - 1] > 0) {
					student[i]++;
					student[i - 1]--;
				}

		for (int i = 0; i < student.length; i++)
			// 도난 안당한 애들 셈
			if (!(student[i] < 0))
				answer++;
		return answer;
	}
}