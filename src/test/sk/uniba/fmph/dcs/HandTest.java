package sk.uniba.fmph.dcs;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HandTest {
    @Test
    public void testInit() {
        Hand hand = new Hand(new Deck());
        assertEquals(hand.getSize(), 5);

        int coppers = 0;
        for (int i = 0; i < 5; i++) {
            if (hand.getCard(i).cardType() == GameCardType.GAME_CARD_TYPE_COPPER)
                coppers++;
        }
        assertTrue(coppers >= 2);
    }

    @Test
    public void testCoins() {
        Hand hand = new Hand(new Deck());
        int coppers = 0;
        int estates = 0;
        for (int i = 0; i < 5; i++) {
            if (hand.getCard(i).cardType() == GameCardType.GAME_CARD_TYPE_COPPER)
                coppers++;
            if (hand.getCard(i).cardType() == GameCardType.GAME_CARD_TYPE_ESTATE)
                estates++;
        }
        assertEquals(hand.getCoinsFromHand(), coppers);
    }
}
