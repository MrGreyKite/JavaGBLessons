package ru.gb.lessonseven;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void decreaseFood(int n) {
        if ((food - n) < 0) {
            food = 0;
        }
        else
            food -= n;
    }

    public void addFood(int portion){
        if (food == 0) {
            food += portion;
            System.out.println("Еда кончилась: добавлена новая порция корма - " + portion);
        } else
            System.out.println("Еда еще есть, корм не добавлен");
    }

    public void plateInfo() {
        System.out.println("На тарелке: " + food);
    }
}
