package ru.gb.lessonthree;

import java.util.Arrays;

/**
 Java - уровень 1
 GeekBrains
 HomeWork 3

 @author RudolfBagmet
 @version 18.12.2021

 **/

public class HomeWorkApp3 {
    public static void main(String[] args) {
        int[] arrOneZero = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("Исходный массив: " + Arrays.toString(arrOneZero));
        System.out.println("Результирующий массив: " + Arrays.toString(replaceOneToZero(arrOneZero)));

        int[] oneHundredLengthArr = new int[100];
        System.out.println("Исходный массив: " + Arrays.toString(oneHundredLengthArr));
        System.out.println("Результирующий массив: " + Arrays.toString(fillArrayFromOne(oneHundredLengthArr)));

        int[] thirdArr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Исходный массив: " + Arrays.toString(thirdArr));
        System.out.println("Результирующий массив: " + Arrays.toString(lessThanSixMultiply(thirdArr)));

        int[][] zeroArr1 = new int[7][7];
        System.out.println("Исходный массив: ");
        print2DArr(zeroArr1);
        System.out.println("Результирующий массив: ");
        print2DArr(fillOneDiagonal(zeroArr1));
        int[][] zeroArr2 = new int[10][10];
        System.out.println("Исходный массив: ");
        print2DArr(zeroArr2);
        System.out.println("Результирующий массив: ");
        print2DArr(fillOneDiagonal(zeroArr2));

        System.out.println(Arrays.toString(generateArray(10, 5)));
        System.out.println(Arrays.toString(generateArray(2, 0)));

        int[] someArr = new int[5];
        someArr[0] = 15;
        someArr[1] = 3;
        someArr[2] = 25;
        someArr[3] = 12;
        someArr[4] = 4;
        System.out.println(Arrays.toString(someArr));
        System.out.println("Максимальное число в массиве = " + searchMaxInArray(someArr));
        System.out.println("Минимальное число в массиве = " + searchMinInArray(someArr));

        int[] arrBalance1 = {1, 1, 1, 2, 1};
        System.out.println("Исходный массив: " + Arrays.toString(arrBalance1));
        System.out.println(checkEqualRightLeft(arrBalance1));
        int[] arrBalance2 = {21, 1, 1, 2, 1};
        System.out.println("Исходный массив: " + Arrays.toString(arrBalance2));
        System.out.println(checkEqualRightLeft(arrBalance2));

        int[] forShift1 = {1, 2, 3, 4, 5, 6};
        int n = 4;
        System.out.println("Исходный массив: " + Arrays.toString(forShift1) + ", сдвиг = " + n);
        System.out.println("Результирующий массив: " + Arrays.toString(shiftArray(forShift1, n)));

        int[] forShift2 = {10, 20, 25, 30};
        int m = -3;
        System.out.println("Исходный массив: " + Arrays.toString(forShift2) + ", сдвиг = " + m);
        System.out.println("Результирующий массив: " + Arrays.toString(shiftArray(forShift2, m)));
    }

    //Задание 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0
    static int[] replaceOneToZero(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {arr[i] = 1;}
            else arr[i] = 0;
        }
        return arr;
    }

    //Задание 2. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;
    static int[] fillArrayFromOne(int[] arr) {
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i-1] + 1;
        }
        return arr;
    }

    //Задание 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], пройти по нему циклом, и числа меньшие 6 умножить на 2.
    static int[] lessThanSixMultiply(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        return arr;
    }


    //Задание 4. Создать квадратный целочисленный массив (количество строк и столбцов одинаковое) и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно). Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n]
    static int[][] fillOneDiagonal(int[][] arr) {
        for (int i = 0, j = (arr.length - 1); i < arr.length; i++, j--) {
            arr[i][j] = 1;
            arr[i][i] = 1;
        }
        return arr;
    }

    //Задание 5. Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue
    static int[] generateArray(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }

    //Задание 6. Задать одномерный массив и найти в нем минимальный и максимальный элементы
    static int searchMinInArray(int[] arr) {
        int min = arr[0];
        for (int element : arr) {
            if (element < min) {
                min = element;
            }
        }
        return min;
    }

    static int searchMaxInArray(int[] arr) {
        int max = arr[0];
        for (int element : arr) {
            if (element > max) {
                max = element;
            }
        }
        return max;
    }

    //Задание 7. Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны
    static boolean checkEqualRightLeft(int[] arr) {
        int sumAll = 0;
        for (int element : arr) {
            sumAll += element;
        }
        int sumLeft = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            sumLeft += arr[i];
            sumAll -= arr[i];
            if (sumLeft == sumAll) {
                return true;
            }
        }
        return false;
    }

    //Задание 8.  Написать метод, которому на вход подаётся одномерный массив и число n (может быть положительным, или отрицательным), при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами. Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами.
    static int[] shiftArray(int[] arr, int n) {
        if (n < 0) {
            n = (arr.length - Math.abs(n));
        }
        if (Math.abs(n) > arr.length) {
            n = n - arr.length;
        }
        int[] shiftedArr = new int[arr.length];
        System.arraycopy(arr, 0, shiftedArr, n, (arr.length - n));
        System.arraycopy(arr, (arr.length - n), shiftedArr, 0, n);
        return shiftedArr;
    }

    //вспомогательный метод для вывода двумерного массива
    static void print2DArr(int[][] arr) {
        for (int[] ints : arr) {
            for (int oneInt : ints) {
                System.out.print(oneInt + " ");
            }
            System.out.println();
        }
    }

}
