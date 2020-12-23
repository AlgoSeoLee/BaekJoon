package study.CheatSheet.KMP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static BufferedWriter bw;
    static BufferedReader br;
    static List<Integer> resultIndex;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        resultIndex = new ArrayList<>();

        char[] sentence = br.readLine().toCharArray();
        char[] word = br.readLine().toCharArray();

        kmp(sentence, word);

        bw.write(resultIndex.size()+"\n");
        for (Integer index : resultIndex) {
            bw.write(index+"\n");
        }
        bw.flush();
        bw.close();
    }

    static int[] makeTable(char[] word) {
        int length = word.length;
        int[] table = new int[length];
        int j = 0;
        for (int i = 1; i < length; i++) {
            while (j > 0 && word[i] != word[j]) {
                j = table[j - 1];
            }
            if (word[i] == word[j]) {
                table[i] = ++j;
            }
        }
        return table;
    }

    static void kmp(char[] sentence, char[] word) {
        int[] table = makeTable(word);
        int sentenceSize = sentence.length;
        int wordSize = word.length;
        int j = 0;
        for (int i = 0; i < sentenceSize; i++) {
            while (j > 0 && sentence[i] != word[j]) {
                j = table[j - 1];
            }
            if (sentence[i] == word[j]) {
                if (j == wordSize - 1) {
                    // index를 1부터 잰다. 0부터 재고싶다면 1을 뺀다.
                    resultIndex.add(i - wordSize + 1 + 1);
                    j = table[j];
                } else {
                    j++;
                }
            }
        }
    }
}

