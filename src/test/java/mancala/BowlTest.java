package mancala;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BowlTest {

    @Test
    public void shouldHaveFourStones() {

        Bowl bowl = new Bowl();
        assertEquals(4,bowl.getStoneCount());
    }

    @Test
    public void shouldHaveOwner() {

        Bowl bowl = new Bowl();
        assertNotNull(bowl.getOwner());
    }

    @Test
    public void shouldHaveNeighbour() {

        Bowl bowl = new Bowl();
        assertNotNull(bowl.getNeighbour());
    }

    @Test
    public void neighbourShouldHaveSameOwner() {

        Bowl bowl = new Bowl();
        assertSame(bowl.getOwner(), bowl.getNeighbour().getOwner());
    }

    @Test
    public void bowlShouldHaveTwoNeighbours() {

        Bowl bowl = new Bowl();
        assertNotNull(bowl.getNeighbour(2));
    }

    @Test
    public void bowlShouldHaveFiveNeighbours() {

        Bowl bowl = new Bowl();
        assertNotNull(bowl.getNeighbour(6));
    }

    @Test
    public void bowlShouldHaveKalahaInSixSteps() {

        Bowl bowl = new Bowl();
        Pit targetPit = bowl.getNeighbour(7);
        assertNotNull(targetPit);
        assertEquals(0,targetPit.getStoneCount());
        assertTrue(targetPit instanceof Kalaha);
    }

    @Test
    public void neighbourOfKalahaIsABowl() {

        Bowl bowl = new Bowl();
        Pit targetPit = bowl.getNeighbour(8);
        Pit kalahaPit = bowl.getNeighbour(7);
        assertNotNull(targetPit);
        assertEquals(4,targetPit.getStoneCount());
        assertTrue(targetPit instanceof Bowl);
        assertTrue(kalahaPit instanceof Kalaha);
        assertNotSame(targetPit.getOwner(), kalahaPit.getOwner());
    }

    @Test
    public void bowlShouldHaveKalahaIn13Steps() {

        Bowl bowl = new Bowl();
        Pit targetPit = bowl.getNeighbour(14);
        assertNotNull(targetPit);
        assertEquals(0,targetPit.getStoneCount());
        assertTrue(targetPit instanceof Kalaha);
    }

    @Test
    public void firstPitShouldBe15Pit() {

        Bowl bowl = new Bowl();
        assertSame(bowl, bowl.getNeighbour(15));
    }

    @Test
    public void when_distributing_stones_the_count_should_increase_by_1() {

        Bowl bowl = new Bowl();
        bowl.distribute(1);
        assertEquals(5, bowl.getStoneCount());
    }

    @Test
    public void when_distributing_0_stones_the_count_should_not_increase() {

        Bowl bowl = new Bowl();
        bowl.distribute(0);
        assertEquals(4, bowl.getStoneCount());
    }

    @Test
    public void when_distributing_2_stones_the_count_of_the_neighbour_should_also_increase_by_1() {

        Bowl bowl = new Bowl();
        bowl.distribute(2);
        assertEquals(5, bowl.getStoneCount());
        assertEquals(5, bowl.getNeighbour().getStoneCount());
    }

}
