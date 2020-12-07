package study.moon.d201207.t16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());
        for (int i = 0; i < a; i++) {
            String[] split = br.readLine().split(" ");
            int n =Integer.parseInt(split[0]);
            int m =Integer.parseInt(split[1]);
            boolean check = true;
            LinkedList<Data> queue = new LinkedList<>();
            split = br.readLine().split(" ");
            for (int j = 0; j < split.length; j++) {
                queue.offer(new Data(Integer.parseInt(split[j]),j));
            }
            int count = 0;
            while(check) {
                if (hasMorePriority(queue,queue.peek().priority)) {
                    queue.offer(queue.poll());
                }else {
                    count++;
                    if (queue.poll().number==m) {
                        check = false;
                    }
                }
            }
            bw.write(count+"\n");
        }
        bw.flush();
        bw.close();
    }

    private static boolean hasMorePriority(LinkedList<Data> queue, int priority) {
        for (Data data : queue) {
            if (data.priority > priority) {
                return true;
            }
        }
        return false;
    }
}

class Data {
    int priority;
    int number;

    public Data(int priority, int number) {
        this.priority = priority;
        this.number = number;
    }
}
