package me.whiteship.chapter01.item03.functionalinterface;


import me.whiteship.chapter01.item03.methodreference.Person;

import java.time.LocalDate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class DefaultFunctions {

    // 알아야 할 4개의 인터페이스: Function / Supplier / Consumer / Predicate
    public static void main(String[] args) {
        /*
        2개의 제네릭 타입. 첫 번째는 input, 두 번째는 output.
        무언가를 받고, 리턴하는 것이 있다.
        */
        Function<Integer, String> intToString = Object::toString;

        /*
        받는 것이 없고, 나오는 것만 있다.

        왼쪽에 선언하는 타겟 타입에 따라 각기 다른 생성자를 참조할 수 있다.
        */
        Supplier<Person> personSupplier = Person::new; // 기본 생성자
        Function<LocalDate, Person> personFunction = Person::new; // 매개변수가 있는 생성자

        /*
        받는 것은 있지만, 리턴이 없다.
        */
        Consumer<Integer> integerConsumer = System.out::println;

        /*
        받는 것에 따라 boolean를 리턴하는 함수. 그래서 출력 타입이 없다.
        ex. pe
         */
        Predicate<Person> predicate;
    }
}
