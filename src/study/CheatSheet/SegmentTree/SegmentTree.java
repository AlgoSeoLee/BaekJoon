package study.CheatSheet.SegmentTree;

public class SegmentTree {

    public long[] arr, tree;

    public SegmentTree(long[] arr) {
        this.arr = arr;
        tree = new long[(arr.length - 1) * 4];
        init(1, arr.length - 1, 1);
    }

    private long init(int start, int end, int node) {
        if (start == end) {
            return tree[node] = arr[start];
        }

        int mid = (start + end) / 2;

        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    public long sum(int left, int right) {
        if (left > arr.length - 1 || right < 1) {
            return 0;
        }

        if (left <= 1 && arr.length - 1 <= right) {
            return tree[1];
        }

        int mid = arr.length / 2;
        return sum(1, mid, 2, left, right) + sum(mid + 1, arr.length - 1, 3, left, right);
    }

    private long sum(int start, int end, int node, int left, int right) {
        if (left > end || right < start) {
            return 0;
        }

        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
    }

    public void update(int index, long diff) {
        if (index < 1 || index > arr.length - 1) {
            return;
        }

        long tmp = arr[index];
        arr[index] = diff;
        tree[1] += (diff - tmp);
        if (arr.length == 1) {
            return;
        }

        int mid = arr.length / 2;
        update(1, mid, 2, index, (diff - tmp));
        update(mid + 1, arr.length - 1, 3, index, (diff - tmp));
    }
    private void update(int start, int end, int node, int index, long diff) {
        if (index < start || index > end) {
            return;
        }

        tree[node] += diff;
        if (start == end) {
            return;
        }

        int mid = (start + end) / 2;
        update(start, mid, node * 2, index, diff);
        update(mid + 1, end, node * 2 + 1, index, diff);
    }

}
