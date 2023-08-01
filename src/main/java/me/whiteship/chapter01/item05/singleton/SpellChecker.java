package me.whiteship.chapter01.item05.singleton;

import me.whiteship.chapter01.item05.DefaultDictionary;
import me.whiteship.chapter01.item05.Dictionary;

import java.util.List;

public class SpellChecker {

    /*
    싱글톤으로 내부에 객체를 만들어도 똑같은 문제갑 발생한다.

    또한, 유연성과 재사용성이 떨어진다.

     */
    private final Dictionary dictionary = new DefaultDictionary();

    private SpellChecker() {}

    public static final SpellChecker INSTANCE = new SpellChecker();

    public boolean isValid(String word) {
        // TODO 여기 SpellChecker 코드
        // 영어사전이 아닌, 한국어 사전을 쓰고 싶을 떄
        return dictionary.contains(word);
    }

    public List<String> suggestions(String typo) {
        // TODO 여기 SpellChecker 코드
        return dictionary.closeWordsTo(typo);
    }
}
