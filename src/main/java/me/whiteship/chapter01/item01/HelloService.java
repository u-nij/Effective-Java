package me.whiteship.chapter01.item01;

public interface HelloService {

    String hello();

    static String hi() {
        prepareMessage();
        return "hi";
    }

    static private void prepareMessage() {
    }

    static String hi1() {
        prepareMessage();
        return "hi";
    }

    static String hi2() {
        prepareMessage();
        return "hi";
    }

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
