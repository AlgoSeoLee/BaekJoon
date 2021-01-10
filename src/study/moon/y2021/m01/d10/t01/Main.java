package study.moon.y2021.m01.d10.t01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://www.acmicpc.net/problem/3865    [G4]    학회원    <발표>
public class Main {

    static Map<String, Set<String>> map = new HashMap<>();

    static Set<String> result = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            //초기화
            map.clear();
            result.clear();
            String target = null;
            for (int i = 0; i < n; i++) {
                String query = br.readLine();
                query = query.substring(0, query.length() - 1);
                String[] s = query.split(":");
                if (i == 0) {
                    target = s[0];
                }
                Set<String> values = new HashSet<>(Arrays.asList(s[1].split(",")));
                map.put(s[0], values);
            }

            //탐색
            result.add(target);
            bw.write(getMembersCount(target,0) + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static int getMembersCount(String target, int count) {
//        Set<String> set = map.get(target);
//        for (String s : set) {
//            if (map.containsKey(s)) {
//                getMembersCount(s);
//            } else {
//                result.add(s);
//            }
//        }
        if (map.containsKey(target)) {
            for (String child : map.get(target)) {
                if (!result.contains(child)) {
                    result.add(child);
                    count += getMembersCount(child, map.get(child) == null ? 1 : 0);
                }
            }
        }
        return count;
    }
}
