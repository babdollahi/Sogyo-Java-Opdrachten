package mancala;

/**
 * Bowl and kalaha both represent a type of pit, so they are from one subclass.
 * Therefore I use inheritance here.
 */
abstract class Pit {
    protected int stones;
    Pit(int stones) {
        this.stones = stones;
    }
    
    //Count number of stones 
    public Integer count() {
        return stones;
    }

    //Recive one stone at a time
    public void receiveOneStone() {
        this.stones = this.stones + 1;
    }
}

class Bowl extends Pit {
    Bowl(int stones) {
        super(stones);
    }

    //Take all stones from a bowl
    public Integer take() {
        int stones = this.stones;
        //After takeing all stones the bumber of stones is zero
        this.stones = 0;
        return stones;
    }

}

class Kalaha extends Pit {
    Kalaha() {
        super(0);
    }

    //Recive multiple stones at a time
    public void receiveMultipleStones(int numberOfStones) {
        stones = stones + numberOfStones; 
    }
}


