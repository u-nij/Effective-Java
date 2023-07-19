package me.whiteship.chapter01.item01;

import java.util.EnumSet;
import java.util.Set;

public class Product {

    public static void main(String[] args) {
//        Settings settings = new Settings(); // 불가능

        Settings settings1 = Settings.getInstance();
        Settings settings2 = Settings.getInstance();

        System.out.println(settings1);
        System.out.println(settings2);
        // 동일

        // Boolean 같은 경우에도, 미리 만들어둔 상수 TRUE, FALSE를 이용
        // 매개변수에 따라 각기 다른 인스턴스를 리턴하는 기능 또한 정적 팩토리 메서드를 사용하면 가능하다.
        Boolean.valueOf(false);
        EnumSet.allOf(Difficulty.class);

        /*
        플라이웨이트 패턴(재사용 가능한 객체 인스턴스를 공유시켜 메모리 사용량을 최소화하는 구조 디자인 패턴)과 유사.
        자주 사용하는 객체들을 미리 만들어놓고, 필요한 인스턴스를 꺼내 쓸 수 있게 하는 것에서 통용되는 개념이 있기 때문에 언급됨.
        */
    }
}
