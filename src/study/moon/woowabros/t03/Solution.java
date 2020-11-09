package study.moon.woowabros.t03;

/*
    앞뒷면 동전 맞추기 게임
    배팅 전략
    1. 이전판에 졌으면 이전판의 2배의 돈을 배팅한다
    2. 이전판에 이겼으면 이번판에는 100원을 배팅한다.
    3. 이전판에 졌을 때 배팅해야 할 돈보다 소지금이 적으면 가진돈 전액을 배팅한다.
    4. 모든 돈을 다 잃었으면 게임을 종료하고 0원을 반환한다.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(1000, new String[]{"H", "T", "H", "T", "H", "T", "H"}, new String[]{"T", "T", "H", "H", "T", "T", "H"}));
        System.out.println(solution.solution(1200, new String[]{"T", "T", "H", "H", "H"}, new String[]{"H", "H", "T", "H", "T"}));
    }
    int batMoney;
    boolean beforeWin;
    int total;

    public int solution(int money, String[] expected, String[] actual) {
        batMoney = 100;
        beforeWin = true;
        total = money;
        for (int i = 0; i < expected.length; i++) {
            doGame(expected[i],actual[i]);
            System.out.println(total);
            if(total == 0) {
                return 0;
            }
        }
        return total;
    }

    public void doGame(String expected, String actual) {
        //배팅
        if(beforeWin) {
            batMoney = 100;
            total -= 100;
        } else {
            batMoney *= 2;
            if(total < batMoney) {
                batMoney = total;
                total = 0;
            } else {
                total -= batMoney;
            }
        }
        //승부
        if(expected.equals(actual)) {
            total += (2 * batMoney);
            beforeWin = true;
        } else {
            beforeWin = false;
        }
    }
}
