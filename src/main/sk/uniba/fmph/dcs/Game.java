package sk.uniba.fmph.dcs;

import java.util.List;
import java.util.Optional;

public class Game implements SimpleDominionInterface {

    private Turn turn;
    private EndGameStrategy strategy;

    public Game(EndGameStrategy strategy){
        this.turn = new Turn();
        this.turn.getTurnStatus().buyPhase = false;
        this.turn.getTurnStatus().playPhase = true;
        this.strategy = strategy;
        this.strategy.setTurn(this.turn);
    }

    public boolean playCard(int handIdx) {
        assert(0 <= handIdx && handIdx < 5);
        if (!turn.getTurnStatus().playPhase)
            return false;
        if (turn.getTurnStatus().actions <= 0)
            return false;
        if (strategy.isGameOver())
            return false;

        Hand hand = turn.getHand();
        CardInterface card = hand.getCard(handIdx);
        if (card == null || !card.cardType().isAction())
            return false;

        turn.evaluateActionCard(handIdx);
        turn.getTurnStatus().actions--;
        return true;
    }

    public boolean endPlayCardPhase(){
        turn.getTurnStatus().playPhase = false;
        turn.getTurnStatus().buyPhase = true;
        return !strategy.isGameOver();
    }

    public boolean buyCard(int buyCardIndex) {
        assert(0 <= buyCardIndex && buyCardIndex < 10);
        if (!turn.getTurnStatus().buyPhase)
            return false;
        if (turn.getTurnStatus().buys <= 0)
            return false;
        if (strategy.isGameOver())
            return false;

        int coinsFromHand = turn.getHand().getCoinsFromHand();
        int myCoins = coinsFromHand + turn.getTurnStatus().coins;
        int costOfCard = turn.getBuyDeck(buyCardIndex).cardType.cost;
        if (costOfCard < myCoins){
            if(costOfCard > coinsFromHand)
                turn.getTurnStatus().payCoins(costOfCard - coinsFromHand);
            turn.throwOneCardToDiscardPile(turn.getBuyDeck(buyCardIndex).buy());
            turn.getTurnStatus().buys--;
            return true;
        }
        return false;
    }

    public boolean endTurn(){
        turn.throwCardsAndTakeNew();
        turn.getTurnStatus().playPhase = true;
        turn.getTurnStatus().buyPhase = false;
        turn.getTurnStatus().actions++;
        turn.getTurnStatus().buys++;
        return !strategy.isGameOver();
    }

    public int getIndexOfFirstCardOfType(GameCardType type) {
        for (int i = 0; i < turn.getHand().getSize(); i++) {
            if (turn.getHand().getCard(i).cardType() == type)
                return i;
        }
        return -1;
    }
}
