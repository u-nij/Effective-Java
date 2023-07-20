package me.whiteship.chapter01.item01;

import java.awt.*;
import java.util.*;

public class FontFactory {

    private Map<String, Font> cache = new HashMap<>();

    /*
    같은 객체가 자주 사용되는 상황에서 플라이웨이트(Flyweight, 가벼운 체급) 패턴을 사용할 수 있다.
    객체를 가볍게 만들어 메모리 사용을 줄이는 패턴.
    자주 변하는 속성(외적인 속성, extrinsit)과 변하지 않는 속성(내적인 속성, instrinsit)을
    분리하고 재사용하du 메모리 사용을 줄일 수 있다.

    자주 사용하는 Font를 캐싱하여 재사용이 가능하도록 한 알고리즘.
    같은 Font일 때 새 인스턴스를 만드는 것이 아니라, 같은 것을 공유해서 사용.
    */
    public Font getFont(String font) {
        if(cache.containsKey(font)) {
            return cache.get(font);
        } else {
            String[] split = font.split(":");
            Font newFont = new Font(split[0], Integer.parseInt(split[1]));
            cache.put(font, newFont);
            return newFont;
        }
    }

}
