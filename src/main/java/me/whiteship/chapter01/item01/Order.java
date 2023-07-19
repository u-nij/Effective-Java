package me.whiteship.chapter01.item01;

import java.util.*;

public class Order {

    private boolean prime;

    private boolean urgent;

    private Product product;

    private OrderStatus orderStatus;


    /*
    public Order(boolean urgent, Product product) {
        this.urgent = urgent;
        this.product = product;
    }

    // 생성자의 매개변수 타입이 동일할 경우 컴파일 에러
    public Order(boolean urgent, Product product) {
        this.urgent = urgent;
        this.product = product;
    }

    // 생성자의 매개변수 순서가 다를 경우 컴파일 에러 발생 X
    public Order(Product product, boolean urgent) {
        this.urgent = urgent;
        this.product = product;
    }
    */


    /*
    인스턴스를 만들어주는 역할을 하는 "정적 펙토리 메서드"를 사용.
    (추상 팩토리 패턴, 팩토리 메서드 패턴과 상관 X)
    객체의 특징을 팩터리 메서드의 이름으로 좀더 명확히 잘 표현할 수 있다.
    생성자의 시그니처가 중복되는 경우 고려해보면 좋을 것.
     */
    public static Order primeOrder(Product product) {
        Order order = new Order();
        order.prime = true;
        order.product = product;

        return order;
    }

    public static Order urgentOrder(Product product) {
        Order order = new Order();
        order.urgent = true;
        order.product = product;
        return order;
    }

    public static void main(String[] args) {

        Order order = new Order();
        if (order.orderStatus == OrderStatus.DELIVERED) {
            System.out.println("delivered");
        }
    }

}
