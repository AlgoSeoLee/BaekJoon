package study.moon.y2021.m02.d15;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

//https://programmers.co.kr/learn/courses/30/lessons/17676    [레벨3]    추석트래픽
public class Main {

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[]{
            "2016-09-15 01:00:04.001 2.0s",
            "2016-09-15 01:00:07.000 2s",
        }));
        System.out.println(solution.solution(new String[]{
            "2016-09-15 01:00:04.001 2.0s",
            "2016-09-15 01:00:07.000 2s"
        }));
        System.out.println(solution.solution(new String[]{
            "2016-09-15 20:59:57.421 0.351s",
            "2016-09-15 20:59:58.233 1.181s",
            "2016-09-15 20:59:58.299 0.8s",
            "2016-09-15 20:59:58.688 1.041s",
            "2016-09-15 20:59:59.591 1.412s",
            "2016-09-15 21:00:00.464 1.466s",
            "2016-09-15 21:00:00.741 1.581s",
            "2016-09-15 21:00:00.748 2.31s",
            "2016-09-15 21:00:00.966 0.381s",
            "2016-09-15 21:00:02.066 2.62s",
        }));


    }
}

class Solution {
    List<Data> list;

    public int solution(String[] lines) {
        int answer = 0;
        list = new ArrayList<>();
        for (String line : lines) {
            setList(line);
        }
        for (int i = 0; i < list.size(); i++) {
            int count = 0;
            Data data = list.get(i);
            for (Data value : list) {
                if (value.isContainAt(data.end, data.end.plusSeconds(1L).minusNanos(1000000))) {
                    count++;
                }
            }
            if (count > answer) {
                answer = count;
            }
        }
        return answer;
    }

    private void setList(String line) {
        String[] split = line.split(" ");
        String[] dateSplit = split[0].split("-");
        String[] timeSplit = split[1].split(":");
        String[] secondSplit = timeSplit[2].split("\\.");
        int second = Integer.parseInt(secondSplit[0]);
        int nano = Integer.parseInt(secondSplit[1])*1000000;
        String[] addSeconds = split[2].substring(0, split[2].length() - 1).split("\\.");
        int addSecond = Integer.parseInt(addSeconds[0]);
        int addNano = 0;
        if (addSeconds.length==2) {
            double nan = Double.parseDouble("0."+addSeconds[1]) * 1000000000;
            addNano = (int)nan;
        }
        LocalDateTime end = LocalDateTime.of(
            LocalDate.of(
                Integer.parseInt(dateSplit[0]),
                Integer.parseInt(dateSplit[1]),
                Integer.parseInt(dateSplit[2])
            ),
            LocalTime.of(
                Integer.parseInt(timeSplit[0]),
                Integer.parseInt(timeSplit[1]),
                second,
                nano
            )
        );
        LocalDateTime start = end.minusSeconds(addSecond);
        start = start.minusNanos(addNano-1000000);
        list.add(new Data(start,end));
    }
}

class Data {

    LocalDateTime start;
    LocalDateTime end;

    public Data(LocalDateTime start, LocalDateTime end) {
        this.start = start;
        this.end = end;
    }

    public boolean isContainAt(LocalDateTime start, LocalDateTime end) {
        return !(this.start.isAfter(end) || this.end.isBefore(start));
    }
}
