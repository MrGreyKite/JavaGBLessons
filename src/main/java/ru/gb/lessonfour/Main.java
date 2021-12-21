package ru.gb.lessonfour;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        HomeWorkGame ticTacToe = new HomeWorkGame();

        ticTacToe.initializeField();
        ticTacToe.printField();

        while (true) {
            ticTacToe.humanTurn();
            ticTacToe.printField();
            if (ticTacToe.checkWinSimple(ticTacToe.HUMAN_DOT)) {
                System.out.println("Выиграл человек!");
                break;
            }
            if (ticTacToe.isDraw()) {
                System.out.println("Ничья!");
                break;
            }
            ticTacToe.AITurn(ticTacToe.coordinates);
            ticTacToe.printField();
            if (ticTacToe.checkWinSimple(ticTacToe.AI_DOT)) {
                System.out.println("Выиграл компьютер!");
                break;
            }
            if (ticTacToe.isDraw()) {
                System.out.println("Ничья!");
                break;
            }
        }
    }
}
