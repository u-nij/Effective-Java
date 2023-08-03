package me.whiteship.chapter01.item05.dependencyinjection;

import me.whiteship.chapter01.item05.DefaultDictionary;
import me.whiteship.chapter01.item05.Dictionary;
import me.whiteship.chapter01.item05.MockDictionary;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

class SpellCheckerTest {

    @Test
    void isValid() {
        /*
        의존 객체 주입을 사용한 코드.
        SpellChecker 코드 '외부'에서 해당 클래스가 사용하는 리소스, 즉 의존 객체를 주입해줄 수 있다.
        SpellChecker의 코드를 그대로 사용하면서, 테스트용으로 사용하고자 하는 다른 Dictionary로 얼마든지 교체가 가능하다.

        메서드 레퍼런스의 타겟 타입이 SpellChecker(Supplier<Dictionary> dictionarySupplier)에 준하는 코드가 된다.
        (dictionarySupplier를 누르면 해당 생성자로 이동하는 것을 확인 가능)
         */
        Supplier<Dictionary> mockDictionary = MockDictionary::new;
        SpellChecker spellChecker = new SpellChecker(mockDictionary); // 타겟 타입이 Supplier 인터페이스인 메서드 참조
        SpellChecker spellChecker2 = new SpellChecker(DefaultDictionary::new);
        spellChecker.isValid("test");
    }

}