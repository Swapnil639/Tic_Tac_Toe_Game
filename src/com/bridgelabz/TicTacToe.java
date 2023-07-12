package com.bridgelabz;

public class TicTacToe {
    private char[][] board;

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.gameBoard();
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

}
