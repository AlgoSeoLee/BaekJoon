package study.moon.y2021.m02.d16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//https://programmers.co.kr/learn/courses/30/lessons/72411    [레벨2]    메뉴리뉴얼
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(
            new String[]{
                "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"
            },
            new int[]{
                2, 3, 4
            }
        )));
        System.out.println(Arrays.toString(solution.solution(
            new String[]{
                "ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"
            },
            new int[]{
                2,3,5
            }
        )));
        System.out.println(Arrays.toString(solution.solution(
            new String[]{
                "XYZ", "XWY", "WXA"
            },
            new int[]{
                2,3,4
            }
        )));
    }
}

class Solution {

    Map<String, Integer> map = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        List<String> answer;
        List<String> answer2 = new ArrayList<>();
        for (int i : course) {
            for (String order : orders) {
                int n = order.length();
                char[] arr = order.toCharArray();
                Arrays.sort(arr);
                boolean[] visited = new boolean[n];
                answer = new ArrayList<>();
                combination(arr, visited, 0, n, i, answer);
                for (String s : answer) {
                    map.put(s, map.getOrDefault(s, 0) + 1);
                }
            }
            List<String> delete = new ArrayList<>();
            map.forEach((k,v)->{
                if (v<2) {
                    delete.add(k);
                }
            });
            for (String s : delete) {
                map.remove(s);
            }
            int maxValue = 0;
            for (int i1 : map.values()) {
                if (i1>maxValue) {
                    maxValue = i1;
                }
            }
            int finalMaxValue = maxValue;
            map.forEach((k,v)->{
                if (v == finalMaxValue) {
                    answer2.add(k);
                }
            });
            map.clear();
        }
        return answer2.stream().sorted().toArray(String[]::new);
    }

    void combination(char[] arr, boolean[] visited, int start, int n, int r, List<String> answer) {
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

    void combPrint(char[] arr, boolean[] visited, int n, List<String> answer) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                StringBuilder append = str.append(arr[i]);
                if (answer.contains(append.toString())) {
                    return;
                }
            }
        }
        answer.add(str.toString());
    }
}

