package study.moon.d201207.t01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sizeOfCards = Integer.parseInt(br.readLine());

        CardSet cardSet = new CardSet(sizeOfCards);

        while (!cardSet.isLeftOneCard()) {
            cardSet.removeTopCard();
            cardSet.moveTopCardToBottom();
        }

        bw.write(Integer.toString(cardSet.getLastCardNumber()));
        bw.flush();
        bw.close();
    }

}

class CardSet {

    private final LinkedList<Integer> cards;

    public CardSet(int n) {
        this.cards = new LinkedList<>();
        init(n);
    }

    public void removeTopCard() {
        this.cards.removeFirst();
    }

    public void moveTopCardToBottom() {
        int topCard = this.cards.removeFirst();
        this.cards.addLast(topCard);
    }

    public boolean isLeftOneCard() {
        return this.cards.size() == 1;
    }

    private void init(int n) {
        for (int i = 1; i <= n; i++) {
            cards.add(i);
        }
    }

    public int getLastCardNumber() {
        return this.cards.peek();
    }
}
