package study.yoo.m2101.d210128.t01;

import java.util.ArrayList;
import java.util.List;

//폰켓몬
class Solution {
	public int solution(int[] nums) {
		int answer = 0;
		List<Integer> list = new ArrayList<Integer>();

		for (int i = 1; i < nums.length; i++)
			if (!list.contains(nums[i]))
				list.add(nums[i]);

		answer = (list.size() < nums.length / 2) ? list.size() : nums.length / 2;
		return answer;
	}
}