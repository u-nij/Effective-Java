package me.whiteship.chapter01.item05.dependencyinjection;

import me.whiteship.chapter01.item05.DefaultDictionary;
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

    /*
    자원 팩터리를 넘겨주는 방식
    public SpellChecker(DictionaryFactory dictionaryFactory) {
        this.dictionary = DictionaryFactory.get();
    }
    */

    /*
    매개변수 없이 무언가 가져오기만 하는 것이라면 팩터리를 만들 필요 없이, Supplier 인터페이스를 사용할 수 있다.
     */
    public SpellChecker(Supplier<Dictionary> dictionarySupplier) {
        this.dictionary = dictionarySupplier.get();
    }

    /*
    "한정적 와일드카드 타입을 사용해 팩터리의 타입 매개변수를 제한해야 한다."

    <? extends Dictionary>와 같은 선언을 통해,
    즉 제네릭 타입으로 Dictionary 타입에 호환하는 하위 타입 또한 가질 수 있다.
    Dictionary 타입만 받을 수 있는지, 해당 타입에 호환되는 하위 타입까지 받을 수 있는지 한정적 와일드 카드를 설정하라는 것.
    public SpellChecker(Supplier<? extends Dictionary> dictionarySupplier) {
        this.dictionary = dictionarySupplier.get();
    }

    타입을 한정하지 않았을 때도, 이미 Dictionary 타입을 리턴하는 모든 팩토리에는 맞게 된다.
    구체적인 타입의 Supplier에서 시작된 말이 아닐까 싶음. (ex. Supplier<DefaultDictionary>)

    Supplier<DefaultDictionary>  vs. Supplier<? extends Dictionary>
    전자와 같이 구체적으로 타입이 정해져 있다면, 다른 타입의 Dictionary를 만드는 것은 주입을 하지 못한다. Dictionary 타입만 받을 수 있다.
    후자와 같이 타입 한정자를 사용하게 되면, 하위 타입까지 더 폭넓게 받을 수 있기 때문.

    하지만, Dictionary 타입을 리턴하고 인터페이스를 구현했다면 Supplier<Dictionary>로도(즉, 타입 한정자를 사용하지 않아도) 충분하다.


    아마도 또다른 타입의 Dictionary 타입이 있다고 가정했을 때,
    SpeellCheckerTest의 SpellChecker 메서드가 "Supplier<DefaultDictionary>"를 통해 구체적인 타입의 Supplier를 받는게 아니라
    좀더 폭넓은 타입을 받기 위해 "Supplier<? extends Dictionary>"라고 설정했을 것이라 추축.
    public SpellChecker(Supplier<DefaultDictionary> dictionarySupplier) {
        this.dictionary = dictionarySupplier.get();
    }
    일 때, SpellCheckerTest의 "SpellChecker spellChecker = new SpellChecker(MockDictionary::new);" 코드가 에러가 난다.

    하지만 굳이, Supplier<? extends Dictionary> 라고 작성하지 않아도
    Dictionary 타입이고 인터페이스를 구현했다면 Supplier<Dictionary> 라고 작성해도 Dictionary 하위 타입에 호환되기만 하면 주입해줄 수 있다.
     */

    public boolean isValid(String word) {
        // TODO 여기 SpellChecker 코드
        return dictionary.contains(word);
    }

    public List<String> suggestions(String typo) {
        // TODO 여기 SpellChecker 코드
        return dictionary.closeWordsTo(typo);
    }
}
