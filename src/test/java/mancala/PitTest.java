package mancala;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


/**
 * Unit test for macala initialization.
 */
public class PitTest 
{

    @Test
    public void shouldStoreStonesInBowl()
    {
        Bowl bowl = new Bowl(4);
        assertEquals(Integer.valueOf(4) , bowl.count());
    }

    @Test
    public void shouldBeAbleToTakeAllStonesFromBowl()
    {
        Bowl bowl = new Bowl(4);
        //Check stones before taking from the bowl
        assertEquals(Integer.valueOf(4) , bowl.count());
        bowl.take();
        //Check stones after taking from the bowl
        assertEquals(Integer.valueOf(0) , bowl.count());
    }

    @Test
    public void bowlShouldReceiveOneStone()
    {
        Bowl bowl = new Bowl(4);
        bowl.receiveOneStone();
        assertEquals(Integer.valueOf(5) , bowl.count());
    }
     
    @Test
    public void kalahaShouldBeginEmpty()
    {
        Kalaha kalaha = new Kalaha();
        assertEquals(Integer.valueOf(0) , kalaha.count());
    }

    @Test
    public void kalahaShouldBeAbleToReceiveOneStone()
    {
        Kalaha kalaha = new Kalaha();
        kalaha.receiveOneStone();
        assertEquals(Integer.valueOf(1) , kalaha.count());
    }
    
    @Test
    public void kalahaShouldBeAbleToReceiveMultipleStones()
    {
        Kalaha kalaha = new Kalaha();
        kalaha.receiveMultipleStones(7);
        assertEquals(Integer.valueOf(7) , kalaha.count());
    }

    @Test
    public void setAndGetMyOwner() {
        Kalaha kalaha = new Kalaha();
        kalaha.setOwner("Player1");
        assertEquals("Player1", kalaha.getOwner());
    }

    // @Test
    // public void buildBowlAndSetNext(){
    //     Pit kalahaOne = new Kalaha();
    //     bowlBuilder("BowlSix", kalahaOne);
    // }

    @Test
    public void eachPitshouldPointToTheNextPit() 
    {
        Pit a = new Bowl(4);
        Kalaha b = new Kalaha();
        Bowl c = new Bowl(4);

        a.setNext(b);
        b.setNext(c);

        assertEquals(a.next() , b);
        assertEquals(b.next() , c);
    }

}
