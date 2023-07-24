package me.whiteship.chapter01.item01;

public interface HelloService {

    // 메서드 선언
    String hello();

    /*
    메서드 정의
    자바 8 이전에는 메서드를 정의하기 위해서는 default 혹은 static 키워드가 필요했다.
    인스턴스에서만 호출할 수 있는, 인스턴스를 만들어야만 하는 메서드 -> 기본(인스턴스, default) 메서드
    인스턴스를 만들지 않고도 호출할 수 있는 메서드 -> 정적(static) 메서드

    기본 메서드
    인터페이스에서 메소드 선언 뿐 아니라, 기본적인 구현체까지 제공할 수 있다
    기존의 인터페이스를 구현하는 클래스에 기본적인 구현체, 즉 새로운 기능을 추가할 수 있다. 하위 클래스를 고치지 않아도 된다.
    인터페이스에만 새로운 기능을 추가했는데, 인터페이스를 구현한 클래스들의 인스턴스들이 이 메서드를 사용할 수 있게 되는 것.

    정적 메서드
    인터페이스에서 public 접근 제어자가 생략되어 있다
    자바 9부터 private static 메소드도 가질 수 있다. 단, private 필드는 아직도 선언할 수 없다.

    자바 8 이전에는 인터페이스를 반환하는 정적 메서드가 필요하면, 인스턴스화 불가인 동반 클래스를 만들어 그 안에 정의했다.
    하지만, 자바 8부터 인터페이스에 정적 메서드를 선언할 수 있게 되면서, 동반 클래스를 만들 필요가 없어졌다.

    인스턴스 불가 = 인스턴스를 만들지 않는. 즉, static만 제공한다.
    (private 생성자, final 클래스 등을 통해 상속 막아야하기 때문. 막지 않으면 하위 클래스에서 상위 인스턴스를 만들 수 있게 된다.)

    클래스들은 필드 가질 수 있지만, 인터페이스는 내부적인 필드를 가질 수 없다.
    public한 필드를 만들며, 보통 상수만 정의. private한 필드를 가질 수 있는 기능이 없다.
    private 필드로 어떤 유틸리티와 같은 것들을 만들고자 할 경우에는, default/static로는 커버하지 못함.
    그래도 이로 인해 많은 불필요한 과정을 줄일 수 있었고, 인터페이스의 기능들이 풍부해졌다.
    */

    // 정적 메서드
    public static String hi() {
        prepareMessage();
        return "hi";
    }

    // 공통 작업. 외부에 공개 X -> 자바 9부터 private static 메소드
    static private void prepareMessage() {
    }

    static public String hi1() {
        prepareMessage();
        return "hi";
    }

    static String hi2() {
        prepareMessage();
        return "hi";
    }

    // 인스턴스 메서드
    default String bye() {
        return "bye";
    }


    // 인터페이스 기본 접근 제어자 public
//    static HelloService of(String lang) {
//        if (lang.equals("ko")) {
//            return new KoreanHelloService();
//        } else {
//            return new EnglishHelloService();
//        }
//    }
}
