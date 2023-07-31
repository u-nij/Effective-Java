package me.whiteship.chapter01.item03.functionalinterface;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class UsageOfFunctions {

    public static void main(String[] args) {
        List<LocalDate> dates = new ArrayList<>();
        dates.add(LocalDate.of(1982, 7, 15));
        dates.add(LocalDate.of(2011, 3, 2));
        dates.add(LocalDate.of(2013, 1, 28));

        /*
        람다 표현식과 메소드 참조에 대한 타겟 타입 정의

        Predicate, Function ; 자바에서 제공하는 기본 함수형 인터페이스(java.util.function.*)
        */
        Predicate<LocalDate> localDatePredicate = d -> d.isBefore(LocalDate.of(2000, 1, 1)); // 람다 표현식
        Function<LocalDate, Integer> getYear = LocalDate::getYear; // 메소드 참조
        List<Integer> before2000 = dates.stream()
                .filter(localDatePredicate) // filter -> 무언가를 걸어내는 작업 => boolean을 리턴하는 Predicate 타입의 함수 사용
                .map(getYear)
                .collect(Collectors.toList());
    }
}
