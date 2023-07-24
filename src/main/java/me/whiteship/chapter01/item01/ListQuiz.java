package me.whiteship.chapter01.item01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListQuiz {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList();
        numbers.add(100);
        numbers.add(20);
        numbers.add(44);
        numbers.add(3);

        System.out.println(numbers);

        Comparator<Integer> desc = (o1, o2) -> o2 - o1;

        // 내림차순으로 정렬하는 Comparator를 만들고 List<Integer>를 정렬하라.
        numbers.sort(desc);
        // 질문1에서 만든 Comparator를 사용해서 오름차순으로 정렬하라
        numbers.sort(desc.reversed());

        System.out.println(numbers);
    }
}
