package me.whiteship.chapter01.item03.field;

import java.io.Serializable;

// 코드 3-1 public static final 필드 방식의 싱글턴 (23쪽)
/*
스프링을 쓰지 않을 때의 이야기.
1. 인터페이스(IElvis)과 싱글턴 클래스(Elvis)를 만들어 테스트가 어렵다는 단점 극복,
2. 리플렉션으로 발생하는 문제점 해결
3. 역직렬화으로 발생하는 문제점 해결
이를 통해 싱글턴 객체을 직접 생성 및 관리할 수 있다.
하지만 이 과정에서 코드가 간결하다는 장점이 사라진다.

스프링 IoC 컨테이너를 쓸 경우에는, Bean으로 등록해 사용하면 싱글톤 오브젝트를 사용할 수 있다.
*/
public class Elvis implements IElvis, // 인터페이스 기반으로 Elvis의 대역을 만들어 클라이언트 코드를 테스트할 수 있다.
                                     Serializable { // 직렬화를 하기 위해 인터페이스가 구현되어야 한다.

    /**
     * 싱글톤 오브젝트
     */
    // public static final 필드
    public static final Elvis INSTANCE = new Elvis();

    // 책에서는 생성자가 2번 째 호출되었을 땐, 인스턴스 생성을 막는 것을 권장.
    private static boolean created;

    // private 생성자
    private Elvis() {
        /*
        인스턴스를 안전하게 만들기 위해 flag 체크를 통해 리플렉션을 막음.
        Elvis 인스턴스가 최초로 생성된 후, 리플렉션으로 더이상 생성될 수 없게 됨.
        */
        if (created) {
            throw new UnsupportedOperationException("can't be created by constructor.");
        }

        created = true;
    }

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    public void sing() {
        System.out.println("I'll have a blue~ Christmas without you~");
    }

    // 이 메서드는 보통 클래스 바깥(다른 클래스)에 작성해야 한다!
    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();
    }

    /*
    역직렬화할 때 해당 메서드가 사용된다.
    문법적으로 오버라이딩은 아니지만, 오버라이딩과 비슷하게 작용된다.

    이 메서드를 이렇게 재정의하면 오버라이딩 비슷하게 적용이 된다.
    역직렬화할 때 새로운 인스턴스가 아니라, (재정의한대로) 원래 있는 INSTANCE를 리턴하도록 한 것.
     */
    private Object readResolve() {
        return INSTANCE;
    }

}
