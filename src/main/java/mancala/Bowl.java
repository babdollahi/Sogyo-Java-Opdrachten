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
        // this.setOwner(whoIsTurn);
        // playBowl.setOwner(whoIsTurn);

        int stonesInBowl = playBowl.getStoneCount();
        playBowl.takeAllStones();
        int bowlToEndGame = bowlToStartGame + stonesInBowl;
        // int ownerKalahaIndex = 0;
        // int opponentKalahaIndex  =0;
        int stolenStones = 0;
        // stolenStones = stealStone(bowlToStartGame, bowlToEndGame);

        for (int i = bowlToStartGame + 1 ; i <=  bowlToEndGame ; i++) {
              if ((this.getNeighbour(i) instanceof Kalaha)) {
                if (this.getNeighbour(i).getOwner() ==  playBowl.getOwner() ) {
                    this.getNeighbour(i).receiveOneStone();
                    // this.getNeighbour(i).receiveMultipleStones(stolenStones);
                    // ownerKalahaIndex = i;
                }
                else {
                    // opponentKalahaIndex  = i;
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

        // //Adding stolen stones to my Kalaha
        // this.getNeighbour(ownerKalahaIndex);
        // stealStone(bowlToStartGame, bowlToEndGame);
        // receiveMultipleStones();
        //Check if game ended
        gameEnded(this.getOwner());
        this.whoIsWinner(bowlToEndGame);
        // //Find the winner 
        // this.getNeighbour(ownerKalahaIndex)
        //     .whoIsWinner(
        //         this.getNeighbour(opponentKalahaIndex ));

        // //Adding stolen stones to my Kalaha
        // this.getNeighbour(findMyKalahaIndex(bowlToStartGame)).receiveMultipleStones(stealStone(bowlToStartGame, bowlToEndGame));
        // //Check if game ended
        // gameEnded(whoIsTurn);
        // //Find the winner 
        // this.getNeighbour(findMyKalahaIndex(bowlToStartGame))
        //     .whoIsWinner(
        //         this.getNeighbour(findMyOpponentKalahaIndex(bowlToStartGame)));

        
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

    // public int findMyKalahaIndex(int bowlToStartGame) {
    //     int Kalaha = 0;
    //     for (int i = bowlToStartGame + 1 ; i <=  14 ; i++) {
    //         if ((this.getNeighbour(i) instanceof Kalaha)) {
    //             Kalaha = i;
    //         break;
    //         }
    //     }
    //     return Kalaha;
    // }

    // public int findMyOpponentKalahaIndex(int bowlToStartGame) {
    //     int Kalaha = 0;
    //     int counter = 0;
    //     for (int i = bowlToStartGame + 1 ; i <=  14 ; i++) {
    //         if ((this.getNeighbour(i) instanceof Kalaha)) {
    //             counter = counter + 1;
    //             if (counter == 2) {
    //                 Kalaha = i;
    //             break;
    //             }
    //         }
    //     }
    //     return Kalaha;
    // }

    // public int stealStone(int bowlToStartGame, int bowlToEndGame) {
    //     int stolenStones = 0;
    //     if ((this.getNeighbour(bowlToEndGame) instanceof Bowl) &&
    //         (this.getNeighbour(bowlToEndGame).getOwner() == this.getNeighbour(bowlToStartGame).getOwner()) && 
    //         (this.getNeighbour( bowlToEndGame).getStoneCount() == 1)) {
    //         //Plus one to add also the stone from the player's bowl
    //             stolenStones = (this.getNeighbour(14 - bowlToEndGame).getStoneCount()) + 1;
    //             this.getNeighbour(14 - bowlToEndGame).takeAllStones();
    //     }
    //     return stolenStones;

    // }


}
