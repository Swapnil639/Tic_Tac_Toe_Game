package com.bridgelabz;

import java.util.Random;

public class TicTacToe {
    private char[][] board;
    private String player1Symbol;
    private String player2Symbol;
    static TicTacToe game = new TicTacToe();

    public static void main(String[] args) {
        game.chooseLetter();
        game.coinToss();
        game.displayBoard();
    }

    public TicTacToe() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void chooseLetter() {
        if (Math.random() < 0.5) {
            player1Symbol = "X";
            player2Symbol = "O";
        } else {
            player1Symbol = "O";
            player2Symbol = "X";
        }

        System.out.println("Player 1's symbol: " + player1Symbol);
        System.out.println("Player 2's symbol: " + player2Symbol);
    }
    public void coinToss(){
        Random rand = new Random();
        int tossResult = rand.nextInt(2);
        if (tossResult == 0) {
            System.out.println("Heads! Player 1 goes first.");
        } else {
            System.out.println("Tails! Player 2 goes first.");
        }
    }
    public void displayBoard() {
        System.out.println("   1   2   3");
        System.out.println("1  " + board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
        System.out.println("  ---+---+---");
        System.out.println("2  " + board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
        System.out.println("  ---+---+---");
        System.out.println("3  " + board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
    }
}

