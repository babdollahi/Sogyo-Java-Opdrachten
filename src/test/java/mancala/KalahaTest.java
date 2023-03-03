package mancala;

import static org.junit.Assert.assertSame;

import org.junit.Test;

public class KalahaTest {
    @Test
    public void shouldIntroduceWinner() {

        Bowl bowl = new Bowl();
        Player owner =  new Player();
        Player opponent = new Player(owner);

        Pit kalahaOwner = new Kalaha(7, owner, bowl.getNeighbour(1)); 
        Pit kalahaOpponent = new Kalaha(14, opponent, bowl.getNeighbour(1)); 
        kalahaOwner.receiveMultipleStones(20);
        kalahaOpponent.receiveMultipleStones(6);

        kalahaOwner.whoIsWinner(kalahaOpponent);

        assertSame(kalahaOwner.getOwner(), kalahaOwner.whoIsWinner(kalahaOpponent));
    }

}
