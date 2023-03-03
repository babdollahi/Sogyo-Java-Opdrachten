package mancala;

/**
 * Bowl and kalaha both represent a type of pit, so they are from one subclass.
 * Therefore I use inheritance here.
 */
abstract class Pit {
    
    protected int stones;
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
        if (steps < 0) {
            throw new IllegalArgumentException("steps can't be negative");
        }
        --steps;
        if (steps == 0) {
            return this;
        } else {
            return this.neighbour.getNeighbour(steps);
        }
    }

    public void receiveOneStone() {
        this.stones = this.stones + 1;
    }

    public void receiveZeroStone() {
        this.stones = this.stones + 0 ;
    }

    public Integer takeAllStones() {
        int stones = this.stones;
        this.stones = 0;
        return stones;
    }

    public void receiveMultipleStones(int multipleStones) {
        this.stones = stones + multipleStones; 
    }

    public String whoIsWinner(int bowlToStartGame) { 
        int sumStonePlayerKalaha = 0;
        int sumStoneOpponentKalaha = 0;
        String winner = "";
        for (int i = 1 ; i <=  14 ; i++) {
            if ((this.getNeighbour(i) instanceof Kalaha)) {
                if (this.getNeighbour(i).getOwner() == this.getNeighbour(bowlToStartGame).getOwner()) {
                sumStonePlayerKalaha = this.getNeighbour(i).getStoneCount();
            }
            else {
                sumStoneOpponentKalaha = this.getNeighbour(i).getStoneCount();
            }
        
            if ( sumStonePlayerKalaha > sumStoneOpponentKalaha) {
               winner = "Player is winner!";
                }
                else {
                winner = "Opponent is winner!";
                }
            }
        }
        return winner;
    }

    public void printGameCondition() {
        for (int i =1; i <= 14; i ++) {
        System.out.println("Stones in pit " + i + " : " +  this.getNeighbour(i).getStoneCount());
        }
    }

    protected void distribute(int stones) {
        if (stones > 0) {
            this.stones++;
        }
        if (--stones > 0) {
            this.getNeighbour().distribute(stones);
        }
    }
    
}
