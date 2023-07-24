package me.whiteship.chapter01.item02.builder;

public class BuilderTest {

    public static void main(String[] args) {
        new NutritionFacts.NutritionFactsBuilder()
                .servingSize(10)
                .calories(10)
                .build();

        /*
        @Builder를 사용하면 필수값과 옵셔널한 값을 따로 받기 어려워진다.
        필수적인 값을 생성자로 받고, 옵셔널한 값을 따로 받는 기능을 지원하지 않는다.

        대안;
        Builder(int servingSize, int servings) -> 기존의 Builder를 만들 때 생성자에 필수 필드를 생성하게 한 후,
        NutritionFacts build() -> 옵셔널한 값을 메서드 체이닝으로 받는 방법.
        new NutritionFacts.Builder(10, 10) // 필수 값
                // 옵셔널 값
                .calories(10)
                .build();
        */
        new NutritionFacts.NutritionFactsBuilder() // Builder()의 이름이 NutritionFactsBuilder()가 되었다.
                .calories(10)
                .build();
    }
}
