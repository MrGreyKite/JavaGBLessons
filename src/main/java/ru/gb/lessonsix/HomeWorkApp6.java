package ru.gb.lessonsix;

/**
 Java - уровень 1
 GeekBrains
 HomeWork 6

 @author RudolfBagmet

 @version 26.12.2021

 **/

public class HomeWorkApp6 {

    public static void main(String[] args) {
        Animal firstCat = new Cat("Мякнус");
        Cat secondCat = new Cat("Вася");
        Animal firstDog = new Dog("Бобби");
        Dog secondDog = new Dog("Кусака");

        firstCat.swim(10);
        firstCat.run(201);
        secondCat.run(100);
        firstDog.swim(10);
        firstDog.run(500);
        secondDog.run(600);
        secondDog.swim(11);

        System.out.println("Всего животных: " + Animal.getAnimalCount());
    }
}
