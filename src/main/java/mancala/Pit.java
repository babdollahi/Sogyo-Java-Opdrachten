package mancala;

/**
 * Bowl and kalaha both represent a type of pit, so they are from one subclass.
 * Therefore I use inheritance here.
 */
abstract class Pit {
    private Pit next;
    protected int stones;
    protected String owner;
    protected String opponent;

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

    //Finding the neighbour anti clockwise
    public Pit next() {
        return next;
    }

    //Setting the next neighbour 
    public Pit setNext(Pit next) {
        this.next = next;
        return next;
    }

    //Each bowl and kalaha know their owners
    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    //Each bowl and kalaha know their opponents
    public void setOpponent(String opponent) {
        this.opponent = opponent;
    }

    public String getOpponent() {
        return opponent;
    }

}
