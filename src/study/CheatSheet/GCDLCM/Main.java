package study.CheatSheet.GCDLCM;

public class Main {

    public static void main(String[] args) {

    }

    private static int getGCD(int a, int b) {
        int c = a % b;
        if (c == 0) {
            return b;
        }
        return getGCD(b, c);
    }

    //num1 = a 원형, num2 = b 원형
    private static int getLCM(int a, int b, final int num1, final int num2) {
        if (a == b) {
            return a;
        }

        if (a > b) {
            return getLCM(a, b + num2, num1, num2);
        }

        return getLCM(a + num1, b, num1, num2);
    }

}
