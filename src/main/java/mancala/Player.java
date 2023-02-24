package mancala;

import java.util.Date;

public class Player {
    private final Player opponent;
    private Date bithDate;
    private int age;

    public Player() {
        this.opponent = new Player(this);
    }

    private Player(Player opponent) {
        this.opponent = opponent;
    }

    public Player getOpponent() {
        return opponent;
    }

    public Date getBithDate() {
        return bithDate;
    }

    public void setBirthDate(Date birthDate) {
        this.bithDate = birthDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
