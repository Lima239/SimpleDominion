package sk.uniba.fmph.dcs;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DeckTest {
    @Test
    public void testInitSize() {
        Deck deck = new Deck();
        assertEquals(deck.getSize(), 10);
    }

    @Test
    public void testDrawCount() {
        Deck deck = new Deck();
        assertEquals(deck.draw(7).size(), 7);
    }

    @Test
    public void testInitCounts() {
        Deck deck = new Deck();
        List<CardInterface> cards = deck.draw(10);
        int coppers = 0;
        int estates = 0;
        for (int i = 0; i < 10; i++) {
            if (cards.get(i).cardType() == GameCardType.GAME_CARD_TYPE_COPPER)
                coppers++;
            if (cards.get(i).cardType() == GameCardType.GAME_CARD_TYPE_ESTATE)
                estates++;
        }
        assertEquals(coppers, 7);
        assertEquals(estates, 3);
    }

    @Test
    public void testRefillCount() {
        Deck deck = new Deck();
        deck.refillFromDiscardPile(new DiscardPile());
        deck.refillFromDiscardPile(new DiscardPile());
        assertEquals(deck.getNumOfRefills(), 2);
    }

    @Test
    public void testRefillFromDiscardPile() {
        Deck deck = new Deck();
        deck.draw(10); // empty deck
        List<CardInterface> cards = new ArrayList<>();
        cards.add(new Card(GameCardType.GAME_CARD_TYPE_FESTIVAL));
        cards.add(new Card(GameCardType.GAME_CARD_TYPE_LABORATORY));
        cards.add(new Card(GameCardType.GAME_CARD_TYPE_MARKET));
        cards.add(new Card(GameCardType.GAME_CARD_TYPE_FESTIVAL));
        DiscardPile pile = new DiscardPile(cards);
        deck.refillFromDiscardPile(pile);
        assertEquals(deck.getSize(), 4);
        assertEquals(deck.getNumOfRefills(), 1);
        List<CardInterface> cards2 = deck.draw(4);
        int festivals = 0;
        int laboratories = 0;
        int markets = 0;
        for (int i = 0; i < cards2.size(); i++) {
            if (cards.get(i).cardType() == GameCardType.GAME_CARD_TYPE_FESTIVAL)
                festivals++;
            if (cards.get(i).cardType() == GameCardType.GAME_CARD_TYPE_LABORATORY)
                laboratories++;
            if (cards.get(i).cardType() == GameCardType.GAME_CARD_TYPE_MARKET)
                markets++;
        }
        assertEquals(festivals, 2);
        assertEquals(laboratories, 1);
        assertEquals(markets, 1);
    }
}
