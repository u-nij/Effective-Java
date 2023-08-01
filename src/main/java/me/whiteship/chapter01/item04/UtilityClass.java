package me.whiteship.chapter01.item04;

import org.springframework.context.annotation.AnnotationConfigUtils;

/*
abstract 키워드를 이용해 추상 클래스로 만들어도, 기본 생성자를 이용해 인스턴스를 만들 수 있다.
오히려 상속을 해 사용하는 클래스라고 착각을 하게 할 여지가 있다.
*/
public class UtilityClass {

    /**
     * 이 클래스는 인스턴스를 만들 수 없습니다.
     */
    /*
    private으로 기본 생성자를 만들어 상속을 막을 수 있다.
    하지만, 클래스 내부에서 인스턴스를 만들 수 있다.

    private UtilityClass() {
        throw new AssertionError(); // 만나지 않길 바라는 에러. 해당 에러가 발생하면 잘못됐음을 명시.
    }
    */

    public static String hello() {
        return "hello";
    }

    public static void main(String[] args) {
        // 1. 클래스를 통해 바로 호출이 가능하다.
        String hello = UtilityClass.hello();

        // 2. 인스턴스를 만든 후 호출도 가능하다.
        // 인스턴스 메서드인지 정적 메서드인지 햇갈리게 하는 코드이므로, 권장하지 않는다.
        UtilityClass utilityClass = new UtilityClass(); // AssertionError() 에러로, 해당 코드로 도달하지 않는다.
        utilityClass.hello();


    }
}
