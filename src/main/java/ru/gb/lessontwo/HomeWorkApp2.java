package ru.gb.lessontwo;

public class HomeWorkApp2 {

    public static void main(String[] args) {

        System.out.println(compareTwoNumbers(1, 20));
        System.out.println(compareTwoNumbers(19, 1));

        checkPositiveOrNegative(1);
        checkPositiveOrNegative(-1);
        checkPositiveOrNegative(0);

        System.out.println(checkIfNegative(5));
        System.out.println(checkIfNegative(-5));
        System.out.println(checkIfNegative(0));

        printForSomeTimes("Есть кто-нибудь?", 5);
        printForSomeTimes("Привет!", 1);

        calculateIfLeapYear(1600);
        calculateIfLeapYear(1500);
        calculateIfLeapYear(1901);
        calculateIfLeapYear(2004);
    }


//Задание 1. Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.
    static boolean compareTwoNumbers (int a, int b) {
        return ((a + b) >= 10 && (a + b) <= 20);
    }

//Задание 2. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль, положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом
    static void checkPositiveOrNegative (int a) {
       String check = (a >= 0) ? "Число передано положительное" : "Число передано отрицательное";
       System.out.println(check);

    }

//Задание 3. Написать метод, которому в качестве параметра передается целое число. Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
    static boolean checkIfNegative (int a) {
        return (a < 0);
    }

//Задание 4. Написать метод, которому в качестве аргументов передается строка и число, метод должен отпечатать в консоль указанную строку, указанное количество раз.
    static void printForSomeTimes (String str, int iterations) {
        for(int i = 0; i < iterations; i++){
            System.out.println(str);
        }
    }

//Задание 5. Написать метод, который определяет, является ли год високосным, и возвращает boolean (високосный - true, не високосный - false). Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    static void calculateIfLeapYear (int year) {
        if (year % 400 == 0) {
            System.out.println(year + ": этот год високосный");
        }
        else if (year % 4 == 0 && year % 100 != 0) {
            System.out.println(year + ": этот год високосный");
        } else {
            System.out.println(year + ": этот год не високосный");
        }

    }
}
