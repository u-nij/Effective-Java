package me.whiteship.chapter01.item05.staticutils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpellCheckerTest {

    @Test
    void isValid() {
        /*
        Dictionary 객체를 만들 떄 많은 비용이 발생한다면, 테스트 코드를 만드는 과정이 비효율적일 것.
        SpellChecker가 직접 명시한 Dictionary를 계속 만들어야 하기 때문.
         */
        assertTrue(SpellChecker.isValid("test"));
    }

}