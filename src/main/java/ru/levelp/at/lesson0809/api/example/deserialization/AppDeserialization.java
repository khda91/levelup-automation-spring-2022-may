package ru.levelp.at.lesson0809.api.example.deserialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import ru.levelp.at.lesson0809.api.example.Cat;

public class AppDeserialization {

    public static void main(String[] args) {
        Cat cat = null;
        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new FileInputStream("ser/cat.txt"));
            cat = (Cat) ois.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        System.out.println(cat);
    }
}
