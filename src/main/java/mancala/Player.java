package mancala;

public class Player {

    private Player opponent;

    Player() {
        this.opponent = new Player(this);
    }

    Player(Player opponent) {
        this.setOpponent(opponent);
    }

    private void setOpponent(Player opponent) {
        this.opponent = opponent;
    }

    public Player getOpponent() {
        return this.opponent;
    }

}
