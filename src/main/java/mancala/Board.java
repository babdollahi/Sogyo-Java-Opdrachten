package mancala;

class Board {

    String Player;
    String Opponent;

    static void creatSixBowlsWithFourStones(String Player, String Opponent) {
        Bowl [] bowls = new Bowl [6];
        for (int i = 0; i < 6; i++) {
            bowls[i] = new Bowl(4);
            bowls[i].setOwner(Player);
            bowls[i].setOpponent(Opponent);
        }
        linkBowls(bowls);
    }

    static void linkBowls(Bowl[] bowls) {
        for (int i = 0; i < 6; i++) {
            for (int j = 1; j < 7; j++) {
                bowls[i].setNext(bowls[j]);
            }
        }
    }
    
    static void creatKalaha(String player, String opponent){
        Kalaha kalaha = new Kalaha();
        kalaha.setOwner(player);
        kalaha.setOpponent(opponent);
    }
}