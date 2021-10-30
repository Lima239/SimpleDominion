package sk.uniba.fmph.dcs;

import java.util.Optional; 
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class DiscardPile {
    private List<CardInterface> cards;

    public DiscardPile(List<CardInterface> cards) {
        this.cards = new ArrayList<>();
        this.cards.addAll(cards);
    }

    public DiscardPile() {
        this.cards = new ArrayList<>();
    }
        
    public Optional<CardInterface> getTopCard() {
    	if (cards.isEmpty()) return Optional.empty();
        return Optional.of(cards.get(cards.size()-1));
    }
        
    public void addCards(List<CardInterface> cards) {
        this.cards.addAll(cards);
    }

    public void addCard(CardInterface card) {
        this.cards.add(card);
    }

    public int getSize() {
        return this.cards.size();
    }
        
    public List<CardInterface> shuffle() {
        Collections.shuffle(cards);
        List<CardInterface> cards_to_send = cards;        
        cards = new ArrayList<CardInterface>();
        return cards_to_send;
    }
}
        
        
