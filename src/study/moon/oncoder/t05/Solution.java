package study.moon.oncoder.t05;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{5,7,7}));
    }

    public int solution(int[] votes){
        int answer = 0;
        while(!predicateTop(votes)) {
            votes[findMaxIndex(votes)]--;
            votes[0]++;
            answer++;
        }
        return answer;
    }

    private int findMaxIndex(int[]votes) {
        int index = 0;
        int max = 0;
        for (int i = 1; i < votes.length; i++) {
            if(votes[i] > max) {
                max = votes[i];
                index = i;
            }
        }
        return index;
    }
    private boolean predicateTop(int[] votes) {
        int me = votes[0];
        for (int i = 1; i < votes.length; i++) {
            if(votes[i]>=me) {
                return false;
            }
        }
        return true;
    }
}
