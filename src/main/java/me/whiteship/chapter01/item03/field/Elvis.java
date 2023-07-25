package me.whiteship.chapter01.item03.field;

import java.io.Serializable;

// 코드 3-1 public static final 필드 방식의 싱글턴 (23쪽)
public class Elvis implements IElvis, // 인터페이스 기반으로 Elvis의 대역을 만들어 클라이언트 코드를 테스트할 수 있다.
                                      Serializable {

    /**
     * 싱글톤 오브젝트
     */
    public static final Elvis INSTANCE = new Elvis();
    private static boolean created;

    private Elvis() {
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

    private Object readResolve() {
        return INSTANCE;
    }

}
