package singleton;

public class StaticBlockSingleton {
    /*
    If you have an idea of the class loading sequence, you can use the fact that static blocks
     are executed during the loading of a class, even before the constructor is called.
     We can use this feature in our singleton pattern like this:
     */

    private static final StaticBlockSingleton INSTANCE;

    static {
        try {
            INSTANCE = new StaticBlockSingleton();
        } catch (Exception ex) {
            throw new RuntimeException("Uffff, i was not expecting this!", ex);
        }
    }

    public StaticBlockSingleton getInstance() {
        return INSTANCE;
    }

    private StaticBlockSingleton(){}
    /*
    The above code has one drawback. Suppose there are 5 static fields in a class and
     the application code needs to access only 2 or 3, for which instance creation is
     not required at all. So, if we use this static initialization, we will have
     one instance created though it is required or not.
     */
}
