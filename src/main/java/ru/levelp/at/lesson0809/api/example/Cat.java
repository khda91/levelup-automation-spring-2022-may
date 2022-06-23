package ru.levelp.at.lesson0809.api.example;

import java.io.Serializable;

public class Cat implements Serializable {

    private String name;
    private int age;
    private String breed;

    public Cat() {
    }

    public Cat(String name, int age, String breed) {
        this.name = name;
        this.age = age;
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public String toString() {
        return "Cat{"
            + "name='" + name + '\''
            + ", age=" + age
            + ", breed='" + breed + '\''
            + '}';
    }
}
