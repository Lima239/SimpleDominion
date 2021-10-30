package sk.uniba.fmph.dcs;

public interface EndGameStrategy {
    boolean isGameOver();
    boolean isVictory();

    void setTurn(Turn turn);
}
