package me.whiteship.chapter01.item03.enumtype;

import me.whiteship.chapter01.item03.field.IElvis;

// 열거 타입 방식의 싱글턴 - 바람직한 방법 (25쪽)
public enum Elvis { // implements IElvis { // 테스트시
    /*
    원소가 하나뿐인 열거 타입으로 정의.
    가장 간결한 방법이며 직렬화와 리플렉션에도 안전하다.
    대부분의 상황에서는 원소가 하나뿐인 열거 타입이 싱글턴을 만드는 가장 좋은 방법이다.
    */
    INSTANCE;

    public void leaveTheBuilding() {
        System.out.println("기다려 자기야, 지금 나갈께!");
    }

    /*
    // 테스트시, 인터페이스의 별도의 구현체를 넘겨주면 된다.
    // 클라이언트 코드가 인터페이스 타입을 사용하도록 하면 된다.
    @Override
    public void sing() {

    }
    */

    // 이 메서드는 보통 클래스 바깥(다른 클래스)에 작성해야 한다!
    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();
    }
}
