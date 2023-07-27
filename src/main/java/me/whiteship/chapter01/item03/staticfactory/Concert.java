package me.whiteship.chapter01.item03.staticfactory;

import java.util.function.Supplier;

public class Concert {

    // Singer를 제공해주는 Supplier한테, Singer 오퍼레이션
    /*
    "정적 팩터리의 메서드 참조를 공급자(Supplier)로 사용할 수 있다."

    어떠한 타입이든 하나를 리턴하기만 하면, Supplier라는 FunctionalInterface의 조건에 만족하는 것.
    Supplier를 직접 구현하지 않더라도, 마치 Supplier처럼 사용할 수 있게 된다.

    Supplier => 인자 없는 메서드 get()을 호출해 어떠한 오브젝트 하나를 리턴해주는 역할.
    */
    public void start(Supplier<Singer> singerSupplier) { // Singer라는 타입을 매개변수로 받고 있다.
        // singerSupplier는 get 메서드를 통해 Singer 인스턴스를 제공해주는 Supplier
        Singer singer = singerSupplier.get();
        singer.sing(); // Elvis.sing()이 호출된다.
    }

    public static void main(String[] args) {
        Concert concert = new Concert();
        // Elvis에 Singer 인터페이스를 구현한 후,
        concert.start(Elvis::getInstance); // Elvis.getInstance() 자체를 Supplier의 구현체처럼 파라미터로 넘김.
    }
}
