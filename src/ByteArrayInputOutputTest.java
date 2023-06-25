import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ByteArrayInputOutputTest {
    public static void main(String[] args) {
        String filename = null;
        if(args.length != 1) {
            System.out.println("사용법 : java ByteArrayInputOutputTest filename");
            filename = "./obj.txt";
        } else {
            filename = args[0];
        }

        FileInputStream fis = null;
        ByteArrayInputStream bais = null;
        ByteArrayOutputStream baos = null;

        try {
            fis = new FileInputStream(filename);
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[512];
            int readCnt = 0;

            // 파일로부터 읽어들인 byte 배열을 ByteArrayOutputStream 에 쓴다.
            while((readCnt = fis.read(buffer))!= -1) {

                // 출력한 결과를 ByteArrayOutputStream 의 내부 저장 공간에 저장하는 부분
                baos.write(buffer, 0, readCnt);
            }

            // ByteArrayOutputStream 의 내부 저장공간에 저장된 바이트 배열을 반환
            byte[] fileArray = baos.toByteArray();
            System.out.println(fileArray.length);

            // byte[] 로부터 읽어들이는 ByteArrayInputStream 을 생성한다.
            bais = new ByteArrayInputStream(fileArray);

            // ByteArrayInputStream 을 통하여 읽어들인 byte 배열을 표준 출력 장치에 출력한다.
            while((readCnt = bais.read(buffer)) != -1) {
                System.out.write(buffer, 0, readCnt);
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try{
                fis.close();
                bais.close();
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
