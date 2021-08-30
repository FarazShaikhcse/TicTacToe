package com.yml.tictactoe;

import java.util.Random;
import java.util.Scanner;

/**
 * @author faraz shaikh This is the program that simulates tic tac toe game The
 *         game will be played between the user and the computer
 */
public class TicTacToeGame {

	private char[] board = new char[10];
	char playerLetter, computerLetter;
	Boolean usersTurn;

	public static void main(String[] args) {

		System.out.println("Welcome to game");
		TicTacToeGame ticTacToeGame = new TicTacToeGame();
		ticTacToeGame.createBoard();
		ticTacToeGame.selectLetter();
		ticTacToeGame.toss();
		
	}

	/**
	 * This method creates the board by initialising all the boxes to empty space
	 */
	public void createBoard() {
		for(int i=1;i<board.length;i++)     
		{
			board[i] = ' ';
		}
	}

	/**
	 * This method prompts the user to select a letter to play the game
	 */
	public void selectLetter() {

		
			System.out.println("Choose your letter.I.e X or O");
			Scanner r = new Scanner(System.in);
			playerLetter = r.nextLine().charAt(0);
		
			if (Character.compare(playerLetter, 'O') == 0) {

				computerLetter = 'X';
				
				
			} else if (Character.compare(playerLetter, 'X') == 0) {
				
				computerLetter = 'O';
				
			} else {
				
				System.out.println("Invalid input");
				selectLetter();

			}
			System.out.println("Player chose " + playerLetter);
			System.out.println("Computer's Letter will be " + computerLetter);

	}

	

	/**
	 * this method displays the board where the game will be played
	 */
	public void displayBoard() {
		System.out.println(" "+board[1] + " | "+ board[2] + " | " + board[3]);	//display first row
		System.out.println("---+---+---");
		System.out.println(" "+board[4] + " | "+ board[5] + " | " + board[6]);	//display second row
		System.out.println("---+---+---");
		System.out.println(" "+board[7] + " | "+ board[8] + " | " + board[9]);	
	}
	/**
	 * this method checks for available moves
	 */
	
	public void userMove() {
		usersTurn = true;
		int index;
		Scanner scanner = new Scanner(System.in);
		
			System.out.println("Enter the index between 1 to 9 to which you wanna move");
			
			index = scanner.nextInt();
			if(index > 9 || index < 0) {
				System.out.println("Invalid index, Choose index between 1 to 9");
				userMove();
			} 
			String c = String.valueOf(board[index]);  
			if( board[index]==' ') {
				
				System.out.println("Index is free and you have made the move");
				board[index] = playerLetter;
			
			}
			else {
				System.out.println("Index is full and you cannot make move to that index"+index);
				userMove();
			}
			displayBoard();
			displayWinner();
	}
	
	/**
	 * This method is implemented to determine who starts the game first
	 */
	public void toss()
	{
		System.out.println("Enter your choice \n 0.Head\n 1.Tail");
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		int choice = scanner.nextInt();	
		
		/* a random number is chosen between 1 or 0
		 * if its 0 then head or if it is 1 its tail
		 */
		int toss_choice = random.nextInt(2);						
		if(choice==toss_choice)
		{
			userMove();
		}
		else
		{
			computersMove();
		}
		
	}
	
	/**
	 * @return char that tells who has won the game
	 */
	public char checkWinnerExist()
    {
		String line = null;
		
		//to check if there is an winning situation
		for (int s = 1; s < 9; s++) 
        {
			
            switch (s) {
            case 1:
                line = ""+board[1] + board[2] + board[3];
                break;
            case 2:
                line = ""+board[4] + board[5] + board[6];
                break;
            case 3:
                line = ""+board[7] + board[8] + board[9];
                break;
            case 4:
                line = ""+board[1] + board[4] + board[7];
                break;
            case 5:
                line = ""+board[2] + board[5] + board[8];
                break;
            case 6:
                line = ""+board[3] + board[5] + board[9];
                break;
            case 7:
                line = ""+board[1] + board[5] + board[9];
                break;
            case 8:
                line = ""+board[3] + board[5] + board[7];
                break;
            }
            //winner is X
            if (line.equals("XXX")) {
                return 'X';
            } 
            // winner is O
            else if (line.equals("OOO")) {
                return 'O';
            }
         }
		int i;
        for(i=1;i<=9;i++) {
        	if (board[i]==' ') 
        	{
        		break;
        	}
        }
     	 if(i==9)
     		 return 'd';
     	 else
     		 return 'n';
    }
	
	
    /**
     * This method displays the winning player or determines whether it is a tie.
     */
    public void displayWinner()
    {
    	
       char win = checkWinnerExist();
        if(win == playerLetter)
        {
        	System.out.println("You have won the game");
        	newGame();
        }
        else if(win == computerLetter)
        {
        		System.out.println("Computer has won the game");
        		newGame();
        }
        else if(win == 'd')
        {
        	System.out.println("Game has been tie");
        	newGame();
        }
        else
        {
        	if (usersTurn==false) {
        		userMove();
            }
            else {
            	computersMove();

            }
        }    
    }

	

	/**
	 * this method checks the moves which can make computer win
	 */
	public void computersMove() {
		usersTurn = false;
		System.out.println("Computer is playing!!!");	
		if((board[1] == ' ')&&(board[2] == board[3]&&board[2] == computerLetter)||(board[4] == board[7]&&board[4] == computerLetter)||(board[5] == board[9]&&board[5] == computerLetter))
		{
			board[1] = computerLetter;			
		}
		else if((board[2] == ' ')&&(board[1] == board[3] && board[3] == computerLetter)|| (board[5] == board[8] && board[8] == computerLetter))
		{
			board[2] = computerLetter;
		}
		else if((board[3] == ' ') && (board[1] == board[2] && board[2] == computerLetter)||(board[6] == board[9] && board[9] == computerLetter)||(board[5] == board[7] && board[7] == computerLetter))
		{
			board[3] = computerLetter;
		}
		else if((board[4] == ' ') && (board[1] == board[7]&&board[1] == computerLetter)||(board[5] == board[6] && board[6] == computerLetter))
		{
			board[4] = computerLetter;
		}
		else if((board[5] == ' ') && (board[1] == board[9]&&board[2] == computerLetter)||(board[7] == board[3] && board[7] == computerLetter)||(board[2] == board[8]&&board[8] == computerLetter)||(board[4] == board[6]&&board[6] == computerLetter))
		{
			board[5] = computerLetter;
		}
		else if((board[6] == ' ')&&(board[9] == board[3] && board[3] == computerLetter)||(board[5] == board[4] && board[4] == computerLetter))
		{
			board[6] = computerLetter;
		}
		else if((board[7] == ' ')&&(board[1] == board[4] && board[4] == computerLetter)||(board[3] == board[5]&&board[3] == computerLetter)||(board[8] == board[9] && board[8] == computerLetter))
		{
			board[3] = computerLetter;
		}
		else if((board[8] == ' ')&&(board[9] == board[7] && board[7] == computerLetter) || (board[2] == board[5] && board[2] == computerLetter))
		{
			board[8] = computerLetter;
		}
		else if((board[9] == ' ')&&(board[1] == board[5] && board[5] == computerLetter) || (board[6] == board[3] && board[3] == computerLetter)||(board[8] == board[7] && board[7] == computerLetter))
		{
			board[9] = computerLetter;
		}
	   	else {
			computerPlay();			
		}
		displayBoard();
		displayWinner();
		
		
	}

	/**
	 * This method inserts the computer's letter at random location
	 */
	private void computerPlay() {
		int corner[]= {1,3,7,9};
		Boolean flag = false;
		for(int i=0;i<4;i++)
		{
			if(board[corner[i]]==' ')
			{
				board[corner[i]]= computerLetter;
				flag = true;
				break;
			}
		}
		if(!flag)
		{	
			if(board[5] == ' ') {
				board[5] = computerLetter;
			}
			else
				randomMove();
		}
		
	}

	private void randomMove() {
		int index = new Random().nextInt(9)+1;
		if(board[index] == ' ')
			board[index]=  computerLetter;
		else
			randomMove();
		
	}
	
	public static void newGame()
    {
    	System.out.println("Do you want to play again??\npress 0 to play again\npress 1 to exit");
    	Scanner scanner = new Scanner(System.in);
    	int choice = scanner.nextInt();
    	if(choice == 0)
    	{
    		TicTacToeGame newTicTacToeGame = new TicTacToeGame();
    		newTicTacToeGame.createBoard();
    		newTicTacToeGame.selectLetter();
    		newTicTacToeGame.toss();
    		
    	}
    	else {
    		System.exit(0);
    	}
    	
    }


}
