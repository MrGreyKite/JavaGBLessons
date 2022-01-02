package ru.gb.lessonsix;

public class Cat extends Animal {

    public Cat(String name) {
        super(name);
        this.runAbility = 200;
        this.swimAbility = 0;
    }

    @Override
    protected void swim(int lengthToSwim) {
        System.out.println(name + " не может проплыть " + lengthToSwim + " м. Котики не плавают.");
    }

    @Override
    protected int getSwimAbility() {
        System.out.println("Котики не плавают, они боятся воды!");
        return swimAbility;
    }

}
