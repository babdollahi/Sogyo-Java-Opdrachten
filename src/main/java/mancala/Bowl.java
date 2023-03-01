package mancala;

class Bowl extends Pit {
    int bowlToStartGame;
    int oppositeBowlIndex;
    // private Pit playBowl;

    Bowl() {
        this.setStoneCount(4);
        this.setOwner(new Player());
        this.setNeighbour(new Bowl(1, this.getOwner(), this));

    }

    Bowl(int bowlCount, Player owner, Pit firstPit) {
        bowlCount++;
        this.setStoneCount(4);
        this.setOwner(owner);
        if (bowlCount == 6 || bowlCount == 13) {
            this.setNeighbour(new Kalaha(bowlCount, this.getOwner(), firstPit));
        } else if (bowlCount < 14) {
            this.setNeighbour(new Bowl(bowlCount, this.getOwner(), firstPit));
        }
        if (bowlCount == 14) {
            this.setNeighbour(firstPit);
        }
    }

    public int playBowl(int bowlToStartGame) {
        Pit playBowl = this.getNeighbour(bowlToStartGame);
        int stonesInBowl = playBowl.getStoneCount();
        playBowl.takeAllStones();
        for (int i = bowlToStartGame + 1; i <= bowlToStartGame + stonesInBowl; i++) {
            this.getNeighbour(i).receiveOneStone();

            if ((this.getNeighbour(i) instanceof Bowl) && (this.getNeighbour(i).getStoneCount() == 1)) {

                oppositeBowlIndex = 13 - i ;
                return oppositeBowlIndex;
            }
        }

        return 0;

    }

}
