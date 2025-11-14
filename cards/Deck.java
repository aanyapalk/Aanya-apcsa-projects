package cards;

import java.util.Random;

public class Deck {
private Card[] cards;
    private int top; 

    public Deck() {
        cards = new Card[52];
        int index = 0;
        for (int suit = 0; suit < 4; suit++) {
            for (int value = 0; value < 13; value++) {
                cards[index++] = new Card(suit, value);
            }
        }
        top = 0;
    }

    public void shuffle() {
        Random rand = new Random();
        for (int i = cards.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            Card temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }
        top = 0; 
    }

    public void cut(int index) {
        if (index < 0) index = 0;
        if (index > 51) index = 51;
        Card[] temp = new Card[52];
        int i = 0;
        for (int j = index; j < 52; j++) temp[i++] = cards[j];
        for (int j = 0; j < index; j++) temp[i++] = cards[j];
        cards = temp;
        top = 0;
    }

    public Card draw() {
        if (top >= cards.length) return null;
        return cards[top++];
    }

    public void print(int count) {
        for (int i = 0; i < count && i < cards.length; i++) {
            System.out.print(cards[i] + " ");
        }
        System.out.println();
    }

}
