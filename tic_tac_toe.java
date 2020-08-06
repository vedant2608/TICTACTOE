import java.io.*;
import java.util.Scanner;
class tic_tac_toe
{
     int counter;
    char posn[]=new char[10];
    char player;
    
    
    public static void main(String args[])
    {
        String ch;
        tic_tac_toe Toe=new tic_tac_toe();
        do{
            Toe.newBoard();
            Toe.play();
            System.out.println ("Would you like to play again (Enter 'yes' or 'No')? ");
            Scanner in =new Scanner(System.in);
            ch=in.nextLine();
            System.out.println("Your replay choice is "+ch);
        }while (ch.equals("yes "));
        
        
    }
    void newBoard()
    {
        
        char posndefine[] = {'0','1', '2', '3', '4', '5', '6', '7', '8', '9'};
        int i;
        counter = 0;
        player = 'X';
        for (i=1; i<10; i++) posn[i]=posndefine[i];
        currentBoard();
        
        
    }
    String currentBoard()
    {
        System.out.println(  "\n" );
        System.out.println(  " \t\t"+ posn [1] + "   | " +posn [2]+ "  | " +posn [3]);
        System.out.println(  " \t\t    |    |   " );
        System.out.println(  " \t\t    |    | " );
		System.out.println(  " \t\t--------------" );
        System.out.println(  " \t\t" +posn [4]+ "   | " +posn [5]+ "  | " +posn [6]);
        System.out.println(  " \t\t    |    |   " );
        System.out.println(  " \t\t    |    |" );
		System.out.println(  " \t\t--------------" );
        System.out.println(  " \t\t" +posn [7]+ "   | " +posn [8]+ "  | " +posn [9]);
        System.out.println(  " \t\t    |    |   " );
        System.out.println(  " \t\t    |    |   " );
        System.out.println(  "\n\n" );
        return "currentBoard";
    }
    
    void play()
    {
        int spot;
        char blank = ' ';
        
        System.out.println("Player " + getPlayer() +" will go first and be the letter 'X'" );
        
        do {           
            System.out.println("\n\nPlayer " + getPlayer() +" choose a posn." );
            
            boolean posTaken = true;
            while (posTaken) {
              
                Scanner in =new Scanner (System.in);
                spot=in.nextInt();
                posTaken = checkPosn(spot);
                if(posTaken==false)
                posn[spot]=getPlayer();
            } 
            currentBoard();              // display current board
            
            nextPlayer();
        }while ( checkWinner() == blank );
        
    }
    
    char checkWinner()
    {
        char Winner = ' ';
        
        // Check if X wins
        if (posn[1] == 'X' && posn[2] == 'X' && posn[3] == 'X') Winner = 'X';
        if (posn[4] == 'X' && posn[5] == 'X' && posn[6] == 'X') Winner = 'X';
        if (posn[7] == 'X' && posn[8] == 'X' && posn[9] == 'X') Winner = 'X';
        if (posn[1] == 'X' && posn[4] == 'X' && posn[7] == 'X') Winner = 'X';
        if (posn[2] == 'X' && posn[5] == 'X' && posn[8] == 'X') Winner = 'X';
        if (posn[3] == 'X' && posn[6] == 'X' && posn[9] == 'X') Winner = 'X';
        if (posn[1] == 'X' && posn[5] == 'X' && posn[9] == 'X') Winner = 'X';
        if (posn[3] == 'X' && posn[5] == 'X' && posn[7] == 'X') Winner = 'X';
        if (Winner == 'X' )
        {
			System.out.println("Player1 wins the game." );
            return Winner;
        }
        
        // Check if O wins
        if (posn[1] == 'O' && posn[2] == 'O' && posn[3] == 'O') Winner = 'O';
        if (posn[4] == 'O' && posn[5] == 'O' && posn[6] == 'O') Winner = 'O';
        if (posn[7] == 'O' && posn[8] == 'O' && posn[9] == 'O') Winner = 'O';
        if (posn[1] == 'O' && posn[4] == 'O' && posn[7] == 'O') Winner = 'O';
        if (posn[2] == 'O' && posn[5] == 'O' && posn[8] == 'O') Winner = 'O';
        if (posn[3] == 'O' && posn[6] == 'O' && posn[9] == 'O') Winner = 'O';
        if (posn[1] == 'O' && posn[5] == 'O' && posn[9] == 'O') Winner = 'O';
        if (posn[3] == 'O' && posn[5] == 'O' && posn[7] == 'O') Winner = 'O';
        if (Winner == 'O' )
        {
            System.out.println( "Player2 wins the game." );
        return Winner; }
        
        // check for Tie
        for(int i=1;i<10;i++)
        {
            if(posn[i]=='X' || posn[i]=='O')
            {
                if(i==9)
                {
                    char Draw='D';
                    System.out.println(" Game is Draw ");
                    return Draw;
                }
                continue;
            }
            else
            break;
            
        }
        
        return Winner;
    }
    
    boolean checkPosn(int spot)
    {
        
        
        if (posn[spot] == 'X' || posn[spot] == 'O')
        {
            System.out.println("That posn is already taken, please choose another");
            return true;
        }
        else {
            return false;
        }
        
        
    }
    
    
    
    void nextPlayer()
    {
        if (player == 'X')
        player = 'O';
        else player = 'X';
        
    }
    
    String getTitle()
    {
        return "Tic Tac Toe" ;
    }
    
    char getPlayer()
    {
        return player;
    }
    
}