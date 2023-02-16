//Banafsheh Abdollahi wrote this program for Sudoku assignment.
public class sudoku 
{
    //size of the grid which is constant
    private static final int GRID_SIZE = 9; 

    //check if the number already exists in the row
    private static boolean checkRow(int[][] board, int number, int row)
    {
        //loop over the rows
        for(int i = 0; i < GRID_SIZE; i++)
        {
            if(board[row][i] == number)
            {
            return true;
            }
        }
        return false;
    }

    private static boolean checkColumn(int[][] board, int number, int column)
    {
        //loop over the rows
        for(int i = 0; i < GRID_SIZE; i++)
        {
            if(board[i][column] == number)
            {
            return true;
            }
        }
        return false;
    }

    private static boolean checkBox(int[][] board, int number, int row, int column)
    { 
        //Finfing the row and column number of the 3*3 box
        int smallBoxRow = row - row % 3;
        int smallBoxColumn = column - column % 3;

        //loop over the rows 
        //smallBoxRow + 3 because I want to loop over 3 rows at the box
        for(int i = smallBoxRow; i < smallBoxRow + 3 ; i++)
        {
            for(int j = smallBoxColumn; j < smallBoxColumn + 3 ; j++)
            {
                if(board[i][j] == number)
                {
                return true;
                }
            }
        }
        return false;
    }

    //check all to see if at the same time a number is valid in row, column and box
    private static boolean isCorrect(int[][] board, int number, int row, int column)
    {
        return !checkRow(board, number,row) &&
               !checkColumn(board, number,column) &&
               !checkBox(board, number, row, column);
    }

    //method to solve the puzzle by trying all possible numbers in a empty place
    private static boolean solve(int[][] board)
    {
        for(int row = 0; row < GRID_SIZE; row++)
        {
            for(int column = 0; column < GRID_SIZE; column++)
            {
            // I showed blank spot with 0 in the array, so if it is zero try a number
                if (board[row][column] == 0)
                {
                    //number between 1 to 9
                    for (int tryNumber = 1 ; tryNumber <= GRID_SIZE; tryNumber++)
                    {
                        if (isCorrect(board, tryNumber, row, column))
                        {
                            board[row][column] = tryNumber;
                            // Start again from the second bank spot, if true for all return true
                            if (solve(board))
                            {
                                return true;
                            }
                            else
                            //If could not find the correct value, set the spot again to zero
                            {
                                board[row][column] = 0;
                            }
                        }
                    }
                return false;
                }
            }
        }
        //if it passed all loops return true
        return true;
    }

    //method to print the board 
    private static void printBoard(int[][] board)
    {
        for(int row = 0; row < GRID_SIZE; row++)
        {
            if(row % 3 == 0 && row != 0)
            {
                System.out.println("-----------");
            }
            for(int column = 0; column < GRID_SIZE; column++)
            {
                if(column % 3 == 0 && column!= 0)
                {
                    System.out.print("|");
                }
            System.out.print(board[row][column]);
            }
        //print a line after each row
        System.out.println();
        }
    }        

    public static void main(String[] args)
    {
        long startTime = System.nanoTime();
        //Defineing a two dimentional array for the board
        int[][] board= 
            { 
            {0,0,0,8,2,0,0,9,0},
            {5,0,0,0,0,0,0,0,0},
            {3,0,8,0,4,0,0,0,7},
            {1,0,0,0,0,0,0,4,0},
            {0,0,6,4,0,2,5,0,3},
            {0,0,0,0,9,0,0,1,0},
            {0,9,3,0,0,4,0,0,0},
            {0,0,4,0,3,5,2,0,0},
            {0,0,0,7,0,0,9,0,0}
                                };
        
        //print board before solving
        System.out.println("**** Play Sudoko ****");
        System.out.println("The board to solve is: ");
        System.out.println("*********************");
        printBoard(board);
        System.out.println("*********************");

        if (solve(board)) 
        {
            System.out.println("Solved! ");
        }
        else
        {
            System.out.println("Unsolvable board!");
        }
        System.out.println("The board after the game is: ");
        System.out.println("*********************");
        //print board after solving
        printBoard(board);
        System.out.println("*********************");

        long stopTime = System.nanoTime();
        // int inSeconds = (int) (duration / 1000);
        System.out.println("Solved in " + ((stopTime - startTime)/1000000) + " mili seconds.");

    }
}