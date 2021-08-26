package com.yml.tictactoe;

import java.util.Scanner;

/**
 * @author faraz shaikh This is the program that simulates tic tac toe game
 *  The game will be played between the user and the computer
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
	}
	/**
	 * This method creates the board by initialising all the boxes to empty space
	 */
	public void createBoard()
	{
		for ( char c: board) {
			c = ' ';
		}
	}
	/**
	 * This method prompts the user to select a letter to play the game
	 */
	public void selectLetter() {

		while(true) {
		System.out.println("Choose your letter.I.e X or O");
		Scanner r = new Scanner(System.in);
		player1 = r.nextLine().charAt(0);
		if (Character.compare(player1,'O') == 0) {
			
			player2 = 'O';
			return;
		} 
		else if (Character.compare(player1, 'X') == 0) {
			player2 = 'X';
			return;
		} 
		else {
			System.out.println("Invalid input");
			
		}
		}
		
	}
	public void displayChoice() {
		System.out.println("Player 1 chose " + player1);
		System.out.println("Player 2's Letter will be " + player2);
	}
	
}
