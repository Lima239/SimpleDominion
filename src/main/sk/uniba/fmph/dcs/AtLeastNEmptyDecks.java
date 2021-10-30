package sk.uniba.fmph.dcs;

public class AtLeastNEmptyDecks implements EndGameStrategy {
    private int n;
    private Turn turn;

    public AtLeastNEmptyDecks(int n) {
        this.n = n;
    }

    @Override
    public void setTurn(Turn turn) {
        this.turn = turn;
    }

    @Override
    public boolean isGameOver() {
        return turn.getDeck().getNumOfRefills() >= n || isVictory();
    }

    @Override
    public boolean isVictory() {
        return  turn.getTurnStatus().coins > 5 &&         // has >= 5 coins
                turn.getBuyDeck(1).cardCount() < 8; // has >= 2 estates
    }
}
