package mancala;

class Kalaha extends Pit {
    Kalaha() {
        super(0);
    }

    //Recive multiple stones at a time
    public void receiveMultipleStones(int numberOfStones) {
        stones = stones + numberOfStones; 
    }

    // //Each bowl can build another bowl
    // public void kalahaBuilder(Kalaha newKalaha, Pit next) {
    //     Kalaha newKalaha = new Kalaha();
    //     newKalaha.setNext(Pit next);
    // }
}
