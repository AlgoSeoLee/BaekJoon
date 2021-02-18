package study.moon.y2021.m02.d18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://programmers.co.kr/learn/courses/30/lessons/72412    [LEVEL2]    순위검색
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(
            new String[]{
                "java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"
            },
            new String[]{
                "java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"
            }
        )));
    }
}

class Solution {
    List<Data> table;
    public int[] solution(String[] info, String[] query) {
        table = new ArrayList<>();
        setTable(info);
        return getQuery(query);
    }

    private void setTable(String[] info) {
        for (String s : info) {
            String[] split = s.split(" ");
            table.add(new Data(split[0],split[1],split[2],split[3],Integer.parseInt(split[4])));
        }
    }

    private int[] getQuery(String[] query) {
        List<Integer> result = new ArrayList<>();
        for (String s : query) {
            result.add(query(s));
        }
        return result.stream().mapToInt(v->v).toArray();
    }

    private int query(String query) {
        String[] queries = Arrays.stream(query.split(" ")).filter(v -> !v.equals("and"))
            .toArray(String[]::new);
        return (int)table.stream()
            .filter(v -> {
                if (queries[0].equals("-")) {
                    return true;
                }
                return queries[0].equals(v.language);
            })
            .filter(v -> {
                if (queries[1].equals("-")) {
                    return true;
                }
                return queries[1].equals(v.group);
            })
            .filter(v -> {
                if (queries[2].equals("-")) {
                    return true;
                }
                return queries[2].equals(v.career);
            })
            .filter(v -> {
                if (queries[3].equals("-")) {
                    return true;
                }
                return queries[3].equals(v.soulFood);
            })
            .filter(v -> Integer.parseInt(queries[4]) <= v.point).count();
    }
}

class Data {
    String language;
    String group;
    String career;
    String soulFood;
    int point;

    public Data(String language, String group, String career, String soulFood, int point) {
        this.language = language;
        this.group = group;
        this.career = career;
        this.soulFood = soulFood;
        this.point = point;
    }
}
