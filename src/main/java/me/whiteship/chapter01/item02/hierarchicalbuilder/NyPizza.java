package me.whiteship.chapter01.item02.hierarchicalbuilder;

import java.util.Objects;

// 코드 2-5 뉴욕 피자 - 계층적 빌더를 활용한 하위 클래스 (20쪽)
public class NyPizza extends Pizza {
    public enum Size { SMALL, MEDIUM, LARGE }
    private final Size size;

    // Pizza.Builder의 하위 클래스인 NyPizza.Builder로, 상위 클래스의 Builder 타입 제한에 딱 맞다.
    public static class Builder extends Pizza.Builder<NyPizza.Builder> { // 두 Builder는 Pizza.Builder가 아닌 자기 자신(NyPizza)의 Builder
        private final Size size;

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override public NyPizza build() {
            return new NyPizza(this);
        }

        @Override protected Builder self() { return this; } // NyPizza.Builder 리턴
    }

    private NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }

    @Override public String toString() {
        return toppings + "로 토핑한 뉴욕 피자";
    }
}
