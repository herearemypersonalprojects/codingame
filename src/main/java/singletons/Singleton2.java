package singletons;

/**
 * Created by qale0001 on 01/02/2017.
 */
public class Singleton2 {
    private static Singleton2 INSTANCE;

    private Singleton2() {
        int i = 1/0;
    }

    public static synchronized Singleton2 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton2();
        }
        return INSTANCE;
    }
}
