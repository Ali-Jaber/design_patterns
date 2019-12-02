package singleton;

public final class LazySingleton {
    /*
In computer programming, lazy initialization is the tactic of delaying the creation of an object,
 the calculation of a value, or some other expensive process, until the first time it is needed.
 In a singleton pattern, it restricts the creation of the instance until it is requested for first time.
 */

    private static volatile LazySingleton instance = null;

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if(instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

    /*
    But, this method also has its own drawbacks. Let’s see how. Suppose there are two threads T1 and T2.
     Both come to create the instance and check if “instance==null”. Now both threads have identified
     instance variable as null thus they both assume they must create an instance.
     They sequentially go into a synchronized block and create the instances.
     In the end, we have two instances in our application.

     This error can be solved using double-checked locking.
     This principle tells us to recheck the instance variable again in a synchronized block as given below:
     */

    public static LazySingleton getInstanceSync() {
        if(instance == null) {
            synchronized (LazySingleton.class) {
                if(instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
