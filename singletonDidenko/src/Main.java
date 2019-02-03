import java.io.*;
import java.util.ArrayList;

class Main
{
    public static void main(String[] args) {

        ArrayList<Singleton> singletons = new ArrayList<>();
        Singleton instance1 = Singleton.getInstance();

        for(int i = 0; i<10; i++){
            try {
                ObjectOutput out;

                out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
                out.writeObject(instance1);
                out.close();

                //deserialize from file to object
                ObjectInput in = new ObjectInputStream(new FileInputStream("filename.ser"));
                Singleton instance2 = (Singleton) in.readObject();
                in.close();

                singletons.add(instance2);

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        for(Singleton s : singletons){
            System.out.println(s.sayHi());
        }

    }
}
