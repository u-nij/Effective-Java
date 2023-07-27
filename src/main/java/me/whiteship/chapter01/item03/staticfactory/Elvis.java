package me.whiteship.chapter01.item03.staticfactory;

// 코드 3-2 정적 팩터리 방식의 싱글턴 (24쪽)
public class Elvis implements Singer {
    private static final Elvis INSTANCE = new Elvis();
    private Elvis() { }

    // 인자가 없으며 오브젝트를 리턴하는 메서드이다. => Supplier의 메서드 get()에 준하는 메서드.
    // 즉, 정적 팩터리의 메서드 참조를 공급자로 사용할 수 있다.
    public static Elvis getInstance() { return INSTANCE; }

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    // 이 메서드는 보통 클래스 바깥(다른 클래스)에 작성해야 한다!
    public static void main(String[] args) {
        /*
        "API를 바꾸지 않고도 싱글턴이 아니게 변경할 수 있다."
        클라이언트 코드가 API를 바꾸지 않고(getInstance를 그대로 사용하면서) 행위를 바꿀 수 있게 된다.

        예로, 원래 싱글턴 인스턴스를 가져와 매번 동일한 인스턴스를 얻었지만, new Elvis() 리턴을 해줄 수 있다.
        */
        Elvis elvis = Elvis.getInstance();
        elvis.leaveTheBuilding();

        // getInstance() 메서드에서 INSTANCE를 제공할 경우 true, new Elvis()를 리턴할 경우 false.
        System.out.println(Elvis.getInstance());
        System.out.println(Elvis.getInstance());
    }

    // Singer 인터페이스 구현
    @Override
    public void sing() {
        System.out.println("my way~~~");
    }
}
