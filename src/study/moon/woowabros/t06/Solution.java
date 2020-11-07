package study.moon.woowabros.t06;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new String[]{"0001 3 95", "0001 5 90", "0001 5 100", "0002 3 95", "0001 7 80", "0001 8 80", "0001 10 90", "0002 10 90", "0002 7 80", "0002 8 80", "0002 5 100", "0003 99 90"})));
    }
    List<String> answer;

    public String[] solution(String[] logs) {
        answer = new ArrayList<>();
        List<Check> list = new ArrayList<>();
        for (int i = 0; i < logs.length; i++) {
            String[] split = logs[i].split(" ");
            if(!isContain(split[0],list)) {
                list.add(new Check(split[0], new HashMap<>()));
            }
            list.get(getPersonIndex(split[0],list)).point.put(split[1],split[2]);
        }

        for (int i = 0; i < list.size()-1; i++) {
            for (int j = 1; j < list.size(); j++) {
                checkBadTest(list.get(i),list.get(j));
            }
        }
        if(answer.size()==0) {
            return new String[]{"None"};
        }
        return answer.toArray(String[]::new);
    }
    public void checkBadTest(Check person1, Check person2) {
        int count = 0;
        List<String> keyList1 = new ArrayList<>(person1.point.keySet());
        keyList1 = keyList1.stream().sorted().collect(Collectors.toList());
        List<String> valueList1 = new ArrayList<>(person1.point.values());
        valueList1 = valueList1.stream().sorted().collect(Collectors.toList());
        List<String> keyList2 = new ArrayList<>(person2.point.keySet());
        keyList2 = keyList2.stream().sorted().collect(Collectors.toList());
        List<String> valueList2 = new ArrayList<>(person2.point.values());
        valueList2 = valueList2.stream().sorted().collect(Collectors.toList());
        if(person1.point.size() == person2.point.size()) {
            count++;
        }else {
            return;
        }
        int key = 0;
        for (int i = 0; i < keyList1.size(); i++) {
            if(keyList1.get(i).equals(keyList2.get(i))) {
                key++;
            }
        }
        if(key==keyList1.size()) {
            count++;
        }
        int value = 0;
        for (int i = 0; i < keyList1.size(); i++) {
            if(valueList1.get(i).equals(valueList2.get(i))) {
                value++;
            }
        }
        if(value==keyList1.size()) {
            count++;
        }
        if(count==3) {
            if(!answer.contains(person1.name)) {
                answer.add(person1.name);
            }
        }
    }

    public boolean isContain(String name, List<Check> list) {
        for (int i = 0; i < list.size() ;i++) {
            if(list.get(i).name.equals(name)) {
                return true;
            }
        }
        return false;
    }

    public int getPersonIndex(String name, List<Check> list) {
        for (int i = 0; i < list.size() ;i++) {
            if(list.get(i).name.equals(name)) {
                return i;
            }
        }
        return -1;
    }
}

class Check {
    String name;
    Map<String,String> point;

    public Check(String name, Map<String, String> point) {
        this.name = name;
        this.point = point;
    }

    @Override
    public String toString() {
        return "Check{" +
                "name='" + name + '\'' +
                ", point=" + point +
                '}';
    }
}
