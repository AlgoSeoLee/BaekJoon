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

//https://www.acmicpc.net/problem/5052    [G4]    전화번호 목록
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        String[] arr;
        Trie trie;
        for (int i = 0; i < T; i++) {
            boolean isTrue = true;
            int n = Integer.parseInt(br.readLine());
            arr = new String[n];
            for (int j = 0; j < n; j++) {
                arr[j] = br.readLine();
            }
            Arrays.sort(arr, Comparator.comparingLong(Long::parseLong));
            trie = new Trie();
            for (String s : arr) {
                if (trie.contains(s)) {
                    isTrue = false;
                    break;
                }
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
            thisNode = thisNode.getChildNodes()
                .computeIfAbsent(word.charAt(i), c -> new TrieNode());
        }
        thisNode.setIsLastChar(true);
    }

    boolean contains(String word) {
        TrieNode thisNode = this.rootNode;
        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            TrieNode node = thisNode.getChildNodes().get(character);
            if (node == null) {
                return false;
            }
            thisNode = node;
            if (thisNode.isLastChar()) {
                return true;
            }
        }
        return thisNode.isLastChar();
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
