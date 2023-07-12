package com.bridgelabz;

import java.util.Scanner;

public class TicTacToe {
    private char[][] board;
    private char currentPlayer;
    private boolean gameOver;

    public TicTacToe() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        currentPlayer = 'X';
        gameOver = false;
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        Scanner scanner = new Scanner(System.in);

        while (!game.isGameOver()) {
            game.displayBoard();
            System.out.println("Player " + game.getCurrentPlayer() + ", it's your turn. Choose a row and column to place your symbol (e.g., 1 2):");

            int row, col;
            try {
                row = scanner.nextInt();
                col = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter two integers separated by a space.");
                scanner.nextLine();
                continue;
            }

            if (row < 1 || row > 3 || col < 1 || col > 3) {
                System.out.println("Invalid input. Please enter row and column numbers between 1 and 3.");
                continue;
            }

            if (!game.makeMove(row, col)) {
                continue;
            }
        }

        // Display the final state of the board
        game.displayBoard();
    }

    public void displayBoard() {
        System.out.println("   1   2   3");
        System.out.println("1  " + board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
        System.out.println("  ---+---+---");
        System.out.println("2  " + board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
        System.out.println("  ---+---+---");
        System.out.println("3  " + board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
    }

    public boolean makeMove(int row, int col) {
        // Check if the cell is empty
        if (board[row - 1][col - 1] != ' ') {
            System.out.println("That cell is already taken. Please choose another cell.");
            return false;
        }

        board[row - 1][col - 1] = currentPlayer;

        // Check for a win
        if (checkWin()) {
            System.out.println("Congratulations! Player " + currentPlayer + " wins!");
            gameOver = true;
        } else if (checkTie()) {
            System.out.println("It's a tie!");
            gameOver = true;
        } else {
            // Switch to the other player's turn
            currentPlayer = currentPlayer == 'X' ? 'O' : 'X';
        }

        return true;
    }

    private boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] != ' ') {
                return true;
            }
        }

        for (int j = 0; j < 3; j++) {
            if (board[0][j] == board[1][j] && board[0][j] == board[2][j] && board[0][j] != ' ') {
                return true;
            }
        }

        if ((board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] != ' ') ||
                (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] != ' ')) {
            return true;
        }

        return false;
    }

    private boolean checkTie() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false; // there is at least one empty cell, so the game is not a tie
                }
            }
        }
        return true; // all cells are full, so the game is a tie
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }
}

