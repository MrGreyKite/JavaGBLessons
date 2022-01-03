package ru.gb.lessonseven;

public class Cat {
    private final String name;
    private final int appetite;
    boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    //Реализована немного иная логика, чем в тексте ДЗ: если коту не удалось съесть столько, сколько его аппетит, то он остался голодным, даже если съел какое-то количество пищи. Пища уменьшается до 0, сытость кота не меняется, в следующее прохождение кот опять будет есть.
    public void eat(Plate p) {
        if (!satiety && (p.getFood() >= appetite)) {
            p.decreaseFood(appetite);
            satiety = true;
        } else if (!satiety && (p.getFood() < appetite)) {
            p.decreaseFood(appetite);
            satiety = false;
        }
    }

    public int getAppetite() {
        return appetite;
    }

    public String getName() {
        return name;
    }

    public void catInfo() {
        if (satiety) {
            System.out.println("Кот " + name + " сыт");
        }
        else System.out.println("Кот " + name + " голоден");
    }
}
