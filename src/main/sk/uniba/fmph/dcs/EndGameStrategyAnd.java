package sk.uniba.fmph.dcs;

public class EndGameStrategyAnd implements EndGameStrategy {
    private Turn turn;

    public EndGameStrategyAnd() { }

    @Override
    public void setTurn(Turn turn) {
        this.turn = turn;
    }

    @Override
    public boolean isGameOver() {
        int numEmptyBuyDecks = 0;
        for (int i = 0; i < 7; i++){
            if (turn.getBuyDeck(i).cardCount() == 0)
                numEmptyBuyDecks++;
        }
        return numEmptyBuyDecks >= 3 ||
                turn.getBuyDeck(1).cardCount() == 0 || // estates empty
                isVictory();
    }

    @Override
    public boolean isVictory() {
        return turn.getTurnStatus().coins > 10;
    }
}
