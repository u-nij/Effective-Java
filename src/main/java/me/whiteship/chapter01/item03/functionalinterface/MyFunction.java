package me.whiteship.chapter01.item03.functionalinterface;

/*
함수형 인터페이스를 만드는 방법.

인터페이스 안에 오직 선언이 하나만 있으면 된다.
자바8 이후부터는 인터페이스 안에 default 메서드, static 메서드를 정의하는 것이 가능해졌다.
implementation이 비어있는 메서드 선언은 오직 하나만 가능하다.

이러한 메서드만 @FunctionalInterface 어노테이션을 붙일 수 있다. 마킹하기 위한 의도.
해당 어노테이션이 없어도 함수 인터페이스로 간주된다. 컴파일 타임에 체크해준다.
(어떻게 체크하는지 궁금하다면 어노테이션 프로세서에 대한 지식이 필요.)

*알아둬야 할 것
- 어떻게 함수형 인터페이스를 정의할 수 있는가.
- 자바에서 기본으로 제공하는 함수형 인터페이스는 어떠한 것들이 있는가.
*/
@FunctionalInterface
public interface MyFunction {

    String valueOf(Integer integer);

    static String hello() {
        return "hello";
    }
}
