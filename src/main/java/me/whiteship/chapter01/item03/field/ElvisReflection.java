package me.whiteship.chapter01.item03.field;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

// 생성자로 여러 인스턴스 만들기
public class ElvisReflection {

    public static void main(String[] args) {
        try {
            /*
            getConstructor()는 public 생성자에만 접근할 수 있다.
            getDeclaredConstructor()는 선언되어 있는 기본 생성자로, 접근 제어자 상관 없이 private 생성자에도 접근 가능.
            */
            Constructor<Elvis> defaultConstructor = Elvis.class.getDeclaredConstructor();
            defaultConstructor.setAccessible(true); // setAccessible(true)로 설정하지 않으면, private이기 때문에 해당 생성자를 호출할 수 없다.
            // 생성자를 여러 번 호출하면, 각기 다른 인스턴스가 생성된다.
            Elvis elvis1 = defaultConstructor.newInstance();
            Elvis elvis2 = defaultConstructor.newInstance();
            System.out.println(elvis1 == elvis2); // false
            System.out.println(elvis1 == Elvis.INSTANCE); // false // 생성된 인스턴스는 사용하길 원하는 Elvis 인스턴스와도 다르다.
            Elvis.INSTANCE.sing();
        } catch (InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
