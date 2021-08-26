package com.yml.tictactoe;

import java.util.Scanner;

/**
 * @author faraz shaikh This is the program that simulates tic tac toe game The
 *         game will be played between the user and the computer
 */
public class TicTacToeGame {

	private char[] board = new char[10];
	char player1, player2;

	public static void main(String[] args) {

		System.out.println("Welcome to game");
		TicTacToeGame ticTacToeGame = new TicTacToeGame();
		ticTacToeGame.createBoard();
		ticTacToeGame.selectLetter();
		ticTacToeGame.displayChoice();
//		ticTacToeGame.displayBoard();
		ticTacToeGame.userMove();
	}

	/**
	 * This method creates the board by initialising all the boxes to empty space
	 */
	public void createBoard() {
		for (char c : board) {
			c = ' ';
		}
	}

	/**
	 * This method prompts the user to select a letter to play the game
	 */
	public void selectLetter() {

		while (true) {
			System.out.println("Choose your letter.I.e X or O");
			Scanner r = new Scanner(System.in);
			player1 = r.nextLine().charAt(0);
			r.close();
			if (Character.compare(player1, 'O') == 0) {

				player2 = 'O';
				return;
			} else if (Character.compare(player1, 'X') == 0) {
				player2 = 'X';
				return;
			} else {
				System.out.println("Invalid input");

			}
		}

	}

	/**
	 * this method displays user's letter choice
	 */
	public void displayChoice() {
		System.out.println("Player 1 chose " + player1);
		System.out.println("Player 2's Letter will be " + player2);
	}

	/**
	 * this method displays the board where the game will be played
	 */
	public void displayBoard() {
		int count = 1;
		while (count != 10) {
			for (int i = 1; i <= 3; i++) {
				System.out.print(board[count]);
				if (i % 3 == 0) {
					count++;
					System.out.println();
					break;
				}
				count++;
				System.out.print("  |  ");
			}
			if (count == 10) {
				break;
			}
			System.out.println("------------");
		}
	}
	/**
	 * this method checks for available moves
	 */
	public void userMove() {
		
		int index;

		while(true)
		{
			System.out.println("Enter the index between 1 to 9 to which you wanna move");
			Scanner r = new Scanner(System.in);
			index = r.nextInt();
			if(index > 9 || index < 0) {
				System.out.println("Invalid index, Choose index between 1 to 9");
				continue;
			} 
			
			if( Character.toString(board[index]).equals(' ') ) {
				
				System.out.println("Index is free and you can make move");
			
			}
			else {
				System.out.println("Index is full and you cannot make move to that index");
			}
			r.close();
			return;
		}
		
		
	}

}
