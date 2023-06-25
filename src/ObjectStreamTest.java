import java.io.*;

public class ObjectStreamTest {
    static public void outputTest() throws IOException {
        ObjectOutputStream oos = null;
        oos = new ObjectOutputStream(new FileOutputStream("./obj.txt"));
        Member member = new Member("dhkang", "dhkang@test.com", 30);
        oos.writeObject(member);
    }
    static public void inputTest() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = null;
        ois = new ObjectInputStream(new FileInputStream("./obj.txt"));
        Member member = (Member) ois.readObject();
        System.out.println(member.getName());
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException{
        outputTest();
        inputTest();
    }
}
