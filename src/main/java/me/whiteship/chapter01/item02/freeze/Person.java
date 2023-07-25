package me.whiteship.chapter01.item02.freeze;

import java.util.ArrayList;
import java.util.List;

public class Person {
// public final class Person { // 상속을 막는 방법. 변경이 되고 싶지 않은 경우 클래스에 final 설정.

    private final String name;

    private final int birthYear;

    private final List<String> kids;

    public Person(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
        this.kids = new ArrayList<>();
    }

    /*
    만약 freezing 기능을 사용한다면, 특정한 flag 값을 체크하는 메서드가 별도로 필요

    public void settName() {
        checkIfObjectIsFrozen();
        this.name = name;
    }

    private void checkIfObjectIsFrozen() {
        if (this.frozen()) {
            throw new IllegalStateException();
        }
    }
    */

    public static void main(String[] args) {
        Person person = new Person("keesun", 1982);

        // person.name = "whiteship"; // 각 property가 final이 아닐 경우 가능

        // person.kids = new ArrayList<>(); // 레퍼런스가 불변이기 때문에 새로운 할당이 불가능.
        person.kids.add("whiteship"); // 객체 안에 있는 인스턴스가 불변이 되는 것은 아니다.


        // 객체가 final
        final Person person1 = new Person("keesun", 1982);
        // person1 = new Person("whiteship", 1002); // 수정 불가능
    }
}
