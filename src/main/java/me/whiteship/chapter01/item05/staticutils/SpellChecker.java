package me.whiteship.chapter01.item05.staticutils;

import me.whiteship.chapter01.item05.DefaultDictionary;
import me.whiteship.chapter01.item05.Dictionary;

import java.util.List;

public class SpellChecker {

    /*
    SpellChecker의 Dictionary라는 것은 바뀔 수 있다.
    한국어, 영어, 독일어.. 어떤 Dictionary인지에 따라 SpellChecker의 동작 방식이 달라지게 된다.

    SpellChecker 클래스의 동작을 확인하기 위해서는 Dictionary를 반드시 사용할 수밖에 없다.
    'new DefaultDictionary()' 자원을 직접 명시, 즉 직접 생성했기 때문.

    Dictionary 객체를 만들 떄 많은 비용이 발생한다면, 테스트 코드를 만드는 과정이 비효율적일 것.
    static 메서드는 mocking이 권장되지 않는다. mocking 기능을 사용하지 않고 풀어내는 것이 조금 더 객체지향적으로 문제를 푸는 방법.

    => 본인이 가지고 있는 리소스에 따라 동작이 달라지는 경우, "자원을 직접 명시하지 말고 의존 객체 주입을 사용하라"

     */
    private static final Dictionary dictionary = new DefaultDictionary(); // 자원을 직접 명시

    private SpellChecker() {}

    public static boolean isValid(String word) {
        // TODO 여기 SpellChecker 코드
        // SpellChecker의 코드가 없으면, dictionary 객체를 매핑해주는 역할밖에 없기 때문에 dictionary 객체를 직접 쓰는 것이 낫다.
        return dictionary.contains(word);
    }

    public static List<String> suggestions(String typo) {
        // TODO 여기 SpellChecker 코드
        return dictionary.closeWordsTo(typo);
    }
}
