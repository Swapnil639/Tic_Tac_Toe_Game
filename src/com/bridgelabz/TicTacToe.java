package com.bridgelabz;

public class TicTacToe {
    private char[][] board;
    private String player1Symbol;
    private String player2Symbol;
    static TicTacToe game = new TicTacToe();

    public static void main(String[] args) {
        game.gameBoard();
        game.chooseLetter();
    }

    public void gameBoard() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
                System.out.print(board[i][j]);
            }
            System.out.println();
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
}

