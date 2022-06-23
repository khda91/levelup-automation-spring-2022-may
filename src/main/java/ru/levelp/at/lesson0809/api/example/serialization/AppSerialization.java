package ru.levelp.at.lesson0809.api.example.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import ru.levelp.at.lesson0809.api.example.Cat;

public class AppSerialization {

    public static void main(String[] args) {
        var cat = new Cat("vaska", 3, "british");

        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("ser/cat.txt"));
            objectOutputStream.writeObject(cat);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
