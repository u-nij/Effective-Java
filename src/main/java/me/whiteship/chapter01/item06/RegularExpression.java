package me.whiteship.chapter01.item06;

import java.util.regex.Pattern;

public class RegularExpression {

    private static final Pattern SPLIT_PATTERN = Pattern.compile(",");

    public static void main(String[] args) {
        long start = System.nanoTime();
        for (int j = 0; j < 10000; j++) {
            String name = "keesun,whiteship";
            /*
            한 글자의 구분자를 이용해 문자열을 분리할 때,
            split()을 사용하는 것이 미리 컴파일한 패턴을 호출하는 것보다 더 빠르다.

            여러 글자의 경우, 패턴을 미리 컴파일해 재사용하는 것이 유리하다.
             */
            name.split(","); // 컴파일하지 않았을 때
//            SPLIT_PATTERN.split(name); // 미리 컴파일한 패턴을 호출하는 것.
        }
        System.out.println(System.nanoTime() - start);
    }
}
