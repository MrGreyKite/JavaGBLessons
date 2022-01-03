package ru.gb.lessonseven;

import java.util.ArrayList;

/**
 Java - уровень 1
 GeekBrains
 HomeWork 7

 @author RudolfBagmet

 @version 31.12.2021

 **/

public class HomeWorkApp7 {
    public static void main(String[] args) {
        Plate plate = new Plate(70);

        ArrayList<Cat> catList = new ArrayList<>();
        catList.add(new Cat("Барсик", 5));
        catList.add(new Cat("Фрося", 15));
        catList.add(new Cat("Маркиз", 20));
        catList.add(new Cat("Ужас", 10));
        catList.add(new Cat("Лиса", 25));

        int numberOfFeedingAttempts = 0;
        while(numberOfFeedingAttempts != (catList.size() * 2)) {
            for (Cat cat : catList) {
                plate.plateInfo();
                cat.eat(plate);
                plate.plateInfo();
                cat.catInfo();
                plate.addFood(50);
                numberOfFeedingAttempts++;
            }
        }
    }


}
