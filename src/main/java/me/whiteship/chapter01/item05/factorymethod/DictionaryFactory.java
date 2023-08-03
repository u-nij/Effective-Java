package me.whiteship.chapter01.item05.factorymethod;

import me.whiteship.chapter01.item05.Dictionary;

// Create Interface; Product를 만들어 줄 수 있는 팩터리.
public interface DictionaryFactory {

    Dictionary getDictionary();

}
