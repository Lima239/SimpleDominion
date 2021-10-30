package sk.uniba.fmph.dcs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayTest {
    @Test
    public void testDummy() {
        Play play = new Play();
        CardInterface card = new Card(GameCardType.GAME_CARD_TYPE_MARKET);
        play.putTo(card);
        assertEquals(play.throwAll().get(0).cardType(), GameCardType.GAME_CARD_TYPE_MARKET);
    }
}
