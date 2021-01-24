package study.moon.y2021.m01.d24.t02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            boolean isTrue = true;
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];
            for (int j = 0; j < n; j++) {
                arr[j] = br.readLine();
            }
            Arrays.sort(arr, Comparator.comparingInt(Integer::parseInt));
            Trie trie = new Trie();
            for (String s : arr) {
//                if (trie.contains(s)) {
//                    isTrue = false;
//                    break;
//                }
                trie.insert(s);
            }
            if (isTrue) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }
        bw.flush();
        bw.close();
    }
}

class Trie {

    private TrieNode rootNode;

    public Trie() {
        rootNode = new TrieNode();
    }

    void insert(String word) {
        TrieNode thisNode = this.rootNode;
        for (int i = 0; i < word.length(); i++) {
//            if (thisNode.getChildNodes()==null) {
//                TrieNode trie = new TrieNode();
//                trie.getChildNodes().put(word.charAt(i));
//            }
            thisNode = thisNode.getChildNodes()
                .computeIfAbsent(word.charAt(i), c -> new TrieNode());
        }
        thisNode.setIsLastChar(true);
    }

}

class TrieNode {

    private Map<Character, TrieNode> childNodes = new HashMap<>();
    private boolean isLastChar;

    Map<Character, TrieNode> getChildNodes() {
        return this.childNodes;
    }

    boolean isLastChar() {
        return this.isLastChar;
    }

    void setIsLastChar(boolean isLastChar) {
        this.isLastChar = isLastChar;
    }
}
