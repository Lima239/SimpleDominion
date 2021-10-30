package sk.uniba.fmph.dcs;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TurnTest {
    @Test
    public void testInit() {
        Turn turn = new Turn();
        for (int i = 0; i < 7; i++) {
            assertEquals(turn.getBuyDeck(0).cardCount(), 10);
        }
        assertEquals(turn.getTurnStatus().coins, 0);
        assertEquals(turn.getTurnStatus().actions, 1);
        assertEquals(turn.getTurnStatus().buys, 1);
    }

    @Test
    public void testEvaluateActionCard() {
        Turn turn = new Turn();
        turn.getHand().addCard(new Card(GameCardType.GAME_CARD_TYPE_VILLAGE));
        assertTrue(turn.evaluateActionCard(5));
        assertEquals(turn.getTurnStatus().coins,0);
        assertEquals(turn.getTurnStatus().actions, 3);
        assertEquals(turn.getTurnStatus().buys, 1);
    }

    @Test
    public void testThrowCardsAndTakeNew() {
        Turn turn = new Turn();
        turn.throwCardsAndTakeNew();
        assertEquals(turn.getDiscardPile().getSize(), 5);
        assertEquals(turn.getHand().getSize(), 5);
        assertEquals(turn.getDeck().getSize(), 0);
        turn.throwCardsAndTakeNew();
        assertEquals(turn.getDiscardPile().getSize(), 0);
        assertEquals(turn.getHand().getSize(), 5);
        assertEquals(turn.getDeck().getSize(), 5);
    }

}
