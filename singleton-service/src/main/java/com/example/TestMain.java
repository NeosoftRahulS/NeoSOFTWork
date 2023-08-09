package com.example;

import java.io.*;

public class TestMain {

    public static void main(String[] args) {
        SingletonExample singleton = SingletonExample.getInstance();

        serializeSingleton(singleton);

        SingletonExample deserializedSingleton = deserializeSingleton();

        boolean areEqual = singleton == deserializedSingleton;

        System.out.println("Original Singleton: " + singleton);
        System.out.println("Deserialized Singleton: " + deserializedSingleton);
        System.out.println("Are they equal? " + areEqual);
    }

    private static void serializeSingleton(SingletonExample singleton) {
        try (FileOutputStream fileOut = new FileOutputStream("singleton.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(singleton);
            System.out.println("Singleton serialized");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static SingletonExample deserializeSingleton() {
        SingletonExample deserializedSingleton = null;
        try (FileInputStream fileIn = new FileInputStream("singleton.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            deserializedSingleton = (SingletonExample) in.readObject();
            System.out.println("Singleton deserialized");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return deserializedSingleton;
    }
}
