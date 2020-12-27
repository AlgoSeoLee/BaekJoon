package study.moon.y2020.m12.d201226.t02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Integer> answer;
    static int[] inorder;
    static List<Integer> postorder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        answer = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());

        String[] s = br.readLine().split(" ");
        inorder = new int[n];
        for (int i = 0; i < n; i++) {
            inorder[i] = Integer.parseInt(s[i]);
        }

        s = br.readLine().split(" ");
        postorder = new ArrayList<>();
        for (String value : s) {
            postorder.add(Integer.parseInt(value));
        }

        getAnswer(0, postorder.size() - 1);

        for (Integer integer : answer) {
            bw.write(integer + " ");
        }
        bw.flush();
        bw.close();

    }

    private static void getAnswer(int start, int end) {
        if (start == end) {
            answer.add(postorder.get(start));
            return;
        }
        int target = change(start, end);
        if (target-1 >= start) {
            getAnswer(start, target - 1);
        }
        if (target+1 <= end) {
            getAnswer(target + 1, end);
        }
    }

    private static int change(int start, int end) {
        int index = getIndex(postorder.get(end));
        answer.add(postorder.get(end));
        postorder.add(index, postorder.get(end));
        postorder.remove(end + 1);
        return index;
    }

    private static int getIndex(int number) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == number) {
                return i;
            }
        }
        return -1;
    }
}
