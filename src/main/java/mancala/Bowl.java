package mancala;

class Bowl extends Pit {
    int bowlToStartGame;
    int oppositeBowlIndex;

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

    public void playTurn(int bowlToStartGame) {
        Pit playBowl = this.getNeighbour(bowlToStartGame);
        int stonesInBowl = playBowl.getStoneCount();
        playBowl.takeAllStones();
        int bowlToEndGame = bowlToStartGame + stonesInBowl;
        int stolenStones = 0;

        for (int i = bowlToStartGame + 1 ; i <=  bowlToEndGame ; i++) {
              if ((this.getNeighbour(i) instanceof Kalaha)) {
                if (this.getNeighbour(i).getOwner() ==  playBowl.getOwner() ) {
                    this.getNeighbour(i).receiveOneStone();
                }
                else {
                    this.getNeighbour(i).receiveZeroStone();
                }
            }
            else {
                this.getNeighbour(i).receiveOneStone();
                if ((bowlToEndGame - i ) == 0 &&
                    (this.getNeighbour(i).getOwner() == playBowl.getOwner()) && 
                    (this.getNeighbour(i).getStoneCount() == 1)) {
                        //Plus one to add also the stone from the player's bowl
                        stolenStones = (this.getNeighbour(14 - i).getStoneCount()) + 1;
                        this.getNeighbour(14 - i).takeAllStones();
                }
                if ((bowlToEndGame - i ) == 0) {
                    this.getOwner().swichPlayer();
                    
                }
            }
        }

        for (int i = 1 ; i <=  14 ; i++) {
            if ((this.getNeighbour(i) instanceof Kalaha) &&
                this.getNeighbour(i).getOwner() ==  playBowl.getOwner()) {
                    this.getNeighbour(i).receiveMultipleStones(stolenStones);
            
            }
        }
        gameEnded(this.getOwner());
        this.whoIsWinner(bowlToEndGame);
    }

    public boolean gameEnded(Player whoIsTurn) {
        boolean continueGame = true;
        int sumStonesInBowlsPlayer = 0;
        int sumStonesInBowlsOpponent = 0;
        for (int i = 1 ; i <  7 ; i++) {
            sumStonesInBowlsPlayer = sumStonesInBowlsPlayer + this.getNeighbour(i).getStoneCount();
        }
        for (int i = 8 ; i <  14 ; i++) {
            sumStonesInBowlsOpponent  = sumStonesInBowlsOpponent + this.getNeighbour(i).getStoneCount();
        }
        if (sumStonesInBowlsPlayer == 0 || sumStonesInBowlsOpponent == 0 ) {
            whoIsTurn.noOnePlays();
            continueGame = false;
            }
        return continueGame;
    }
}
