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
    // Раскомментировать или закомментировать в зависимости от выбора способа проверки победы
    //            if (ticTacToe.checkWinSimple(ticTacToe.HUMAN_DOT)) {
    //или
            if (ticTacToe.checkWin(ticTacToe.HUMAN_DOT)) {
                System.out.println("Выиграл человек!");
                break;
            }
            if (ticTacToe.isDraw()) {
                System.out.println("Ничья!");
                break;
            }
    // Раскомментировать или закомментировать в зависимости от выбора поведения ИскИна
    //            ticTacToe.AITurn(ticTacToe.coordinates);
    //или
            ticTacToe.AITurnSimple();
            ticTacToe.printField();

    // Раскомментировать или закомментировать в зависимости от выбора способа проверки победы
    //            if (ticTacToe.checkWinSimple(ticTacToe.AI_DOT)) {
    //или
            if (ticTacToe.checkWin(ticTacToe.AI_DOT)) {
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
