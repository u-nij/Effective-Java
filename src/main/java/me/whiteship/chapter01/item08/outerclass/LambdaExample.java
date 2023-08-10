package me.whiteship.chapter01.item08.outerclass;

import java.lang.reflect.Field;

// 람다 역시 바깥 객체의 참조를 갖기 쉽다.
public class LambdaExample {

    private int value = 10;

    /*
    람다와 Runnable을 통해 바깥에 있는 값(value)를 참조할 경우,
    아우터 클래스(LambdaExample)에 대한 참조가 람다 안에 들어가게 된다.
    value가 LambdaExample 안에 있는 값이기 떄문에, 인스턴스를 통해 접근하기 위해 레퍼런스가 생긴다.

    클리너로 사용할 Runnable에서 아우터 클래스에 대해 참조하게 되면,
    GC을 통해 LambdaExample 오브젝트를 정리할 때 순환 참조가 생길 수 있다.
    정리해야 할 객체(LambdaExample 오브젝트)에 대한 참조가 생긴다.

    Rambda는 바깥의 인스턴스를 캡쳐링을 할 때 참조가 생긴다.

    +)
    - 아우터 클래스를 참조하더라도, value와 instanceLambda가 static일 경우에 참조하지 않는다.
    - value만 static이어도 참조가 생기지 않는다. 인스턴스 안에 들어있는 값이 아무것도 없기 때문.
    - instanceLambda만 static일 경우에는 참조할 수 없다. static에서 non-static을 참조할 수 없다.(컴파일 에러)
     */
    private Runnable instanceLambda = () -> {
        System.out.println(value);
    };

    public static void main(String[] args) {
        LambdaExample example = new LambdaExample();
        Field[] declaredFields = example.instanceLambda.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println("field type: " + field.getType());
            System.out.println("field name: " + field.getName());
        }
    }

}
