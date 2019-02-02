import java.io.*;

class Main
{
    public static void main(String[] args) {

        try {
            Singleton instance1 = Singleton.getInstance();
            ObjectOutput out;

            out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
            out.writeObject(instance1);
            out.close();

            //deserialize from file to object
            ObjectInput in = new ObjectInputStream(new FileInputStream("filename.ser"));
            Singleton instance2 = (Singleton) in.readObject();
            in.close();

            System.out.println("Instance 1 hashCode=" + instance1.hashCode());
            System.out.println("Instance 2 hashCode=" + instance2.hashCode());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
