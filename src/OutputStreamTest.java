import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamTest {
    static public void write01() throws IOException {
        byte[] bytes = {9,8,7,6,5,4,3,2,1,0};
        File file = new File("./file.txt");
        OutputStream outputStream = new FileOutputStream(file);
        for(byte b : bytes) {
            outputStream.write(b);
        }
        // 바이트를 한 번에 넣을 수 있다.
        // outputStream.write(bytes);

        outputStream.close();
    }
    public static void main(String[] args) throws IOException {
        write01();
    }
}
