package study.CheatSheet.Combination;

import java.util.ArrayList;
import java.util.List;

public class Combination {
    public static void main(String[] args) {
        int n = 4;
        int r = 2;
        int[] arr = {1, 1, 0, 0};
        int[] output = new int[n];
        boolean[] visited = new boolean[n];

        List<String> answer = new ArrayList<>();
        System.out.println(n + " C " + r);
        combination(arr, visited, 0, n, r, answer);
        System.out.println(answer);

        List<String> answer2 = new ArrayList<>();
        System.out.println(n + " P " + r);
        permutation(arr, output, visited, 0, n, r, answer2);
        System.out.println(answer2);

    }

    //조합
    //사용 예시 : combination(arr, visited, 0, n, r, answer)
    static void combination(int[] arr, boolean[] visited, int start, int n, int r, List<String> answer) {
        if (r == 0) {
            combPrint(arr, visited, n, answer);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1, answer);
            visited[i] = false;
        }
    }

    //순열
    //사용 예시: permutation(arr, output, visited, 0, n, 3, answer);
    static void permutation(int[] arr, int[] output, boolean[] visited, int depth, int n, int r, List<String> answer) {
        if (depth == r) {
            permPrint(output, r, answer);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                permutation(arr, output, visited, depth + 1, n, r, answer);
                visited[i] = false;
            }
        }
    }

    //조합 출력
    static void combPrint(int[] arr, boolean[] visited, int n, List<String> answer) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                StringBuilder append = str.append(arr[i]).append(" ");
                if(answer.contains(append.toString())) {
                    return;
                }
            }
        }
        answer.add(str.toString());
    }

    //순열 출력
    static void permPrint(int[] arr, int r, List<String> answer) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < r; i++) {
            StringBuilder append = str.append(arr[i]).append(" ");
            if(answer.contains(append.toString())) {
                return;
            }
        }
        answer.add(str.toString());
    }
}
