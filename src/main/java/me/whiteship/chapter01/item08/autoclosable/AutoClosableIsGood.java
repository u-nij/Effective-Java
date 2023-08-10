package me.whiteship.chapter01.item08.autoclosable;

import java.io.*;

public class AutoClosableIsGood implements AutoCloseable {

    private BufferedReader reader;

    public AutoClosableIsGood(String path) {
        try {
            this.reader = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(path);
        }
    }

    // 작업 정리. close 메서드를 구현하면 해당 인터페이스의 구현은 끝난 것.
    @Override
    public void close() {
        try {
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
