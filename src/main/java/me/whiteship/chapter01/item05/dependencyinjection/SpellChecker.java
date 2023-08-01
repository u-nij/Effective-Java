package me.whiteship.chapter01.item05.dependencyinjection;

import me.whiteship.chapter01.item05.Dictionary;

import java.util.List;
import java.util.function.Supplier;

public class SpellChecker {

    /*
    리소스에 따라 달라지는 클래스를 의존 객체 주입을 사용해 만들 경우.

    의존성 주입을 받을 수 있는 생성자.
    해당 리소스를 어딘가에서 받을 수 있는 장치만 만들었을 뿐, 직접 리소스를 명시한 것은 아니다.

    => "Dictionary가 인터페이스일 때", Dictionary가 바뀐다 하더라도 SpellChecker의 모든 코드를 재사용 가능하다.
    Dictionary가 일반적인 클래스라면, KoreanDictionary와 EnglishDictionary의 메서드들이 서로 다를 수 있다.
    일반 클래스의 경우, 얼마든지 비슷한 기능의 다른 이름의 메서드를 만들 수 있다.

    Dictionary가 인터페이스이기 때문에 아래의 코드들은 재사용 가능한 코드가 된다.
    인터페이스에 호환한다는 가정 하에 KoreanDictionary 또는 EnglishDictionary으로 변경이 가능하며,
    어떠한 Dictionary 인터페이스의 구현체가 오더라도 'contains' 'closeWordsTo'는 절대 변하지 않는다.
     */
    private final Dictionary dictionary;

    // 의존성 주입을 받을 수 있는 생성자.
    public SpellChecker(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public SpellChecker(Supplier<Dictionary> dictionarySupplier) {
        this.dictionary = dictionarySupplier.get();
    }

    public boolean isValid(String word) {
        // TODO 여기 SpellChecker 코드
        return dictionary.contains(word);
    }

    public List<String> suggestions(String typo) {
        // TODO 여기 SpellChecker 코드
        return dictionary.closeWordsTo(typo);
    }
}
