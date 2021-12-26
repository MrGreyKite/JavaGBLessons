package ru.gb.lessonfive;

import java.util.ArrayList;

/**
 Java - уровень 1
 GeekBrains
 HomeWork 5

 @author RudolfBagmet

 @version 25.12.2021

 **/

public class HomeWorkApp5 {
    public static void main(String[] args) {

        ArrayList<Employee> EmployeeList = new ArrayList<>();
        EmployeeList.add(new Employee("Иван Иванов", 35, "1@gmail.com", "8999999999", "Java-разработчик", 70000));
        EmployeeList.add(new Employee("Петр Петров", 41, "2@gmail.com", "8999999998", "Java-разработчик", 90000));
        EmployeeList.add(new Employee("Мария Маринина", 27, "3@gmail.com", "8999999997", "QA", 50000));
        EmployeeList.add(new Employee("Михаил Михайлов", 32, "4@gmail.com", "8999999995", "Аналитик", 65000));
        EmployeeList.add(new Employee("Екатерина Катина", 49, "5@gmail.com", "8999999991", "HR", 55000));

        for(Employee element : EmployeeList) {
            if (element.getAge() > 40) {
                System.out.println(element);
            }
        }

    }
}
