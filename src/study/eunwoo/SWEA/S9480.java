package study.eunwoo.SWEA;

import java.util.Scanner;

// [9480 민정이와 광직이의 알파벳 공부] https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXAdrmW61ssDFAXq&categoryId=AXAdrmW61ssDFAXq&categoryType=CODE
public class S9480 {
    private static String [] word;
    private static final int [] alpha = new int[26]; // 알파벳 갯수 체크
    private static int result = 0;

    private static void add(String s) {
        for (int i=0; i<s.length(); i++) {
            alpha[s.charAt(i) - 'a'] += 1;
        }
    }

    private static boolean isCheck() { // 모든 알파벳이 나왔는지 체크
        for (int i=0; i<26; i++) {
            if (alpha[i] < 1) return false;
        }
        return true;
    }

    private static void sub(String s) {
        for (int i=0; i<s.length(); i++) {
            alpha[s.charAt(i) - 'a'] -= 1;
        }
    }

    private static void dfs(int idx) {
        if (word.length == idx) return;

        for (int i=idx; i<word.length; i++) {
            add(word[i]);

            if (isCheck()) result++;

            dfs(i+1);
            sub(word[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test=1; test<=T; test++) {
            int N = sc.nextInt();
            word = new String[N];
            result = 0;

            for (int i = 0; i < N; i++) {
                word[i] = sc.next();
            }

            dfs(0);

            System.out.println("#"+test+" "+result);
        }
    }
}
