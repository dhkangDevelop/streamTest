import java.io.*;
import java.util.Base64;

public class ByteArrayObjectStreamTest {
    static void objectToByteArray(Object yourObject) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutput out = new ObjectOutputStream(bos);
        out.writeObject(yourObject);
        byte[] yourBytes = bos.toByteArray();
    }

    static void byteArrayToObject(byte[] yourBytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bis = new ByteArrayInputStream(yourBytes);
        ObjectInput in = new ObjectInputStream(bis);
        Object o = in.readObject();
    }

    public static void main(String[] args) throws IOException {
        Member member = new Member("dhkang", "test@test.com", 30);
        byte[] serializedMember;
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
                oos.writeObject(member);
                // serializedMember -> 직렬화된 member 객체
                serializedMember = baos.toByteArray();
            }
        }
        // 바이트 배열로 생성된 직렬화 데이터를 base64로 변환
        System.out.println(Base64.getEncoder().encodeToString(serializedMember));
    }
}
