package me.whiteship.chapter01.item05.factorymethod;

import me.whiteship.chapter01.item05.Dictionary;

import java.util.List;

// 클라이언트 코드
public class SpellChecker {

    /*
    Dictionary, DictionaryFactory 모두 인터페이스를 사용하기 때문에
    나중에 제품이 추가된다 하더라도 클라이언트 코드가 변경되지 않는다는 장점이 있다.
    (ex. MockDictionary를 리턴하는 팩터리 추가되더라도, SpellChecker 클래스는 바뀌지 않는다.)

    이러한 구조는 객체지향 원칙적으로 확장에 열려있고 변경에 닫혀있다.
    Dictionary 혹은 DictionaryFactory를 추가할 수 있다.
    하지만, 해당 인터페이스를 사용하는 클라이언트 코드는 변경하지 않고도 기능을 확장할 수 있다.
     */

    // 프로덕트 인터페이스
    private Dictionary dictionary;

    // 추상적인 인터페이스를 통해 프로덕트 리턴.
    public SpellChecker(DictionaryFactory dictionaryFactory) {
        this.dictionary = dictionaryFactory.getDictionary();
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
