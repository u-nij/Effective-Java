package me.whiteship.chapter01.item09.trywithresources;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TopLine {
    // 코드 9-3 try-with-resources - 자원을 회수하는 최선책! (48쪽)
    static String firstLineOfFile(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(
                new FileReader(path))) { // try 구문에서 사용할 리소스를 소괄호 안에 바로 정의.
            return br.readLine();
            /*
            close를 직접 하지 않는다.
            BufferedReader가 Closeable으로 구현하고 있기 떄문.
            혹은, BufferedReader의 상위 클래스가 Closeable을 구현하고 있기 때문.

            Closable은 곧 AutoCloseable.
             */
        }
    }

    public static void main(String[] args) throws IOException {
        String path = args[0];
        System.out.println(firstLineOfFile(path));
    }
}
