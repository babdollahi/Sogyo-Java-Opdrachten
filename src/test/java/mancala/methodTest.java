package mancala;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class methodTest {
    @Test
    public void bowlAndKalahaShouldReceiveOneStone() {

        Bowl bowl = new Bowl();
        bowl.receiveOneStone();
        assertEquals(5,bowl.getStoneCount());

        Kalaha kalaha = new Kalaha();
        kalaha.receiveOneStone();
        assertEquals(1,kalaha.getStoneCount());
    }

    @Test
    public void KalahaCouldReceiveMultipleStones() {

        Kalaha kalaha = new Kalaha();
        kalaha.receiveMultipleStones(7);
        assertEquals(7,kalaha.getStoneCount());
    }

    @Test
    public void shouldTakeStonesFromBowl() {

        Bowl bowl = new Bowl();
        bowl.takeAllStones();
        assertEquals(0,bowl.getStoneCount());
    }

    @Test
    public void shouldEmptyTheStartBowlAndAddOneStoneToNeighbours() {

        Bowl bowl = new Bowl();
        bowl.playBowl(3);
        assertEquals(0,bowl.getNeighbour(2).getStoneCount());
        assertEquals(5,bowl.getNeighbour(3).getStoneCount());
        assertEquals(5,bowl.getNeighbour(4).getStoneCount());
        assertEquals(5,bowl.getNeighbour(5).getStoneCount());
        assertEquals(5,bowl.getNeighbour(6).getStoneCount());
        assertEquals(1,bowl.getNeighbour(7).getStoneCount());
        assertEquals(4,bowl.getNeighbour(8).getStoneCount());

    }

    @Test
    public void findOppositeBowlIndex() {

        Bowl bowl = new Bowl();
        bowl.getNeighbour(4).takeAllStones();
        bowl.playBowl(3);

        assertEquals(1,bowl.getNeighbour(4).getStoneCount());
        assertEquals(9,bowl.playBowl(3));

    }


    @Test
    public void findOppoppsiteBowlIndex() {

        Bowl bowl = new Bowl();
        bowl.getNeighbour(12).takeAllStones();
        // bowl.playBowl(1);

        // assertEquals(1,bowl.getNeighbour(4).getStoneCount());
        assertEquals(1,bowl.playBowl(9));

    }


    }

    
