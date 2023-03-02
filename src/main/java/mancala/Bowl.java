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

    public void playTurn(int bowlToStartGame, Player whoIsTurn) {
        Pit playBowl = this.getNeighbour(bowlToStartGame);
        playBowl.setOwner(whoIsTurn);
        int stonesInBowl = playBowl.getStoneCount();
        playBowl.takeAllStones();
        int bowlToEndGame = bowlToStartGame + stonesInBowl;
        int stolenStones = 0;
        Kalaha kalahaOfOwner = new Kalaha();

        for (int i = bowlToStartGame + 1 ; i <=  bowlToEndGame ; i++) {

            if ((this.getNeighbour(i) instanceof Kalaha)) {
                if (this.getNeighbour(i).getOwner() ==  playBowl.getOwner() ) {
                    kalahaOfOwner = (Kalaha) this.getNeighbour(i);
                    this.getNeighbour(i).receiveOneStone();
                }
                else {
                    this.getNeighbour(i).receiveZeroStone();
                }
            }
            else {
                this.getNeighbour(i).receiveOneStone();
                if ((bowlToEndGame - i ) == 0) {
                    whoIsTurn.swichPlayer();
                    
                }
            }
        }

        if ((this.getNeighbour(bowlToEndGame) instanceof Bowl) &&
            (this.getNeighbour(bowlToEndGame).getOwner() == playBowl.getOwner()) &&
            (this.getNeighbour( bowlToEndGame).getStoneCount() == 1)) {

            stolenStones = this.getNeighbour(14 - bowlToEndGame).getStoneCount();
            this.getNeighbour(14 - bowlToEndGame).takeAllStones();
        }
        kalahaOfOwner.receiveMultipleStones(stolenStones + 1);
        gameEnded(whoIsTurn);
    }


    public void gameEnded(Player whoIsTurn) {
        int stonesInBowlsAfterTurnPlayer = 0;
        int stonesInBowlsAfterTurnOpponent = 0;
        for (int i = 1 ; i <  7 ; i++) {
            stonesInBowlsAfterTurnPlayer = stonesInBowlsAfterTurnPlayer + this.getNeighbour(i).getStoneCount();
        }
        for (int i = 8 ; i <  14 ; i++) {
            stonesInBowlsAfterTurnOpponent  = stonesInBowlsAfterTurnOpponent + this.getNeighbour(i).getStoneCount();
        }

        if (stonesInBowlsAfterTurnPlayer == 0 || stonesInBowlsAfterTurnOpponent == 0 ) {
            whoIsTurn.noOnePlays();
            }
    }
}
