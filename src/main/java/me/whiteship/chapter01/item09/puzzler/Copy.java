package me.whiteship.chapter01.item09.puzzler;

import java.io.*;

public class Copy {
    private static final int BUFFER_SIZE = 8 * 1024;

    // 코드 9-2 자원이 둘 이상이면 try-finally 방식은 너무 지저분하다! (47쪽)
    static void copy(String src, String dst) throws IOException {
        InputStream in = new FileInputStream(src);
        OutputStream out = new FileOutputStream(dst);
        try {
            byte[] buf = new byte[BUFFER_SIZE];
            int n;
            while ((n = in.read(buf)) >= 0)
                out.write(buf, 0, n);
        } finally {
            /*
            예외 처리 코드의 실수를 눈치채지 못한 이유
            try-catch로 감싸져 있어 안전해 보인다. 하지만, 실제로는 안전하지 않다.
            out.close();는 IOException을 발생시키는데, 만약 RuntimeExcepption과 같은 다른 예외가 발생할 경우 out.close(); 코드에서 끝나기 때문.

            finally 절의 경우, RuntimeException이 발생하더라도 finally 구문을 실행하기 때문에
            ./tryfinally.TopLine 클래스처럼 작성해주는 것이 좋다.

            또한, 만약 try-finally 구문으로 작성된 코드가 있다면 모두 고쳐야 한다.
             */
            try {
                out.close();
            } catch (IOException e) {
                // TODO 이렇게 하면 되는거 아닌가?
            }

            try {
                in.close();
            } catch (IOException e) {
                // TODO 안전한가?
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String src = args[0];
        String dst = args[1];
        copy(src, dst);
    }
}
