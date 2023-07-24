package me.whiteship.chapter01.item02.hierarchicalbuilder;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

// 코드 2-4 계층적으로 설계된 클래스와 잘 어울리는 빌더 패턴 (19쪽)

// 참고: 여기서 사용한 '시뮬레이트한 셀프 타입(simulated self-type)' 관용구는
// 빌더뿐 아니라 임의의 유동적인 계층구조를 허용한다.

public abstract class Pizza {
    public enum Topping { HAM, MUSHROOM, ONION, PEPPER, SAUSAGE }
    final Set<Topping> toppings;

    /*
    추상 클래스의 추상 빌더.
    제네릭 타입에는 빌더 자신의 하위 클래스 타입을 받도록 함. -> 재귀적 타입 제한 사용(자신의 타입이 자기 자신의 제네릭 타입)
    */
    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
        public T addTopping(Topping topping) { // Builder의 하위 클래스 타입에 해당하는 인스턴스 T를 리턴.
            toppings.add(Objects.requireNonNull(topping));
            return self(); // 상속 구조에 따라, this가 아닌 self를 리턴. => 즉, 하위클래스.Builder를 리턴하게 된다.
        }
        /*
        self()가 아닌 this를 사용하려면, 리턴 타입이 T -> Builder<T>

        // Builder 타입의 T라는 제네릭 타입을 가지고 있는 Builder 타입을 리턴.
        public Builder<T> addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return this;
        }

        하지만, Builder<T> 타입을 리턴하기 시작하면 하위 클래스들의 메서드 사용이 불편해진다.
        하위 클래스의 빌더들은 자기 자신을 리턴해야 한다. 그래야, 그 하위 Builder의 메서드를 참조할 수 있기 때문.
        */

        // self()일 경우, 하위 클래스 리턴. this일 경우, Pizza 리턴.
        abstract Pizza build();

        // 하위 클래스는 이 메서드를 재정의(overriding)하여
        // "this"를 반환하도록 해야 한다.
        protected abstract T self();
    }
    
    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone(); // 아이템 50 참조
    }
}
