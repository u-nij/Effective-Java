package me.whiteship.chapter01.item08.cleaner_as_a_safetynet;

// cleaner 안전망을 갖춘 자원을 제대로 활용하지 못하는 클라이언트 (45쪽)
public class Teenager {

    public static void main(String[] args) {
        // 자원 반납이 될 수도, 안 될 수도 있다. 운좋게 GC될 때 반납될 수 있다.
        new Room(99); // try-with-resource를 사용하지 않음.
        System.out.println("Peace out");

        // 다음 줄의 주석을 해제한 후 동작을 다시 확인해보자.
        // 단, 가비지 컬렉러를 강제로 호출하는 이런 방식에 의존해서는 절대 안 된다!
        System.gc();
    }
}
