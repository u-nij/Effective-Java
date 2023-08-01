package me.whiteship.chapter01.item05;

import java.util.List;

public interface Dictionary {

    boolean contains(String word);

    List<String> closeWordsTo(String typo);
}

/*
// Dictionary가 일반적인 클래스라면, KoreanDictionary와 EnglishDictionary의 메서드들이 서로 다를 수 있다.
// 인터페이스와 같은 규약이 없기 때문에.
// 얼마든지 비슷한 기능의 다른 이름의 메서드를 만들 수 있다.
public class Dictionary {

    public boolean contains(String word) {
        return false;
    }

    public List<String> closeWordsTo(String typo) {
        return null;
    }
}
 */
