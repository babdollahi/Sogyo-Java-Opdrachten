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
        assertEquals(Integer(4) , bowl.count());
    }

    @Test
    public void shouldBeAbleToTakeAllStonesFromBowl()
    {
        Bowl bowl = new Bowl(4);
        //Check stones before taking from the bowl
        assertEquals(Integer(4) , bowl.count());
        bowl.take();
        //Check stones after taking from the bowl
        assertEquals(Integer(0) , bowl.count());
    }

    @Test
    public void shouldReceiveOneStone(){
        Bowl bowl = new Bowl(4);
        bowl.receiveOneStone();
        assertEquals(Integer(5) , bowl.count());
    }
     
    @Test
    public void kalahaShouldBeginEmpty()
    {
        Kalaha kalaha = new Kalaha();
        assertEquals(Integer(0) , kalaha.count());
    }

    @Test
    public void kalahaShouldBeAbleToReceiveOneStone(){
        Kalaha kalaha = new Kalaha();
        kalaha.receiveOneStone();
        assertEquals(Integer(1) , kalaha.count());
    }
    
    @Test
    public void kalahaShouldBeAbleToReceiveMultipleStones()
    {
        Kalaha kalaha = new Kalaha();
        kalaha.receiveMultipleStones(7);
        assertEquals(Integer(7) , kalaha.count());
    }


    private Object Integer(int i) {
        return i;
    }

}
