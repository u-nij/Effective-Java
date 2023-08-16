package me.whiteship.chapter01.item08.autoclosable;

import java.io.*;

//public class AutoClosableIsGood implements AutoCloseable {
public class AutoClosableIsGood implements Closeable {

    private BufferedReader reader;

    public AutoClosableIsGood(String path) {
        try {
            this.reader = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(path);
        }
    }

    // 작업 정리. close 메서드를 구현하면 해당 인터페이스의 구현은 끝난 것.
    /*
    void close() throws Exception
    -> throws Exception은 구현과 크게 관련이 없으며, 구현하지 않아도 된다.

    BufferedReader의 자원을 반납할 때 close를 해야 한다고 가정할 떄, IOException이 발생한다.
    3가지 정도의 선택 사항이 있다.

    1. 예외를 그냥 던진다.
     - AutoClosableIsGood을 사용하는 클라이언트가 처리하도록 의도.
     - 예외를 던져야 한다면, Exception을 던지는 것보다 더 구체적인 타입인 IOException을 던지는 것을 더 권장한다.

    @Override
    public void close() throws IOException{
        reader.close();
    }

    2. 예외를 안에서 처리하는 것.
    3. 에러를 변환하는 것.
     - 클라이언트에서 굳이 잡지 않아도 된다. Runtime 계열의 예외이기 때문에,
       이 코드를 실행하는 스레드는 에러를 던지면서 해당 스레드는 종료가 될 것.
       (스레드가 종료된다고 프로그램이 종료되는 것은 아니다.)
    +) 로깅만 할 수 있을 것.

    가급적 이 close는 idempotent 해야 한다.
    즉, 몇번을 수행되던지 상관 없이 같은 결과가 발생해야 한다.
    여러 번 호출될 용도로 만든 것은 아니기 때문에 꼭 idempotent 해야하는 것은 아니지만, 권장한다.
     */


    @Override
    public void close() {
        try {
            reader.close();
        } catch (IOException e) {
            // 2. 예외를 안에서 처리하는 것.
            // e.printStackTrace();

            // 3. 에러를 변환하는 것.
            throw new RuntimeException(e);
        }
    }
}
