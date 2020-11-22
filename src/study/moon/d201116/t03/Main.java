package study.moon.d201116.t03;

import java.io.*;
//https://www.acmicpc.net/problem/10868
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] split = br.readLine().split(" ");
        int a = Integer.parseInt(split[0]);
        int b = Integer.parseInt(split[1]);

        long[] arr = new long[a+1];
        for (int i = 1; i <= a; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        SegmentTreeMin min = new SegmentTreeMin(arr);

        for (int i = 0; i < b; i++) {
            String[] split1 = br.readLine().split(" ");
            long min1 = min.min(Integer.parseInt(split1[0]), Integer.parseInt(split1[1]));
            bw.write(min1+"\n");
        }
        bw.flush();
        bw.close();
    }
}

class SegmentTreeMin {

    public long[] arr, tree;

    public SegmentTreeMin(long[] arr) {
        this.arr = arr;
        tree = new long[(arr.length - 1) * 4];
        init(1, arr.length - 1, 1);
    }

    private long init(int start, int end, int node) {
        if (start == end) {
            return tree[node] = arr[start];
        }

        int mid = (start + end) / 2;

        return tree[node] = Math.min(init(start, mid, node * 2), init(mid + 1, end, node * 2 + 1));
    }

    public long min(int left, int right) {
        //범위를 벗어나는 녀석들은 이걸로 처리를 한다.
        if (left > arr.length - 1 || right < 1) {
            return Integer.MAX_VALUE;
        }
        //범위 안쪽에 있는 녀석들을 계산한다 이걸로
        if (left <= 1 && arr.length - 1 <= right) {
            return tree[1];
        }
        //아래로 계산한다
        int mid = arr.length / 2;
        return Math.min(min(1, mid, 2, left, right), min(mid + 1, arr.length - 1, 3, left, right));
    }

    private long min(int start, int end, int node, int left, int right) {
        if (left > end || right < start) {
            return Integer.MAX_VALUE;
        }

        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        return Math.min(min(start, mid, node * 2, left, right), min(mid + 1, end, node * 2 + 1, left, right));
    }
}
