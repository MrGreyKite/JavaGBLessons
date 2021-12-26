package ru.gb.lessonsix;

public class Animal {
    protected String name;
    protected int runAbility;
    protected int swimAbility;

    private static int animalCount;

    protected static int getAnimalCount() {
        return animalCount;
    }

    public Animal(String name) {
        this.name = name;
        animalCount = animalCount + 1;
    }


    protected int getRunAbility() {
        return runAbility;
    }

    protected int getSwimAbility() {
        return swimAbility;
    }

    protected String getName() {
        return name;
    }

    protected void setNewName(String name) {
        this.name = name;
    }

    protected void run(int lengthToRun) {
        if(lengthToRun > runAbility) {
            System.out.println(name + " не может пробежать больше " + runAbility + " м.");
        }
        else
            System.out.println(name + " пробежал " + lengthToRun + " м.");
    }

    protected void swim(int lengthToSwim) {
        if(lengthToSwim > swimAbility) {
            System.out.println(name + " не может проплыть больше " + swimAbility + " м.");
        }
        else
            System.out.println(name + " проплыл " + lengthToSwim + " м.");
    }
}
