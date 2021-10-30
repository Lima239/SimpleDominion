package sk.uniba.fmph.dcs;

import java.util.ArrayList;
import java.util.List;

import static sk.uniba.fmph.dcs.GameCardType.*;

public class Turn {

    private Hand hand;
    private Deck deck;
    private Play play;
    private ArrayList<BuyDeck> buyDeck;
    private TurnStatus turnStatus;
    private DiscardPile discardPile;

    public Turn(){
        buyDeck = new ArrayList<>();

        BuyDeck BuyDeck1 = new BuyDeck(10,GAME_CARD_TYPE_MARKET);
        buyDeck.add(BuyDeck1);
        BuyDeck BuyDeck2 = new BuyDeck(10,GAME_CARD_TYPE_ESTATE);
        buyDeck.add(BuyDeck2);
        BuyDeck BuyDeck3 = new BuyDeck(10,GAME_CARD_TYPE_COPPER);
        buyDeck.add(BuyDeck3);
        BuyDeck BuyDeck4 = new BuyDeck(10,GAME_CARD_TYPE_SMITHY);
        buyDeck.add(BuyDeck4);
        BuyDeck BuyDeck5 = new BuyDeck(10,GAME_CARD_TYPE_VILLAGE);
        buyDeck.add(BuyDeck5);
        BuyDeck BuyDeck6 = new BuyDeck(10,GAME_CARD_TYPE_FESTIVAL);
        buyDeck.add(BuyDeck6);
        BuyDeck BuyDeck7 = new BuyDeck(10,GAME_CARD_TYPE_LABORATORY);
        buyDeck.add(BuyDeck7);

        this.turnStatus = new TurnStatus(1, 1, 0);
        this.discardPile = new DiscardPile();
        this.deck = new Deck();
        this.hand = new Hand(this.deck);
        this.play = new Play();
    }

    public boolean evaluateActionCard(int idx){
        if(hand.isActionCard(idx)){
            CardInterface card = hand.getCard(idx);
            GameCardType gameCardType = card.cardType();
            turnStatus.actions += gameCardType.getPlusActions();
            turnStatus.coins += gameCardType.plusCoins;
            turnStatus.buys += gameCardType.plusBuys;
            return true;
        }
        return false;
    }

    public void throwCardsAndTakeNew(){
        throwToDiscardPile();
        if (deck.getSize() < 5)
            deck.refillFromDiscardPile(discardPile);
        getCardsOnHand();
    }

    public void throwToDiscardPile(){
        discardPile.addCards((List<CardInterface>) play.throwAll());
        discardPile.addCards(hand.throwAll());
    }

    public void throwOneCardToDiscardPile(CardInterface card){
        discardPile.addCard(card);
    }

    public Hand getHand(){
        return this.hand;
    }
    public Deck getDeck() { return this.deck; }
    public Play getPlay() { return this.play; }
    public DiscardPile getDiscardPile() { return this.discardPile; }

    private void getCardsOnHand(){
        this.hand.addCards(this.deck.draw(5));
    }

    public TurnStatus getTurnStatus(){
        return this.turnStatus;
    }
    public BuyDeck getBuyDeck(int index){
        return buyDeck.get(index);
    }
}
