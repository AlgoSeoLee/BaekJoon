package study.codingTest.line.t03;

import java.util.HashMap;
import java.util.LinkedList;

public class Solution {

    LinkedList<Order> queue;
    HashMap<String, Integer> map;
    Fire[] fires;

    public int solution(int n, String[] recipes, String[] orders) {
        queue = new LinkedList<>();
        map = new HashMap<>();
        fires = new Fire[n];
        for (String recipe : recipes) {
            String[] s = recipe.split(" ");
            map.put(s[0], Integer.parseInt(s[1]));
        }
        for (String order : orders) {
            String[] s = order.split(" ");
            queue.add(new Order(s[0], Integer.parseInt(s[1])));
        }
        int time = 1;
        while (!queue.isEmpty()) {
            for (int i = 0; i < fires.length; i++) {
                if (fires[i]!=null) {
                    fires[i].nowTime++;
                    if (fires[i].nowTime==fires[i].endTime) {
                        fires[i] = null;
                    }
                }
            }


            for (int i = 0; i < fires.length; i++) {
                if (fires[i]==null) {
                    if (queue.peek().time<=time) {
                        Order poll = queue.poll();
                        fires[i] = new Fire(time,0,map.get(poll.food));
                        if (queue.isEmpty()) {
                            return time+map.get(poll.food);
                        }
                    }
                }
            }
            time++;
        }

        int answer = 0;
        return answer;
    }
}

class Fire {
    int startTime;

    int nowTime;
    int endTime;

    public Fire(int startTime, int nowTime, int endTime) {
        this.startTime = startTime;
        this.nowTime = nowTime;
        this.endTime = endTime;
    }
}

class Order {

    String food;
    int time;

    public Order(String food, int time) {
        this.food = food;
        this.time = time;
    }
}
