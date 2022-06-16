package ru.levelp.at.lesson0507.lazy.init;

public class PersonLazyInitApp {

    public static void main(String[] args) {
        Person steven = new Person();
        System.out.println(steven);
        System.out.println();

        var stevenAges = steven.getAge();
        System.out.println(stevenAges);
        System.out.println(steven);
        System.out.println();

        stevenAges = steven.getAge();
        System.out.println(stevenAges);
        System.out.println(steven);
        System.out.println();

        stevenAges = steven.getAge();
        System.out.println(stevenAges);
        System.out.println(steven);
        System.out.println();
    }
}
