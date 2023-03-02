package mancala;

class Kalaha extends Pit {
    int multipleStones;

    public Kalaha() {
    }

    Kalaha(int bowlCount, Player owner, Pit firstPit) {
        bowlCount++;
        this.setStoneCount(0);
        this.setOwner(owner);
        if (bowlCount < 14) {
            this.setNeighbour(new Bowl(bowlCount, this.getOwner().getOpponent(), firstPit));
        }
        if (bowlCount == 14) {
            this.setNeighbour(firstPit);
        }
    }

    public void receiveMultipleStones(int multipleStones) {
        this.stones = stones + multipleStones; 
    }

    public Player whoIsWinner(Kalaha kalahaOpponent) { 
        if (this.getStoneCount() > kalahaOpponent.getStoneCount()) {
        return this.getOwner();
        }
        else {
            return kalahaOpponent.getOwner();
        }
    }

}