package singletons;

/**
 * Created by qale0001 on 01/02/2017.
 */
public class Singleton1 {
    final private static Singleton1 INSTANCE = new Singleton1();

    private Singleton1() {
        int i = 1/0;
    }

    public static Singleton1 getInstance() {
        return INSTANCE;
    }
}
