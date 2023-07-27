package me.whiteship.chapter01.item03.enumtype;

import java.lang.reflect.Constructor;

public class EnumElvisReflection {

    public static void main(String[] args) {
        try {
            /*
            애초에 생성자를 가져올 수 없다. (있는데) 없다고 NoSuchMethodException 예외 발생시킨다.
            Enum은 열거형이기 때문에 선언된 것만 사용할 수 있으며, 절대 new를 통해 Enum을 생성시킬 수 있도록 문법적으로 허용하지 않는다.
            리플렉션 API에도 이러한 것들이 반영되어 있기 때문에, 클래스 내부에서 getConstructor()를 호출할 때 막아두었다.
            따라서, 리플렉션을 방지하기 위한 별도의 수단을 쓰지 않아도 된다.
            */
            Constructor<Elvis> declaredConstructor = Elvis.class.getDeclaredConstructor();
            System.out.println(declaredConstructor);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
