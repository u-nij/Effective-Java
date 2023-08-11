package me.whiteship.chapter01.item09.suppress;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TopLine {
    // 코드 9-1 try-finally - 더 이상 자원을 회수하는 최선의 방책이 아니다! (47쪽)
    static String firstLineOfFile(String path) throws IOException {
        try(BufferedReader br = new BadBufferedReader(new FileReader(path))) {
            return br.readLine(); // CharConversionException 발생
            /*
            close는 try-with-resource 문법이 언젠가 실행해주기 때문에 StreamCorruptedException 또한 발생하게 된다.
            CharConversionException가 발생하는 것도 보이며, StreamCorruptedException도 보인다.
             */
        }
    }

    // try-finally
//    static String firstLineOfFile(String path) throws IOException {
//        BufferedReader br = new BadBufferedReader(new FileReader(path));
//        try {
//            return br.readLine(); // CharConversionException 발생
//        } finally {
//            br.close(); // StreamCorruptedException 발생
//        }
//        /*
//        main 함수를 실행했을 때, 가장 나중에 발생한 예외'만' 보인다.
//        하지만, 디버깅을 하다보면 가장 처음에 발생한 예외가 중요하다.
//
//        try-catch-finally 문법을 사용해서 가장 처음에 발생한 예외가 안 먹히게끔 작성하는 방법도 있지만
//        코드가 지저분해지기 시작한다.
//         */
//    }

    public static void main(String[] args) throws IOException {
        System.out.println(firstLineOfFile("pom.xml"));
    }
}
