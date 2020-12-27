package study.moon.y2020.m12.d201207.t07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//https://www.acmicpc.net/problem/210866
public class Main {

    public static void main(String[] args) throws IOException {
        Deque deque = new Deque();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            if (split.length == 2) {
                if (split[0].equals("push_back")) {
                    deque.pushBack(Integer.parseInt(split[1]));
                }

                if (split[0].equals("push_front")) {
                    deque.pushFront(Integer.parseInt(split[1]));
                }
            }

            if (split.length == 1) {
                if (split[0].equals("pop_front")) {
                    if (deque.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(deque.popFront() + "\n");
                    }
                }
                if (split[0].equals("pop_back")) {
                    if (deque.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(deque.popBack() + "\n");
                    }
                }
                if (split[0].equals("size")) {
                    bw.write(deque.size() + "\n");
                }
                if (split[0].equals("empty")) {
                    if (deque.isEmpty()) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                }
                if (split[0].equals("front")) {
                    if (deque.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(deque.front() + "\n");
                    }
                }
                if (split[0].equals("back")) {
                    if (deque.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(deque.back() + "\n");
                    }
                }
            }
        }

        bw.flush();
        bw.close();
    }
}

class Deque {

    ListNode head;

    public Deque() {
        head = new ListNode();
    }

    public void pushFront(int data) {
        head.add(head, new ListNode(data), 0);
    }

    public void pushBack(int data) {
        head.add(head, new ListNode(data), head.size());
    }

    public int popFront() {
        return head.remove(head, 0).number;
    }

    public int popBack() {
        return head.remove(head, head.size() - 1).number;
    }

    public int size() {
        return head.size();
    }

    public boolean isEmpty() {
        return head.size() == 0;
    }

    public int front() {
        return head.getPositionNumber(head, 0);
    }

    public int back() {
        return head.getPositionNumber(head, head.size() - 1);
    }
}

class ListNode {

    int number;

    ListNode node;

    ListNode top;

    public ListNode() {

    }

    public ListNode(int number) {
        this.number = number;
    }

    public ListNode add(
        ListNode head, ListNode nodeToAdd, int position) {
        top = head;
        for (int i = 0; i < position; i++) {
            top = top.node;
        }
        if (top.node != null) {
            nodeToAdd.node = top.node;
        }
        top.node = nodeToAdd;
        return head;
    }

    public int getPositionNumber(ListNode head, int position) {
        top = head;
        top = top.node;
        for (int i = 0; i < position; i++) {
            top = top.node;
        }
        return top.number;
    }

    public ListNode remove(ListNode head, int positionToRemove) {
        top = head;
        ListNode remove;
        for (int i = 0; i < positionToRemove; i++) {
            top = top.node;
        }
        if (top.node.node == null) {
            remove = top.node;
            top.node = null;
        } else {
            remove = top.node;
            top.node = top.node.node;
        }
        return remove;
    }

    public int size() {
        int count = 0;
        top = this;
        top = top.node;
        while (top != null) {
            top = top.node;
            count++;
        }
        return count;
    }

    public void setNode(ListNode node) {
        this.node = node;
    }

    public ListNode getNode() {
        return node;
    }

    public int getNumber() {
        return number;
    }
}
