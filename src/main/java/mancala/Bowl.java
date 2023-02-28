package mancala;

class Bowl extends Pit {

    Bowl() {
        this.setStoneCount(4);
        this.setOwner(new Player());
        this.setNeighbour(new Bowl(1, this.getOwner(), this));
        // this.neighbourKalaha = new Kalaha();

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

}

