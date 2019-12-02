<h2>Theory: Singleton</h2>
Sometimes we need to have only a single instance of a class shared across an entire application.
There is a special design pattern called Singleton that restricts the instantiation of a class to one object.
The pattern ensures that there is only one instance of the class and provides global access to it for the outer world.
<br/><br/>
**The same instance is used by different clients (classes, methods)**
<br/>
Singletons often control access to resources such as database connections or sockets.
<br/>


<h3>Basic singleton in Java</h3>
<p>
The standard way to write a class according to the singleton pattern includes: <br/>
<br/>

- a private constructor to defeat the creation of instances using the keyword `new`;
- a private static variable of the class that is the only instance of the class;
- a public static method to return the same instance of the class; this is a global access point to the instance.
<br/><br/>
The following code implements these concepts:
```
class Singleton {
 
    private static Singleton instance = new Singleton();
 
    private Singleton() { }
 
    public static Singleton getInstance() {
        return instance;
    }
}

```
Usually, singletons have additional instance fields to store values (global variables)
to share them across your application as well as methods to have a behavior.


<h3>Lazy initialization</h3>
The singleton above loads the instance when the class is loaded. But sometimes
the initialization of a singleton can take much time: for example,
 to load the values of the fields from a file or a database.<br/><br/>
 The following implementation loads the instance only if it is needed to a client
 (who calls `getInstance`):
 ```
class Singleton {
    
    private static Singleton instance;
    
    private Singleton () { }
 
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```
<br/><br/>
Even though the implementation of a singleton pattern contains few lines of code, it has an important feature:lazy initialization.
  It means that the singleton instance is not created until the getInstance method is called for the first time. 
  This technique ensures that singleton instances are created only when needed.
  
some people consider the singleton an anti-pattern 
because It introduces a global state into the application.

Note that you should use the provided singleton class only in one-thread environments
 because it is prone to multithreading issues. In other topics, we will consider techniques
 to write thread-safe singletons.


</p>