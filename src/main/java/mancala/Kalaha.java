package mancala;

class Kalaha extends Pit {

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

}