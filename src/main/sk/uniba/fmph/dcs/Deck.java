package sk.uniba.fmph.dcs;

import java.util.*;

import static sk.uniba.fmph.dcs.GameCardType.*;

public class Deck {
    private List<CardInterface> cards;
    private int numOfRefills;

    public Deck(){
        cards = new LinkedList<>();
        for (int i = 0; i < 7; i++){
            cards.add(new Card(GAME_CARD_TYPE_COPPER));
        }
        for (int i = 0; i < 3; i++){
            cards.add(new Card(GAME_CARD_TYPE_ESTATE));
        }
        numOfRefills = 0;
    }

    public List<CardInterface> draw(int count){
        if (cards.size() < count)
            throw new IndexOutOfBoundsException();

        Collections.shuffle(cards);
        List<CardInterface> drawn_cards = new ArrayList<CardInterface>();
        for (int i = 0; i < count; i++) {
            drawn_cards.add(cards.get(0));
            cards.remove(0);
        }
        return drawn_cards;
    }

    public void refillFromDiscardPile(DiscardPile pile) {
        numOfRefills++;
        this.cards.addAll(pile.shuffle());
    }

    public int getSize(){
        return cards.size();
    }
    public int getNumOfRefills() { return numOfRefills; }
    public void removeAll(){ cards.clear(); }
}
