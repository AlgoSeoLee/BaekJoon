package study.moon.y2021.m03.d08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Trie trie = new Trie();
//        trie.insert(new String[]{"KIWI", "BANANA"});
//        trie.insert(new String[]{"KIWI", "APPLE"});
//        trie.insert(new String[]{"APPLE", "APPLE"});
//        trie.insert(new String[]{"APPLE", "BANANA", "KIWI"});
        trie.insert(new String[]{"B", "A"});
        trie.insert(new String[]{"A", "B","C","D"});
        trie.insert(new String[]{"A", "C"});
        System.out.println(trie.toString());
        String[] strings = trie.toString().split("[^A-Z]");
        System.out.println(Arrays.toString(strings));
        String[] strings1 = Arrays.stream(strings).map(v -> {
            if (v.length() == 0) {
                return "-";
            }
            return v;
        }).toArray(String[]::new);
        System.out.println(Arrays.toString(strings1));
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
        thisNode.getChildNodes().forEach((v,i)-> {

            System.out.println(v);
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


