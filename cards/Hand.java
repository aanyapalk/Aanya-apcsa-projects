package cards;

public class Hand {
    private Card[] cards;
    private int length;

    public Hand(int maxSize) {
        cards = new Card[maxSize];
        length = 0;
    }

    public void add(Card c) {
        if (length < cards.length) {
            cards[length++] = c;
        }
    }

    public int length() {
        return length;
    }

    public Card get(int index) {
        if (index < 0 || index >= length) return null;
        return cards[index];
    }

    public Card remove(int index) {
        if (index < 0 || index >= length) return null;
        Card removed = cards[index];
        for (int i = index; i < length - 1; i++) {
            cards[i] = cards[i + 1];
        }
        length--;
        return removed;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(cards[i]).append(" ");
        }
        return sb.toString().trim();
    }
}
