package me.whiteship.chapter01.item09.trywithresources;

import java.io.*;

public class Copy {
    private static final int BUFFER_SIZE = 8 * 1024;

    // 코드 9-4 복수의 자원을 처리하는 try-with-resources - 짧고 매혹적이다! (49쪽)
    static void copy(String src, String dst) throws IOException {
        // in, out 둘 다 Closable이 실행되는 것을 보장한다.(항상 성공한다고 보장하는 것 X)
        try (InputStream   in = new FileInputStream(src);
             OutputStream out = new FileOutputStream(dst)) {
            byte[] buf = new byte[BUFFER_SIZE];
            int n;
            while ((n = in.read(buf)) >= 0)
                out.write(buf, 0, n);
        }
        /*
        예외를 잡아먹지 않는다.
         */
    }

    public static void main(String[] args) throws IOException {
        String src = args[0];
        String dst = args[1];
        copy(src, dst);
    }
}
