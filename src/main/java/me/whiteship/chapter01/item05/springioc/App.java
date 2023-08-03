package me.whiteship.chapter01.item05.springioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {
        /*
        // Spring이 모르는 객체
        SpellChecker spellChecker1 = new SpellChecker();
         */

        /*
        Spring을 사용해 가져온 SpellCheck는 Spring Bean.
        Spring IoC Container인 ApplicationContext에서 가져왔고,
        그 ApplicationContext는 우리가 제공한 설정 파일을 통해 Bean들을 만들었기 때문에
        이 SpellCheck는 Spring이 만들어준 것.

        별도의 설정을 하지 않았기 때문에 싱글톤으로 만들어졌으며,
        스프링이 제공하는 라이프사이클 인터페이스를 거친다.

        SpellChecker와 SpringDictionary 어디에도 스프링과 관련된 코드는 들어가지 않는다.
        POJO를 유지한 상태에서, 외부인 App 클래스에서 인스턴스를 만들고 의존성을 주입해 꺼내 사용하기만 하면 된다.

         */
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        SpellChecker spellChecker = applicationContext.getBean(SpellChecker.class);
        spellChecker.isValid("test"); // contains test 출력 => 주입된 SpringDictionary가 사용되어 contains() 메서드가 호출되었기 때문.
    }
}
