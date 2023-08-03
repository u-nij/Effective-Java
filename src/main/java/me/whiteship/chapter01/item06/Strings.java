package me.whiteship.chapter01.item06;

public class Strings {

    public static void main(String[] args) {
        /*
        JVM은 내부적으로 문자열을 모두 Constant Pool에서 캐싱하고 있다고 생각하면 된다.
        일단 생성된 문자열을 담아두고, 동일한 문자열을 사용할 경우 풀에서 참조하는 방법을 사용한다.

        문자열을 비교할 때는 eqauls를 사용하여 값 자체가 같은지 비교한다.
        문자열 값이 같더라도 인스턴스가 다른 경우를 대비하기 위해 항상 eqauls를 통해 비교하라고 한다.
         */
        String hello = "hello";

        //TODO 이 방법은 권장하지 않습니다.
        String hello2 = new String("hello"); // 불필요하게 객체를 만듦.

        String hello3 = "hello";

        System.out.println(hello == hello2); // false
        System.out.println(hello.equals(hello2)); // true
        System.out.println(hello == hello3); // true
        System.out.println(hello.equals(hello3)); // true
    }
}
