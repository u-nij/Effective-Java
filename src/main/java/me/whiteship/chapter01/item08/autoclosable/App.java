package me.whiteship.chapter01.item08.autoclosable;

import java.io.IOException;

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
        /*
        AutoCloseable 인터페이스를 사용하면 try-with-resource 문법에 사용할 수 있다.
        자원 반납을 자동으로 해주기 떄문에 finally 블럭을 쓰지 않아도 된다.
        finally 블럭을 작성하지 않았거나, 잘못 작성했을 경우 자원 반납이 제대로 되지 않는 문제를 방지할 수 있다.
         */
        try(AutoClosableIsGood good = new AutoClosableIsGood(""); // 사용할 리소르를 정의.
            AutoClosableIsGood good1 = new AutoClosableIsGood("")) { // ';'를 구분자로 여러 개 정의할 수 있다.
            // TODO 자원 반납 처리가 됨.

            good.close(); // Closeable; 명시적으로 호출할 수도 있기 때문에 반드시 idempotent 해야 한다.
        }
        /*
        // 1. 그냥 던질 경우 클라이언트 측이 IOException 에러를 잡아줘야 한다.
        catch (IOException e) {
            e.printStackTrace();
        }
         */
        // 2,3. close 메서드에서 예외를 처리했기 때문에, 클라이언트 측에서 예외를 처리하지 않아도 된다. catch 구문 삭제
    }
}
