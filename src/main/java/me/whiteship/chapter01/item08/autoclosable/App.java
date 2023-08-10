package me.whiteship.chapter01.item08.autoclosable;

public class App {

    public static void main(String[] args) {
        /*
        try {
            // 할 일
        } catch () {
        } finally {
            // 자원 반납
        }

        이 방법이 아닌 'try with resource 문법'을 사용하는 것을 권장.
         */

        // try-with-resource 문법
        try(AutoClosableIsGood good = new AutoClosableIsGood("")) {
            // TODO 자원 반납 처리가 됨.

        }
    }
}
