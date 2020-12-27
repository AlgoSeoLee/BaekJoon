package study.moon.y2020.m12.d201212.t04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeMap;
//https://www.acmicpc.net/problem/7662
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            DualHeap heap = new DualHeap(new TreeMap<>());
            int k = Integer.parseInt(br.readLine());
            for (int j = 0; j < k; j++) {
                String[] s = br.readLine().split(" ");
                char c = s[0].charAt(0);
                int n = Integer.parseInt(s[1]);
                if (c == 'I') {
                    heap.add(n);
                }
                if (c == 'D') {
                    heap.delete(n);
                }
            }
            bw.write(heap.getMaxMin() + "\n");
        }
        bw.flush();
        bw.close();

    }

}

class DualHeap {

    TreeMap<Integer, Integer> heap;

    public DualHeap(TreeMap<Integer, Integer> heap) {
        this.heap = heap;
    }

    public void add(int number) {
        heap.put(number, heap.getOrDefault(number, 0) + 1);
    }

    public void delete(int number) {
        if (heap.isEmpty()) {
            return;
        }
        if (number == 1) {
            Integer last = heap.lastKey();
            if (heap.get(last) > 1) {
                heap.put(last, heap.get(last) - 1);
            } else {
                heap.remove(heap.lastKey());
            }
        } else {
            Integer key = heap.firstKey();
            if (heap.get(key) > 1) {
                heap.put(key, heap.get(key) - 1);
            } else {
                heap.remove(heap.firstKey());
            }
        }
    }

    public String getMaxMin() {
        if (heap.isEmpty()) {
            return "EMPTY";
        }
        return heap.lastKey() + " " + heap.firstKey();
    }
}
