package study.moon.y2020.m11.d201105.t08;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(2000,new String[]{
                "woni request 09:12:29",
                "brown request 09:23:11",
                "brown leave 09:23:44",
                "jason request 09:33:51",
                "jun request 09:33:56",
                "cu request 09:34:02"
        });
    }

    public String[] solution(int totalTicket, String[] logs) {
        Map<String, LocalTime> map = new HashMap<>();
        for (int i = 0; i < logs.length; i++) {
            String[] s = logs[i].split(" ");
            String id = s[0];
            String code = s[1];
            LocalTime time = LocalTime.parse(s[2], DateTimeFormatter.ofPattern("HH:mm:ss"));

            if(code.equals("request")) {
                if(!map.containsKey(id)) {
                    map.put(id,time);
                }
            }
        }
        return null;
    }
}
