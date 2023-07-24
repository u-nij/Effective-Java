package me.whiteship.chapter01.item02.builder;

import lombok.*;

// 코드 2-3 빌더 패턴 - 점층적 생성자 패턴과 자바빈즈 패턴의 장점만 취했다. (17~18쪽)
@Builder //(builderClassName = "Builder")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    /*
    빌더 패턴
    필수 속성에 해당하는 것들을 설정할 수 있어, 자바빈즈보다 객체를 안전하고 consistency하게 만들 수 있다.
    But, 오히려 코드를 이해하기 어렵게 만든다. 필드가 중복된다.

    모든 경우에 빌더 패턴을 만들지 말 것.
    옵셔널한 매개변수가 많을 경우, immutable하게 만들고 싶다 => 빌더 패턴
    */
    /*
    public static void main(String[] args) {

        NutritionFacts cocaCola = new Builder(240, 8)
                .calories(100)
                .sodium(35)
                .carbohydrate(27) // Builder 리턴
                .build(); // NutritionFacts 리턴
    }

    public static class Builder {
        // 필수 매개변수
        private final int servingSize;
        private final int servings;

        // 선택 매개변수 - 기본값으로 초기화한다.
        private int calories      = 0;
        private int fat           = 0;
        private int sodium        = 0;
        private int carbohydrate  = 0;

        // 필수로 받아야하는 값 설정
        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings    = servings;
        }

        // Setter와 비슷한 역할을 하는 것.
        // return이 void가 아니라, Builder 타입 그 자체. => 플루언트 API 또는 메서드 체이닝이 가능해진다.
        public Builder calories(int val)
        { calories = val;      return this; }
        public Builder fat(int val)
        { fat = val;           return this; }
        public Builder sodium(int val)
        { sodium = val;        return this; }
        public Builder carbohydrate(int val)
        { carbohydrate = val;  return this; }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder builder) {
        servingSize  = builder.servingSize;
        servings     = builder.servings;
        calories     = builder.calories;
        fat          = builder.fat;
        sodium       = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }
    */

    /*
    @Builder 어노테이션 작성시 사용 가능
    
    자바의 '어노테이션 프로세서'는 컴파일하는 시점에 어노테이션을 읽어들여 클래스를 만들고 코드를 조작할 수 있는 기능을 제공해준다.
    @Builder 어노테이션을 통해 롬복이 제공하는 어노테이션 프로세서가 작성하지 않았던 코드(생성자)를 생성해주기 때문에,
    위의 코드를 작성하지 않아도 된다.
    (target/classes/me/whiteship/chater01/item02/builder/NutritionFacts 에서 확인 가능)

    장점: 코드가 간결해진다.

    단점1: 어노테이션을 통해 모든 파라미터를 받는 생성자가 기본적으로 생긴다.
    -> @AllArgsConstructor(access = AcessLevel.PRIVATE)를 통해 내부에서만 사용 가능하게 할 수 있다.

    단점2: 필수 값을 설정해줄 수 없다.

    단점3: Builder()의 이름이 Builder가 아니게 된다.
    -> @Builder 인자 값 builderClassName을 Builder로 설정해주면 된다.
    */
    public static void main(String[] args) {
        NutritionFacts nutritionFacts = new NutritionFactsBuilder()
                .servingSize(100)
                .servings(10)
                .build();
    }
}
