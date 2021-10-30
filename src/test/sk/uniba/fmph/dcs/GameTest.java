package sk.uniba.fmph.dcs;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {
    @Test
    public void test_game() {
        EndGameStrategy strategy = new AtLeastNEmptyDecks(3);
        Game game = new Game(strategy);
        int idx = game.getIndexOfFirstCardOfType(GameCardType.GAME_CARD_TYPE_FESTIVAL);
        assertFalse(game.playCard(idx == -1 ? 0 : idx));
        assertTrue(game.endPlayCardPhase());
        assertTrue(game.buyCard(1));
        assertTrue(game.endTurn());
        assertTrue(game.endPlayCardPhase());
        assertTrue(game.buyCard(1));
        assertTrue(game.endTurn());
        assertTrue(game.endPlayCardPhase());
        assertFalse(strategy.isGameOver());
        assertFalse(strategy.isVictory());
    }
}
