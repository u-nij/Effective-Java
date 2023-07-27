package me.whiteship.chapter01.item03.staticfactory;

import java.util.Objects;

// 코드 3-2 제네릭 싱글톤 팩토리 (24쪽)
public class MetaElvis<T> { // <T> 인스턴스 스콥

    private static final MetaElvis<Object> INSTANCE = new MetaElvis<>();

    private MetaElvis() { }

    /*
    "정적 팩터리를 제네릭 싱글턴 팩터리로 만들 수 있다."

    제네릭 싱글턴 팩토리에서 해주는 일은, 단순히 우리가 가진 싱글턴 인스턴스를 원하는 타입으로 변환해주는 일을 한다.
    <E> 스테틱 스콥. 클래스가 선언한 제네릭 타입을 사용하지 않는다.
    */
    @SuppressWarnings("unchecked")
    public static <E> MetaElvis<E> getInstance() { return (MetaElvis<E>) INSTANCE; }

    public void say(T t) { // 클래스가 선언한 타입.
        System.out.println(t);
    }

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    public static void main(String[] args) {
        /*
        제네릭 타입으로 동일한 싱글턴 인스턴스를 사용하고 싶을 떄, 제네릭 싱글톤 팩토리를 만들어 사용할 수 있다.
        제네릭 타입을 쓸 때, 인스턴스는 동일하지만 각각 원하는 대로 형변환해 쓸 수 있다.
        */
        MetaElvis<String> elvis1 = MetaElvis.getInstance();
        MetaElvis<Integer> elvis2 = MetaElvis.getInstance();
        System.out.println(elvis1);
        System.out.println(elvis2);
        System.out.println(Objects.equals(elvis1, elvis2)); // true.
        // System.out.println(elvis1 == elvis2); // 타입이 다르기 때문에 == 비교는 불가능하다.
        elvis1.say("hello"); // 클래스에 선언했던 타입 <T> 즉, String으로 호출
        elvis2.say(100); // Integer로 호출
    }

}
