package sk.uniba.fmph.dcs;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(DiscardPileTest.class,
                DeckTest.class, BuyDeckTest.class, HandTest.class,
                PlayTest.class, TurnTest.class, GameTest.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        if (result.wasSuccessful())
            System.out.println("All tests passed.");
        else
            System.out.println("Some tests failed.");
    }
}