package mancala;


public class Board {
    // static Pit board;
    // static Bowl bowlsOne;
    // static Bowl bowlsTwo;

    // public static void main(String[] args){
    //     Kalaha kalahaOne = Kalaha.creatKalaha("playerOne", "playerTwo");       
    //     Kalaha kalahaTwo = Kalaha.creatKalaha("playerTwo", "playerOne");

    //     bowlsOne = Bowl.bowlBuilder(6,"playerOne", "playerTwo");
    //     bowlsTwo = Bowl.bowlBuilder(6,"playerTwo", "playerOne");

    //     //Linking bowls and kalahas
    //     board = bowlsOne.setNext(kalahaOne).setNext(bowlsTwo).setNext(kalahaTwo).setNext(bowlsOne);


    // }
}
 












// class Board { 
//     private static final String String = null;
//     String Player;
//     String Opponent;

//     static void creatSixBowlsWithFourStones(String Player, String Opponent) {
//         Bowl [] bowls = new Bowl [6];
//         for (int i = 0; i < 6; i++) {
//             bowls[i] = new Bowl(4);
//             bowls[i].setOwner(Player);
//             bowls[i].setOpponent(Opponent);
//         }
//         linkBowls(bowls);
//     }

//     static Bowl[] linkBowls(Bowl[] bowls) {
//         for (int i = 0; i < 6; i++) {
//             for (int j = 1; j < 7; j++) {
//                 bowls[i].setNext(bowls[j]);
//             }
//         }
//         return bowls;
//     }
    
//     static void creatKalaha(String player, String opponent){
//         Kalaha kalaha = new Kalaha();
//         kalaha.setOwner(player);
//         kalaha.setOpponent(opponent);
//     }

//     static void creatChain(){
//         creatSixBowlsWithFourStones(String Player, String Opponent);

//     }

//     @Override
//     public String toString() {
//         return "Board []";
//     }
// }

//     // private Object bowlBuilder(int i) {
//     //     return null;
//     // }