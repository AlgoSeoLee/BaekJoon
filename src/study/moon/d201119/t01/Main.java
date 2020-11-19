package study.moon.d201119.t01;

import java.io.*;

//https://www.acmicpc.net/problem/6549
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = "";
        while(!(str = br.readLine()).equals("0")) {
            String[] split = str.split(" ");
            int n = Integer.parseInt(split[0]);
            long[] arr = new long[n+1];
            for (int i = 1; i <= n; i++) {
                arr[i] = Long.parseLong(split[i]);
            }

            SegmentTree segmentTree = new SegmentTree(arr);
            bw.write((segmentTree.getMax(1, n, n)) + "\n");
        }
        bw.flush();
        bw.close();
    }
}

class SegmentTree {

    public long[] arr;
    public int[] tree;

    public SegmentTree(long[] arr) {
        this.arr = arr;
        tree = new int[(arr.length - 1) * 4];
        init(1, arr.length - 1, 1);
    }

    private int init(int start, int end, int node) {
        if (start == end) {
            return tree[node] = start;
        }

        int mid = (start + end) / 2;

        if (arr[init(start, mid, node * 2)] <= arr[init(mid + 1, end, node * 2 + 1)])
            tree[node] = init(start, mid, node * 2);
        else {
            tree[node] = init(mid + 1, end, node * 2 + 1);
        }
        return tree[node];
    }

    public int query(int start, int end, int node, int left, int right) {
        if (right < start || end < left) {
            return -1;
        }

        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        int m1 = query(start, mid, node * 2, left, right);
        int m2 = query(mid + 1, end, node * 2 + 1, left, right);

        if (m1 == -1) {
            return m2;
        } else if (m2 == -1) {
            return m1;
        } else {
            if (arr[m1] <= arr[m2]) {
                return m1;
            } else {
                return m2;
            }
        }
    }

    public long getMax(int start, int end, int N) {
        int m = query(1, N, 1, start, end);

        long area = (end - start + 1) * arr[m];

        // 왼쪽 막대 존재 여부 확인
        if (start <= m - 1) {
            long tmp = getMax(start, m - 1, N);

            area = Math.max(area, tmp);
        }

        // 오른쪽 막대 존재 여부 확인
        if (m + 1 <= end) {
            long tmp = getMax(m + 1, end, N);

            area = Math.max(area, tmp);
        }

        return area;
    }
}
