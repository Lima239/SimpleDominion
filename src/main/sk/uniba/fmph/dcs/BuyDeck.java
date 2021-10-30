package sk.uniba.fmph.dcs;

import java.util.NoSuchElementException;

public class BuyDeck {
    private int count;
    public GameCardType cardType;

    public BuyDeck(int count, GameCardType cardType){
        this.count = count;
        this.cardType = cardType;
    }

    public int cardCount(){
        return this.count;
    }

    public CardInterface buy() {
        if (count == 0)
            return null;

        this.count--;
        return (CardInterface) new Card(this.cardType);
    }
}
