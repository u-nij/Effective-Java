package me.whiteship.chapter01.item05.factorymethod;

import me.whiteship.chapter01.item05.DefaultDictionary;
import me.whiteship.chapter01.item05.Dictionary;

/*
DefaultDictionary를 만들어주는 팩터리.
구체적인 팩터리에서 구체적인 인터페이스를 만들어 리턴해wnsek.
 */
public class DefaultDictionaryFactory implements DictionaryFactory {
    @Override
    public Dictionary getDictionary() {
        return new DefaultDictionary();
    }
}
