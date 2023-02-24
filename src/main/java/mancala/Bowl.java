package mancala;

class Bowl extends Pit {
    Bowl(int stones) {
        super(stones);
    }

    //Take all stones from a bowl
    public Integer take() {
        int stones = this.stones;
        //After takeing all stones the bumber of stones is zero
        this.stones = 0;
        return stones;
    }

    //Each bowl can build another bowl
    public static Bowl bowlBuilder(int amount) {
        Bowl[] bowls = new Bowl[amount];
        for (int i = 0; i < amount; i++) {
            bowls[i] = new Bowl(4);
        }
        for (int i = 0; i < amount; i++) {
            if (i < amount - 2) {
                bowls[i].setNext(bowls[i+1]);
            }
        }
        return bowls[0];
    }

}

