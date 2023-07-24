package me.whiteship.chapter01.item02.javabeans;

// 코드 2-2 자바빈즈 패턴 - 일관성이 깨지고, 불변으로 만들 수 없다. (16쪽)
public class NutritionFacts {
    // 필드 (기본값이 있다면) 기본값으로 초기화된다.
    private int servingSize  = -1; // 필수; 기본값 없음
    private int servings     = -1; // 필수; 기본값 없음
    private int calories     = 0;
    private int fat          = 0;
    private int sodium       = 0;
    private int carbohydrate = 0;
    private boolean healthy;

    public NutritionFacts() { }

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public void setHealthy(boolean healthy) {
        this.healthy = healthy;
    }

    /*
    객체 생성이 간단해지는 반면, 일관성(consistency)이 깨진 상태로 객체가 사용될 여지가 있다.
    (ex. 필수 설정 값이 세팅 안된 채 사용되지 않아 일관성이 깨질 수 있다.)

    두 가지를 혼용해 사용하는 방법
    필드는 생성자로 넘겨서 받도록 강제성을 주며, 옵셔널한 것을 set을 통해 설정하게 함.

    단점: 붉변(immutable) 객체로 만들기 어렵다.
    불변 객체로 만들기 위해서는 생성자를 통해 값을 받은 후 Setter 메서드를 없애야 한다.
    */
    public static void main(String[] args) {
        NutritionFacts cocaCola = new NutritionFacts();
        cocaCola.setServingSize(240);
        cocaCola.setServings(8);

        cocaCola.setCalories(100);
        cocaCola.setSodium(35);
        cocaCola.setCarbohydrate(27);
    }
}
