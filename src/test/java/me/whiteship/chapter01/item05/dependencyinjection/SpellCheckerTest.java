package me.whiteship.chapter01.item05.dependencyinjection;

import me.whiteship.chapter01.item05.DefaultDictionary;
import me.whiteship.chapter01.item05.MockDictionary;
import org.junit.jupiter.api.Test;

class SpellCheckerTest {

    @Test
    void isValid() {
        /*
        의존 객체 주입을 사용한 코드.
        SpellChecker 코드 '외부'에서 해당 클래스가 사용하는 리소스, 즉 의존 객체를 주입해줄 수 있다.

        SpellChecker의 코드를 그대로 사용하면서, 테스트용으로 사용하고자 하는 다른 Dictionary로 얼마든지 교체가 가능하다.
         */
        SpellChecker spellChecker = new SpellChecker(MockDictionary::new);
        spellChecker.isValid("test");
    }

}