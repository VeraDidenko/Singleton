import java.io.Serializable;

class Singleton implements Serializable {

    private static Singleton singletonInstance;

    //private constructor.
    private Singleton() {

        //Prevent form the reflection api.
        if (singletonInstance != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public String sayHi(){
        return "Hi! I am a Singleton object and my hashcode is " + this.hashCode() + "!";
    }

    static Singleton getInstance() {

        //if there is no instance available... create new one
        if (singletonInstance == null) {
            singletonInstance = new Singleton();
        }

        return singletonInstance;
    }
}
