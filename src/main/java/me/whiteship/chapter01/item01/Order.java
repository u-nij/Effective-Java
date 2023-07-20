package me.whiteship.chapter01.item01;

import java.util.*;

public class Order {

    private boolean prime;

    private boolean urgent;

    private Product product;

    /*
    short, int 등으로 표현할 수 있다.

    // 0 - 주문 받음
    // 1 - 준비 중
    private in status;

    private final int PREPARING = 0;
    private final int SHIPPED = 0;

    하지만, 이러한 경우에는 허용하지 않는 값을 방어 및 검증하는 코드가 필요하다.

    enum 타입을 통해 type safety 보장할 수 있다.
    */
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

        // 특정 enum 타입이 가질 수 있는 모든 값을 순회하며 출력하라.
        Arrays.stream(OrderStatus.values()).forEach(System.out::println);


        /*
        enum의 값은 == 연산자로 동일성을 비교할 수 있는가?
        JVM 레벨에서 딱 하나의 인스턴스만 있음을 보장하기 떄문에, equals를 쓸 필요 없다.
        equols의 경우 null을 가지고 있어, NullPointException을 발생시킬 가능성이 있따.
        */
        Order order = new Order();
        // 현재 order.orderStatus는 null이기 때문에, equals 사용시 NullPointException 발생.
        if (order.orderStatus == OrderStatus.DELIVERED) {
            System.out.println("delivered");
        }


        /*
        enum을 key로 사용하는 Map을 정의하세요. 또는 enum을 담고 있는 Set을 만들어보세요.
        왜 일반적인 HashMap/HashSet보다 EnumSet/EnumMap을 사용해야 효율적인지 고민해보기.
        */
        EnumSet<OrderStatus> orderStatusEnumSet = EnumSet.allOf(OrderStatus.class);
        System.out.println("orderStatusEnumSet = " + orderStatusEnumSet);

        EnumMap<OrderStatus, Object> orderStatusEnumMap = new EnumMap<>(OrderStatus.class);
        Arrays.stream(OrderStatus.values()).forEach(os -> orderStatusEnumMap.put(os, null));
        System.out.println("orderStatusEnumMap = " + orderStatusEnumMap);
    }

}
