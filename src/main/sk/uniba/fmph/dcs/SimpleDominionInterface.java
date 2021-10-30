package sk.uniba.fmph.dcs;

import java.util.Optional; 

/* This is the interface player can interact with */
interface SimpleDominionInterface {
    public boolean playCard(int handIdx);
    public boolean endPlayCardPhase();
    public boolean buyCard(int buyCardIdx);
    public boolean endTurn();
}
