package mancala;

public interface PlayMancala {
    public static void main(String[] args){
        Bowl bowl = new Bowl();
        Player opponent = new Player(bowl.getOwner());
        System.out.println("**********Board********");
    
        System.out.println("Play 13 ");
        bowl.playTurn(13);        
        bowl.printGameCondition();
        System.out.println("**********************");

        System.out.println("Play 2 ");
        bowl.playTurn(2);
        bowl.printGameCondition();
        System.out.println("**********************");

        System.out.println("Play 5 ");
        bowl.playTurn(5);
        bowl.printGameCondition();
        System.out.println("**********************");

        System.out.println("Play 8, steal from 1");
        bowl.playTurn(8);
        bowl.printGameCondition();

    }

        
}
