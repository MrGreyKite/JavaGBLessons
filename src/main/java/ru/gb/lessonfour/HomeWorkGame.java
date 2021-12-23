package ru.gb.lessonfour;

import java.util.Random;
import java.util.Scanner;

/**
 Java - уровень 1
 GeekBrains
 HomeWork 4


 @author RudolfBagmet

 @version 23.12.2021

 **/

public class HomeWorkGame {

    static final Scanner SCAN = new Scanner(System.in);
    static final Random RAND = new Random();

    final int DOT_TO_WIN = 3;
    final char HUMAN_DOT = 'X';
    final char AI_DOT = '0';
    final char EMPTY_DOT = '_';

    char[][] gameField;
    int fieldSizeY = 4;
    int fieldSizeX = 4;

    int[] coordinates = new int[2];


    void initializeField() {
        gameField = new char[fieldSizeY][fieldSizeX];
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                gameField[i][j] = EMPTY_DOT;
            }
        }
    }

    void printField() {
        for (int i = 0; i < fieldSizeY; i++) {
            System.out.print("|");
            for (int j = 0; j < fieldSizeX; j++) {
                System.out.print(gameField[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println("---------");
    }

    boolean isCellValid(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY && (gameField[y][x] == EMPTY_DOT);
    }

    int[] humanTurn() {
        int x, y;
        do {
            System.out.printf("Введите координаты X и Y (от 1 до %d)", fieldSizeX);
                    x = SCAN.nextInt() - 1;
            y = SCAN.nextInt() - 1;
        }
        while (!(isCellValid(x, y)));
        gameField[y][x] = HUMAN_DOT;
        System.out.println("Вы сделали ход в точку " + (x + 1) + ", " + (y + 1));
        return coordinates = new int[]{x, y};
    }

    void AITurnSimple() {
        int x, y;
        do {
            x = RAND.nextInt(fieldSizeX);
            y = RAND.nextInt(fieldSizeY);
        } while (!isCellValid(x, y));
        gameField[y][x] = AI_DOT;
        System.out.println("Компьютер сделал ход в точку " + (x + 1) + ", " + (y + 1));
    }

    //ИскИн делает ход с попыткой перехвата; проверяется сначала возможность сделать выигрышный ход, потом перехват, потом ближайшие клетки
    void AITurn(int[] coordinates) {
        int x, y;
        while (true) {
            x = RAND.nextInt(fieldSizeX);
            y = RAND.nextInt(fieldSizeY);

            if (isCellValid(x, y)) {

                gameField[y][x] = AI_DOT;
                if (checkWinSimple(AI_DOT)) {
                    gameField[y][x] = AI_DOT;
                    System.out.println("Компьютер сделал ход в точку " + (x + 1) + ", " + (y + 1));
                    break;
                }

                gameField[y][x] = HUMAN_DOT;
                if (checkWinSimple(HUMAN_DOT)) {
                    gameField[y][x] = AI_DOT;
                    System.out.println("Компьютер сделал ход в точку " + (x + 1) + ", " + (y + 1));
                    break;
                }

                if (
                        x == (coordinates[0] - 1) + RAND.nextInt((coordinates[0] + 1) - (coordinates[0] - 1) + 1)
                                &&
                                y == (coordinates[1] - 1) + RAND.nextInt((coordinates[1] + 1) - (coordinates[1] - 1) + 1)
                ) {
                    gameField[y][x] = AI_DOT;
                    System.out.println("Компьютер сделал ход в точку " + (x + 1) + ", " + (y + 1));
                    break;
                }

                else
                    gameField[y][x] = EMPTY_DOT;

            }
        }
    }

    boolean isDraw() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (gameField[i][j] == EMPTY_DOT) return false;
            }
        }
        return true;
    }

    //Простая проверка выигрыша для поля, размер которого равен длине выигрышной последовательности

    boolean checkDiagonalsSimple(char dot) {
        boolean isDiagonalRight, isDiagonalLeft;
        isDiagonalRight = isDiagonalLeft = true;
        for (int i = 0; i < DOT_TO_WIN; i++) {
            isDiagonalRight &= (gameField[i][i] == dot);
            isDiagonalLeft &= (gameField[DOT_TO_WIN - 1 - i][i] == dot);
        }
        return (isDiagonalRight || isDiagonalLeft);
    }

    boolean checkLinesSimple(char dot) {
        boolean isColumn, isRow;
        for (int y = 0; y < DOT_TO_WIN; y++) {
            isColumn = isRow = true;
            for (int x = 0; x < DOT_TO_WIN; x++) {
                isColumn &= (gameField[y][x] == dot);
                isRow &= (gameField[x][y] == dot);
            }
            if (isColumn || isRow) return true;
        }
        return false;
    }

    boolean checkWinSimple(char dot) {
        return checkDiagonalsSimple(dot) || checkLinesSimple(dot);
    }

    //Проверка выигрыша для поля произвольного размера: каждый раз проверяется квадрат "клеток" размера выигрышной последовательности,
//и после проверки происходит смещение по полю, пока не будет достигнут край
    boolean checkDiagonals(char dot, int shiftLeft, int shiftDown) {
        boolean isDiagonalRight, isDiagonalLeft;
        isDiagonalRight = isDiagonalLeft = true;
        for (int i = 0; i < DOT_TO_WIN; i++) {
            isDiagonalRight &= (gameField[i + shiftLeft][i + shiftDown] == dot);
            isDiagonalLeft &= (gameField[DOT_TO_WIN - 1 - i + shiftLeft][i + shiftDown] == dot);
        }
        return (isDiagonalRight || isDiagonalLeft);
    }

    boolean checkLines(char dot, int shiftLeft, int shiftDown) {
        boolean isColumn, isRow;
        for (int vertical = shiftLeft; vertical < (DOT_TO_WIN + shiftLeft); vertical++) {
            isColumn = isRow = true;
            for (int horizontal = shiftDown; horizontal < (DOT_TO_WIN + shiftDown); horizontal++) {
                isColumn &= (gameField[vertical][horizontal] == dot);
                isRow &= (gameField[horizontal][vertical] == dot);
            }
            if (isColumn || isRow) return true;
        }
        return false;
    }

    boolean checkWin(char dot) {
        for (int vertical = 0; vertical < (fieldSizeY - DOT_TO_WIN + 1); vertical++) {
            for (int horizontal = 0; horizontal < (fieldSizeX - DOT_TO_WIN + 1); horizontal++) {
                if (checkDiagonals(dot, vertical, horizontal) || checkLines(dot, vertical, horizontal)) return true;
            }
        }
        return false;
    }
}
