package study.codingTest.line.t01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    int[] days = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    int answer = -1;
    int count = 1;
    int dayOfWeek = 5;
    int day = 1;
    int month = 1;
    public int solution(String[] holidays, int k) {
        List<Data> days = new ArrayList<>();
        while(count<366) {
            boolean isHoliday = false;
            String date = setDate();
            if (dayOfWeek==6||dayOfWeek==0) {
                isHoliday = true;
            }
            if (contains(holidays,date)) {
                isHoliday = true;
            }
            days.add(new Data(date,isHoliday,dayOfWeek));

            check();
        }
        List<Integer> answers = new ArrayList<>();
        int holidayLength = 0;
        for (int i = 0; i < days.size(); i++) {
            if (days.get(i).isHoliday) {
                holidayLength++;
            } else {
                if (answers.contains(holidayLength)) {
                    holidayLength = 0;
                    continue;
                }
                answers.add(holidayLength);
                holidayLength = 0;
            }
        }
        answers = answers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        return answers.get(k-1);
    }

    private void check() {
        day++;
        dayOfWeek++;
        if (days[month]<day) {
            day = 1;
            month++;
        }
        if (dayOfWeek==7) {
            dayOfWeek = 0;
        }
        count++;
    }

    private boolean contains(String[] holidays, String date) {
        for (String holiday : holidays) {
            if (holiday.equals(date)) {
                return true;
            }
        }
        return false;
    }

    private String setDate() {
        return String.format("%02d", month)+"/"+String.format("%02d", day);
    }
}

class Data {
    String date;
    boolean isHoliday;
    int dayOfWeek;

    public Data(String date, boolean isHoliday, int dayOfWeek) {
        this.date = date;
        this.isHoliday = isHoliday;
        this.dayOfWeek = dayOfWeek;
    }
}
