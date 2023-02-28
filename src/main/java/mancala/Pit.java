package mancala;

/**
 * Bowl and kalaha both represent a type of pit, so they are from one subclass.
 * Therefore I use inheritance here.
 */
abstract class Pit {
    
    private int stones;
    private Player owner;
    private Pit neighbour;

    Pit() {
        
    }

    public int getStoneCount() {

        return this.stones;
    }

    public void setStoneCount(int stones) {
        
        this.stones = stones;
    }

    public Player getOwner() {
        return this.owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public Pit getNeighbour() {
        return this.neighbour;
    }

    public void setNeighbour(Pit neighbour) {
        this.neighbour = neighbour;
    }

    public Pit getNeighbour(int steps) {
        --steps;
        if (steps == 0) {
            return this;
        } else {
            return this.neighbour.getNeighbour(steps);
        }
    }

}
