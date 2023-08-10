package me.whiteship.chapter01.item08.cleaner_as_a_safetynet;

// cleaner 안전망을 갖춘 자원을 제대로 활용하는 클라이언트 (45쪽)
public class Adult {
    public static void main(String[] args) {
        // try-with-resource를 사용해 자원 반납이 제대로 된다.
        try (Room myRoom = new Room(7)) {
            System.out.println("안녕~");
        }
    }
}
