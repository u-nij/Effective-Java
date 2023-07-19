package me.whiteship.chapter01.item01;

/**
 * 이 클래스의 인스턴스는 #getInstance()를 통해 사용한다.
 * @see #getInstance()
 */
public class Settings {

    private boolean useAutoSteering;

    private boolean useABS;

    private Difficulty difficulty;

    /*
    자바의 생성자는 호출할 때마다 새로운 인스턴스를 만든다.
    경우에 따라 인스턴스를 매번 만들지, 특정한 경우에만 만들지 등 인스턴스를 만드는 방법을 통제해야 할 필요가 있다.

    생성자를 publlic하게 제공할 때, 인스턴스의 생성을 컨트롤할 수 없다. 즉, 어디서든 이 생성자를 호출해 새 인스턴스를 만들 수 있다.
    사용하는 측에서 객체 생성을 얼마든지 원하는대로 생성할 수 있다.

    만약 단 한 개의 인스턴스만 만들어야 한다면, 생성자가 아닌 정적 팩토리를 사용하여 인스턴스를 통제할 수 있다.
    객체 생성을 팩토리 내에서 관리할 수 있으며, 생성 로직 컨트롤 또한 그 안에서 가능하다.
    */

    // private 접근 제어자 => 생성자를 호출 불가능
    private Settings() {}

    // 인스턴스를 미리 생성
    private static final Settings SETTINGS = new Settings();

    //미리 만들어놓은 인스턴스를 정적 팩토리로 제공
    public static Settings getInstance() {
        return SETTINGS;
    }

}
