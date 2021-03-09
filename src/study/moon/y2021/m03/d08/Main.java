package study.moon.y2021.m03.d08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

//https://www.acmicpc.net/problem/14725    [G2]    개미굴
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Trie trie = new Trie();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            trie.insert(Arrays.copyOfRange(s,1,Integer.parseInt(s[0])+1));
        }
        trie.print();
    }
}

class Trie {

    private TrieNode rootNode;

    public Trie() {
        rootNode = new TrieNode();
    }

    void insert(String[] words) {
        TrieNode thisNode = this.rootNode;
        for (String word : words) {
            thisNode = thisNode.getChildNodes()
                .computeIfAbsent(word, c -> new TrieNode());
        }
        thisNode.setIsLastChar(true);
    }

    void print() {
        TrieNode thisNode = this.rootNode;
        dfs(thisNode,"");
    }

    void dfs(TrieNode node, String layer) {
        node.getChildNodes().forEach((i,v)-> {
            System.out.println(layer+i);
            dfs(v,layer+"--");
        });
    }
}

class TrieNode {

    private Map<String, TrieNode> childNodes = new TreeMap<>();
    private boolean isLastChar;

    Map<String, TrieNode> getChildNodes() {
        return this.childNodes;
    }

    boolean isLastChar() {
        return this.isLastChar;
    }

    void setIsLastChar(boolean isLastChar) {
        this.isLastChar = isLastChar;
    }
}


