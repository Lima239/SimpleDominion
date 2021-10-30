package sk.uniba.fmph.dcs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BuyDeckTest {
    @Test
    public void testCount() {
        BuyDeck deck = new BuyDeck(3, GameCardType.GAME_CARD_TYPE_MARKET);
        assertNotEquals(deck.buy(), null);
        assertNotEquals(deck.buy(), null);
        assertNotEquals(deck.buy(), null);
        assertEquals(deck.buy(), null);
    }

    @Test
    public void testCardType() {
        BuyDeck deck = new BuyDeck(4, GameCardType.GAME_CARD_TYPE_ESTATE);
        CardInterface card = deck.buy();
        assertEquals(card.cardType(), GameCardType.GAME_CARD_TYPE_ESTATE);
    }
}
