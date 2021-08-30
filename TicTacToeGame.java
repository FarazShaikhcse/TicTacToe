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
		ticTacToeGame.displayBoard();
		ticTacToeGame.userMove();
		ticTacToeGame.displayBoard();
		ticTacToeGame.toss();
	}

	/**
	 * This method creates the board by initialising all the boxes to empty space
	 */
	public void createBoard() {
		for(int i=1;i<board.length;i++)     
		{
			board[i]=' ';
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
		
		int index;
		Scanner scanner = new Scanner(System.in);
		
			System.out.println("Enter the index between 1 to 9 to which you wanna move");
			
			index = scanner.nextInt();
			if(index > 9 || index < 0) {
				System.out.println("Invalid index, Choose index between 1 to 9");
				
			} 
			String c = String.valueOf(board[index]);  
			if( board[index]==' ') {
				
				System.out.println("Index is free and you have made the move");
				board[index] = playerLetter;
			
			}
			else {
				System.out.println("Index is full and you cannot make move to that index"+index);
			}
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
			System.out.println("Its player's turn!!!");
			usersTurn = true;
		}
		else
		{
			System.out.println("Its computer's turn!!!");
			usersTurn = false;
		}
		
	}


}
