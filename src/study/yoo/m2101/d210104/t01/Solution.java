package study.yoo.m2101.d210104.t01;

//카펫
//https://programmers.co.kr/learn/courses/30/lessons/42842
class Solution {
	public int[] solution(int brown, int yellow) {

		int sum = (brown + 4) / 2; // height + width
		int height = 3;
		int width = sum - height;

		while (width >= 3 && width >= height) {
			if (yellow == (height - 2) * (width - 2)) {
				break;
			}
			height++;
			width--;
		}
		int[] answer = new int[] { width, height };
		return answer;
	}
} 