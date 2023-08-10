package me.whiteship.chapter01.item08.outerclass;

import java.lang.reflect.Field;

// 정적이 아닌 중첩 클래스는 자동으로 바깥 객체의 참조를 갖는다.
public class OuterClass {

    private void hi() {

    }

    // static 키워드가 없다.
    //
    class InnerClass {

        public void hello() {
            /*
            InnerClass에서 OuterClass를 참조하는 방법.

            InnerClass에서 OuterClasss에 대한 참조를 가지고 있기 때문에
            얼마든지 OuterClass의 private 필드 및 메서드를 사용할 수 있다.

            또한, 중첩 클래스는 아우터 클래스의 필드 및 메서드를 호출하지 않아도 참조가 생긴다.
             */
            OuterClass.this.hi();
        }

    }

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        InnerClass innerClass = outerClass.new InnerClass();
        // OuterClass에 굉장히 종속적인 클래스

        System.out.println(innerClass);

        outerClass.printFiled(); // innerClass가 가진 모든 필드 출력
    }

    private void printFiled() {
        Field[] declaredFields = InnerClass.class.getDeclaredFields();
        for(Field field : declaredFields) {
            System.out.println("field type:" + field.getType());
            System.out.println("field name:" + field.getName());
        }
    }
}
