package study.moon.y2020.m12.d201228.t02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BinarySearchTree bst = new BinarySearchTree();
        String str = "";
        while((str = br.readLine())!=null) {
            int n = Integer.parseInt(str);
            bst.add(n);
        }

        bst.dfs(bst.node);
        bw.flush();
        bw.close();
    }

    static class BinarySearchTree {

        public Node node;

        public BinarySearchTree() {

        }

        //iter
        public void add(int value) {
            Node tmp = node;
            if (node == null) {
                node = new Node(value, null);
                return;
            }
            while (true) {
                if (tmp.value > value) {
                    if (tmp.left == null) {
                        tmp.addLeft(value);
                        break;
                    }
                    tmp = tmp.left;
                } else if (tmp.value < value) {
                    if (tmp.right == null) {
                        tmp.addRight(value);
                        break;
                    }
                    tmp = tmp.right;
                } else {
                    System.out.println("tree has this value already.");
                }
            }
        }

        public void dfs(Node node) throws IOException {
            if (node.left == null && node.right == null) {
                bw.write(node.value+"\n");
                return;
            }
            if (node.left!=null) {
                dfs(node.left);
            }
            if (node.right!=null) {
                dfs(node.right);
            }
            bw.write(node.value+"\n");
        }

    }
}

class Node {
    int value;
    Node parent;
    Node left;
    Node right;

    public Node(int value, Node parent) {
        this.value = value;
        this.parent = parent;
    }

    public void addLeft(int value) {
        this.left = new Node(value,this);
    }

    public void addRight(int value) {
        this.right = new Node(value,this);
    }
}
