import java.io.*;
import java.util.Base64;

public class Member implements Serializable {

    private String name;
    private String email;
    private int age;
    // phone 속성을 추가
    private String phone;

    public Member(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Getter 생략

    @Override
    public String toString() {
        return String.format("Member", name, email, age);
    }

    static public void serialize() throws IOException {
        Member member = new Member("김배민", "deliverykim@baemin.com", 25);
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

    static public void deserialize(String base64) throws IOException {
        // 직렬화 예제에서 생성된 base64 데이터
        String base64Member = base64;
        byte[] serializedMember = Base64.getDecoder().decode(base64Member);
        try (ByteArrayInputStream bais = new ByteArrayInputStream(serializedMember)) {
            try (ObjectInputStream ois = new ObjectInputStream(bais)) {
                // 역직렬화된 Member 객체를 읽어온다.
                Object objectMember = ois.readObject();
                Member member = (Member) objectMember;
                System.out.println(member);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        deserialize("rO0ABXNyAAZNZW1iZXIJKuYdUCI77AIAA0kAA2FnZUwABWVtYWlsdAASTGphdmEvbGFuZy9TdHJpbmc7TAAEbmFtZXEAfgABeHAAAAAZdAAWZGVsaXZlcnlraW1AYmFlbWluLmNvbXQACeq5gOuwsOuvvA==");
    }
}