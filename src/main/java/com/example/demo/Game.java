package com.example.demo;

public class Game {

    private char[][] board = new char[3][3];
    private Player currentPlayer;
    private String status = "In_Progress";


    private final Player playerX = new Player('X');
    private final Player playerO = new Player('O');

    public Game() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = '-';

        currentPlayer = playerX;
    }

    public char[][] getBoard() {
        return board;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public String getStatus() {
        return status;
    }

    public String makeMove(int row, int col) {
        if (!status.equals("IN_PROGRESS"))
            return "Game over";

        if (row < 0 || row >= 3 || col < 0 || col >= 3)
            return "Invalid move";

        if (board[row][col] != '-')
            return "Cell already taken";

        board[row][col] = currentPlayer.getSymbol();

        if (checkWin(currentPlayer)) {
            status = currentPlayer.getSymbol() + " WINS";
        } else if (isDraw()) {
            status = "DRAW";
        } else {
            //
            currentPlayer = currentPlayer.equals(playerX) ? playerO : playerX;
        }

        return "OK";
    }

    private boolean checkWin(Player player) {
        char symbol = player.getSymbol();

        //row
        for (int i = 0; i < 3; i++)
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol)
                return true;
        //col
        for (int j = 0; j < 3; j++)
            if (board[0][j] == symbol && board[1][j] == symbol && board[2][j] == symbol)
                return true;
        // diameter
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol)
            return true;

        // diameter
        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)
            return true;

        return false;
    }

    private boolean isDraw() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == '-')
                    return false;
        return true;
    }
}
