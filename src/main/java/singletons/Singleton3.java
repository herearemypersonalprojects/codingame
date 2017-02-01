package singletons;

/**
 * Created by qale0001 on 01/02/2017.
 */
public class Singleton3 {
    private static Singleton3 INSTANCE;

    private Singleton3() {
        int i = 1/0;
    }

    static public Singleton3 getInstance() {
        if (INSTANCE == null) {
            synchronized(Singleton3.class) {
                INSTANCE = new Singleton3();
            }
        }
        return INSTANCE;
    }
}
