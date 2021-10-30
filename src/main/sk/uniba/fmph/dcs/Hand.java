package sk.uniba.fmph.dcs;

import java.util.*;

public class Hand {
    private List<CardInterface> cards;
    private GameCardType cardType;

    public Hand(Deck deck){
        this.cards = deck.draw(5);
    }

    public void addCard(Card card){
        this.cards.add(card);
    }

    public void addCards(List<CardInterface> cards){
        this.cards.addAll(cards);
    }

    public boolean isActionCard(int idx){
        return this.cards.get(idx).cardType().isAction();
    }

    public boolean isInHand(CardInterface card){
        return this.cards.contains(card);
    }

    public CardInterface getCard(int idx){
        return this.cards.get(idx);
    }

    public CardInterface play(int idx){
        if (this.cards.get(idx)==null) return null;
        CardInterface tmp = cards.get(idx);
        this.cards.remove(idx);
        return tmp;
    }

    public List<CardInterface> throwAll(){
        List<CardInterface> tmp = new ArrayList<>();
        tmp.addAll(this.cards);
        this.cards.clear();
        return tmp;
    }

    public int getCoinsFromHand(){
        int countCoins = 0;
        for (int i = 0; i < this.cards.size(); i++){
            countCoins += this.cards.get(i).cardType().getPlusCoins();
        }
        return countCoins;
    }

    public int getSize() {
        return this.cards.size();
    }
}
