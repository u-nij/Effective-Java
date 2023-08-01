package me.whiteship.chapter01.item04;

public class DefaultUtilityClass extends UtilityClass {

    public static void main(String[] args) {
        // abstract 키워드를 이용해 추상 클래스로 만들어도, 기본 생성자를 이용해 인스턴스를 만들 수 있다.
        DefaultUtilityClass utilityClass = new DefaultUtilityClass();
        utilityClass.hello();
    }
}
