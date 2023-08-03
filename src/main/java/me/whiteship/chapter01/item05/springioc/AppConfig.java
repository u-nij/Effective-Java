package me.whiteship.chapter01.item05.springioc;

import me.whiteship.chapter01.item05.Dictionary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
스프링이 제공하는 Configuration 어노테이션을 이용해, 스프링을 사용하기 위한 설정 파일 정의.
자바의 클래스 파일이지만, 스프링에게는 설정 파일.
 */
@Configuration // 스프링에게 필요한 설정 파일. 자바 설정 파일임을 명시.
/*
일일히 Bean을 정의하기 번거롭기 때문에 @ComponentScan을 사용.
인스턴스를 스프링이 관리하게 하려면 @Component을 붙여주고, 스프링 설정 파일에서 @ComponentScan을 사용한다.

@Component; Bean이 될 클래스와 Bean이 아닐 클래스를 구분하기 위한 마킹.
basePackageClasses; 해당 클래스가 위치한 곳에 있는 패키지부터 @Component 탐색.
 */
@ComponentScan(basePackageClasses = AppConfig.class)
public class AppConfig {

    /*
    @ComponentScan을 사용하지 않을 때

    SpellChecker는 이 Bean 설정 파일에 의해 스프링이 만들어주게 된다.
    스프링이 만들어준 SpellChecker를 꺼내야 스프링이 의존성 주입해준 SpellChecker를 꺼낼 수 있다.
    외부에서 new를 통해 SpellChecker를 생성하게 되면, 스프링은 그 SpellChecker를 모르게 된다.

    @Bean
    public SpellChecker spellChecker(Dictionary dictionary) { // 스프링이 관리하는 Dictionary를 넘겨줌.
        return new SpellChecker(dictionary);
    }

    @Bean
    public Dictionary dictionary() {
        return new SpringDictionary();
    }
     */
}
