package ru.gb.lessonfive;

/**
 Java - уровень 1
 GeekBrains
 HomeWork 5

 @author RudolfBagmet

 @version 25.12.2021

 **/

public class Employee {

    private final String name;
    private int age;
    private String email;
    private String phoneNumber;
    private String position;
    private int salary;

    public Employee(String name, int age, String email, String phoneNumber, String position, int salary) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.position = position;
        this.salary = salary;
    }

    void setSalary(int salary) {
        this.salary = salary;
    }

    void setPosition(String position) {
        this.position = position;
    }

    int getAge() {
        return age;
    }

    // переопределение метода toString() для вывода информации
    @Override
    public String toString() {
        return "Информация о работнике: [Имя сотрудника: " + name
                + ", возраст: " + age
                + ", должность: " + position
                + ", заработная плата: " + salary + " рублей"
                + ", номер телефона: " + phoneNumber
                + ", электронная почта: " + email + "]";
    }

}
