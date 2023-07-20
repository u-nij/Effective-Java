package me.whiteship.chapter01.item01;

public enum OrderStatus {

    // enum은 자바의 클래스처럼 생성자, 메소드, 필드를 가질 수 있는가?

    /*
    값들은 only 1개만 만들어진다.
    싱글톤 패턴을 안전하게 만드는 방법 중 하나로 enum을 사용할 수 있다.
    */
    PREPARING(0), SHIPPED(1), DELIVERING(2), DELIVERED(3);

    private int number;

    OrderStatus(int number) {
        this.number = number;
    }
}
