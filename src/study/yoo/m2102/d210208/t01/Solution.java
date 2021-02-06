package study.yoo.m2102.d210208.t01;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        String[] leadingSkills = skill.split("");
        
        for(int i = 0; i < skill_trees.length; i++) {
            boolean flag = true;

            for(int j = 1; j < leadingSkills.length; j++) {

                int start = skill_trees[i].indexOf(leadingSkills[j - 1]);
                int end = skill_trees[i].indexOf(leadingSkills[j]);

                if(start == -1 && end != -1) {
                    flag = false;
                }

                if(end != -1 && start > end) {
                    flag = false;
                }

                if(flag == false) break;
            }

            if(flag) answer++;
        }
        return answer;
    }
}
