package sk.uniba.fmph.dcs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Play {
    private ArrayList<CardInterface> cards;

    public Play(){
        cards = new ArrayList<>();
    }

    public void putTo(CardInterface card){
        cards.add(card);
    }

    public ArrayList<CardInterface> throwAll(){
        ArrayList<CardInterface> tmpCards = new ArrayList<>();
        tmpCards.addAll(cards);
        cards.clear();
        return tmpCards;
    }
}
