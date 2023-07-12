package com.bridgelabz;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public char[][] board;
    public char currentPlayer;
    public boolean gameOver;

    public TicTacToe() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        currentPlayer = 'X'; // Player X goes first
        gameOver = false;
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        Scanner scanner = new Scanner(System.in);

        while (!game.isGameOver()) {
            game.displayBoard();
            if (game.getCurrentPlayer() == 'X') {
                // Player's turn
                System.out.println("Player X, please enter your move (row column):");
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                game.makeMove(row, col);
            } else {
                // Computer's turn
                System.out.println("It's the computer's turn...");
                game.computerMove();
            }
        }
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
            currentPlayer = currentPlayer == 'X' ? 'O' : 'X';
        }

        return true;
    }

    public boolean checkWin() {
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

    public boolean checkTie() {
        // Check if there are any empty cells left on the board
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

    public void computerMove() {
        // Generate a random row and column until an empty cell is found
        Random random = new Random();
        int row = random.nextInt(3);
        int col = random.nextInt(3);
        while (board[row][col] != ' ') {
            row = random.nextInt(3);
            col = random.nextInt(3);
        }

        board[row][col] = currentPlayer;

        if (checkWin()) {
            System.out.println("Sorry, the computer wins!");
            gameOver = true;
        } else if (checkTie()) {
            System.out.println("It's a tie!");
            gameOver = true;
        } else {
            // Switch to the other player's turn
            currentPlayer = currentPlayer == 'X' ? 'O' : 'X';
        }
    }
}