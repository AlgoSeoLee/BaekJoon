package study.moon.y2020.m12.d201225.t01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {//이진트리

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Node head = new Node('A');

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            Node target = head.findData(head, s[0].charAt(0));
            if (!s[1].equals(".")) {
                target.addLeft(new Node(s[1].charAt(0)));
            }
            if (!s[2].equals(".")) {
                target.addRight(new Node(s[2].charAt(0)));
            }
        }
        for (Character character : head.getPreorder()) {
            bw.write(character + "");
        }
        bw.write("\n");
        for (Character character : head.getInorder()) {
            bw.write(character + "");
        }
        bw.write("\n");
        for (Character character : head.getPostorder()) {
            bw.write(character + "");
        }
        bw.flush();
        bw.close();


    }

}

class Node {

    char data;
    Node left;
    Node right;

    @Override
    public String toString() {
        return "Node{" +
            "data=" + data +
            '}';
    }

    private final List<Character> result = new ArrayList<>();

    public Node(char data) {
        this.data = data;
    }

    public void addLeft(Node node) {
        this.left = node;
    }

    public void addRight(Node node) {
        this.right = node;
    }

    public Node findData(Node node, char data) {
        if (node.data == data) {
            return node;
        } else {
            if (node.left == null && node.right == null) {
                return null;
            }
            Node data1 = null;
            Node data2 = null;
            if (node.left != null) {
                data1 = findData(node.left, data);
            }
            if (node.right != null) {
                data2 = findData(node.right, data);
            }
            if (data1 != null) {
                return data1;
            }
            if (data2 != null) {
                return data2;
            }
            return null;
        }
    }

    public List<Character> getPreorder() {
        result.clear();
        preorder(this);
        return result;
    }

    public List<Character> getInorder() {
        result.clear();
        inorder(this);
        return result;
    }

    public List<Character> getPostorder() {
        result.clear();
        postorder(this);
        return result;
    }

    private void preorder(Node node) {
        result.add(node.data);
        if (node.left != null) {
            preorder(node.left);
        }
        if (node.right != null) {
            preorder(node.right);
        }
    }

    private void inorder(Node node) {
        if (node.left != null) {
            inorder(node.left);
        }
        result.add(node.data);
        if (node.right != null) {
            inorder(node.right);
        }
    }

    private void postorder(Node node) {
        if (node.left != null) {
            postorder(node.left);
        }
        if (node.right != null) {
            postorder(node.right);
        }
        result.add(node.data);
    }
}
