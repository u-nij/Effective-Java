package me.whiteship.chapter01.item01;

public class Character {

    private char values;

    private String color;

    // 자주 함께 사용되는 family, size 필드를 단순히 묶은 것.
    private Font font;

    public Character(char values, String color, Font font) {
        this.values = values;
        this.color = color;
        this.font = font;
    }
}
