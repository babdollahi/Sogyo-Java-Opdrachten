package mancala;

public class Player {
    Boolean hasTurn;

    private Player opponent;

    Player() { 
        hasTurn = true;
        this.opponent = new Player(this);
    }

    Player(Player opponent) {
        hasTurn = false;
        this.setOpponent(opponent);
    }

    private void setOpponent(Player opponent) {
        this.opponent = opponent;
    }

    public Player getOpponent() {
        return this.opponent;
    }
    
    public void swichPlayer() {
        hasTurn = false;
        opponent.hasTurn = true;
    }

    public void noOnePlays() {
        hasTurn = false;
        opponent.hasTurn = false;
    }
}
