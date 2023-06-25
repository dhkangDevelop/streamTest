import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamTest {
    static public void read() throws IOException {
        byte[] bytes = {1,2,3,4,5,11};
        InputStream is = new ByteArrayInputStream(bytes);
        int data;
        while((data = is.read()) != -1) {
            System.out.println(data);
        }
    }

    static public void readBuffer() throws IOException {
        byte[] bytes = {1,2,3,4,5};
        InputStream is = new ByteArrayInputStream(bytes);
        int len = 3;
        int readCnt = 0;
        byte[] buffer = new byte[len];
        while((readCnt = is.read(buffer))!=-1) {
            for(int i=0;i<readCnt;i++){
                System.out.print(buffer[i] + " ");
            }
            System.out.println();
        }
    }

    static public void readBufferOffset() throws IOException {
        byte[] bytes = {1,2,3,4,5,6,7,8,9,10,11};
        InputStream is = new ByteArrayInputStream(bytes);
        int len = 3;
        int readCnt = 0;
        int offset = 0;
        byte[] buffer = new byte[1024];
        while((readCnt = is.read(buffer, offset, len))!=-1) {
            offset += readCnt;
            for(int i=0;i<12;i++){
                System.out.print(buffer[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        try {
            read();
            readBuffer();
            readBufferOffset();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
