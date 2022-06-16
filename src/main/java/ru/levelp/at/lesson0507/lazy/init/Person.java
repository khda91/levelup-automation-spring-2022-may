package ru.levelp.at.lesson0507.lazy.init;

import java.security.SecureRandom;
import java.util.Random;

public class Person {

    private String name = "Steven";
    private Integer age;

    public String getName() {
        return name;
    }

    public Integer getAge() {
        if (age == null) {
            age = new SecureRandom().nextInt();
        }
        return age;
    }

    @Override
    public String toString() {
        return "Person{"
            + "name='" + name + '\''
            + ", age=" + age
            + '}';
    }
}
