package mancala;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
        Player player = new Player();
        bowl.playTurn(1,player); 
        assertEquals(0,bowl.getNeighbour(1).getStoneCount());
        assertEquals(5,bowl.getNeighbour(2).getStoneCount());
        assertEquals(5,bowl.getNeighbour(3).getStoneCount());
        assertEquals(5,bowl.getNeighbour(4).getStoneCount());
        assertEquals(5,bowl.getNeighbour(5).getStoneCount());
        assertEquals(4,bowl.getNeighbour(6).getStoneCount());

    }

    @Test
    public void shouldSwitchTurnWhenStartsFromBowlOne() {

        Bowl bowl = new Bowl();
        Player player = new Player();
        bowl.playTurn(1, player); 
        assertFalse(player.hasTurn);
    }

    @Test
    public void shouldNotSwitchTurnWhenStartsFromBowlThree() {

        Bowl bowl = new Bowl();
        Player player = new Player();
        bowl.playTurn(3, player); 
        assertTrue(player.hasTurn);
    }


    // @Test
    // public void shouldSwichPlayer() {

    //     // Bowl bowl = new Bowl();
    //     Player player = new Player();
        
    //     // bowl.playTurn(1, player); 
        

    // }


    // @Test
    // public void findOppositeBowlIndex() {

    //     Bowl bowl = new Bowl();
    //     bowl.getNeighbour(6).takeAllStones();
    //     bowl.playBowl(2);

    //     assertEquals(1,bowl.getNeighbour(6).getStoneCount());
    //     // assertEquals(8,bowl.playBowl(2));

    // }


    // @Test
    // public void findOppoppsiteBowlIndex() {

    //     Bowl bowl = new Bowl();
    //     bowl.getNeighbour(12).takeAllStones();
    //     // bowl.playBowl(1);

    //     // assertEquals(1,bowl.getNeighbour(4).getStoneCount());
    //     assertEquals(1,bowl.playBowl(8));

    // }


    }

    
