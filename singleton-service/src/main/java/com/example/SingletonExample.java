package com.example;

import java.io.Serializable;

public class SingletonExample implements Serializable, Cloneable {

    private static volatile SingletonExample instance;

    private SingletonExample() {  // Private constructor to prevent instantiation from other classes
    }

    public static SingletonExample getInstance() {
        if(instance == null) {
            synchronized (SingletonExample.class) {
                if(instance == null) {
                    instance = new SingletonExample();
                }
            }
        }
        return instance;
    }

    //Override clone method to prevent cloning
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning of Singleton is not supported");
    }

    //Implement readResolve method for serialization
    protected Object readResolve() {
        return getInstance();
    }
}
