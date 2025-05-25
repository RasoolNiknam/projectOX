package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


public class DemoApplication {

    public static void main(String[] args) {

        Game game = new Game();

        System.out.println(game.makeMove(0, 0));  // X
        System.out.println(game.makeMove(1, 1));  // O
        System.out.println(game.makeMove(0, 1));  // X
        System.out.println(game.makeMove(1, 0));  // O
        System.out.println(game.makeMove(0, 2));

        printBoard(game.getBoard());
    }

    private static void printBoard(char[][] board) {
        System.out.println("Board:");
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    }


