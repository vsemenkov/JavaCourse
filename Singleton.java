package homeWork2;

public class Singleton {

    public static final Singleton INSTANCE = new Singleton();

    //private static Singleton instance;
    private Singleton() {

    }

    //  public static Singleton getInstance() {
    //     if (instance == null) {
    //        instance = new Singleton();
    //}
    //   return instance;
    // }
}
